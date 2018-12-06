/*
 * *************************************************************************************
 *
 *   Project:        ZXQ
 *
 *   Copyright ©     2014-2017 Banma Technologies Co.,Ltd
 *                   All rights reserved.
 *
 *   This software is supplied only under the terms of a license agreement,
 *   nondisclosure agreement or other written agreement with Banma Technologies
 *   Co.,Ltd. Use, redistribution or other disclosure of any parts of this
 *   software is prohibited except in accordance with the terms of such written
 *   agreement with Banma Technologies Co.,Ltd. This software is confidential
 *   and proprietary information of Banma Technologies Co.,Ltd.
 *
 * *************************************************************************************
 *
 *   Class Name: com.zxq.iov.cloud.sp.debit.common.util.id.BasicEntityIdGenerator
 *
 *   General Description:
 *
 *   Revision History:
 *                            Modification
 *    Author                Date(MM/DD/YYYY)   JiraID           Description of Changes
 *    *********************   ************    **********     *****************************
 *    raven                   2017-01-23
 *
 * **************************************************************************************
 */

package uniqueCoupon;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * BasicEntityIdGenerator
 *
 * @author Maxim Khodanovich
 * @version 21.01.13 17:16
 *          <p/>
 *          id is composed of:
 *          time - 41 bits (millisecond precision w/ a custom epoch gives us 69 years)
 *          configured machine id - 10 bits - gives us up to 1024 machines
 *          sequence number - 12 bits - rolls over every 4096 per machine (with protection to avoid rollover in the same ms)
 */
public class BasicEntityIdGenerator implements EntityIdGenerator {

    //   id format  =>
//   timestamp |env|datacenter | sequence
//   41        |3  |9          |  10
    private static final long sequenceBits = 10;
    private static final long datacenterIdBits = 9L;
    private static final long envIdBits = 3L;
    private static final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    private static final long datacenterIdShift = sequenceBits;
    private static final long envIdShift = sequenceBits + datacenterIdBits;
    private static final long timestampLeftShift = sequenceBits + datacenterIdBits + envIdBits;
    private static final long twepoch = 1288834974657L;
    private static final long sequenceMax = 1024;
    private static final long envId = 1L;//test env
    private static BasicEntityIdGenerator basicEntityIdGenerator;
    private final long datacenterId;
    private volatile long lastTimestamp = -1L;
    private volatile long sequence = 0L;

    private BasicEntityIdGenerator() throws Exception {
        datacenterId = getDatacenterId();
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new Exception("datacenterId > maxDatacenterId");
        }
    }

    public static BasicEntityIdGenerator getInstance() throws Exception {
        if (basicEntityIdGenerator == null) basicEntityIdGenerator = new BasicEntityIdGenerator();
        return basicEntityIdGenerator;
    }

    public static void main(String[] args) {
        try {
            String test = BasicEntityIdGenerator.getInstance().generateLongId();
            System.out.println(test);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized String generateLongId() throws Exception {
        long timestamp = System.currentTimeMillis();
        if (timestamp < lastTimestamp) {
            throw new Exception("Clock moved backwards.  Refusing to generate id for " + (
                    lastTimestamp - timestamp) + " milliseconds.");
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) % sequenceMax;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = timestamp;
        Long id = ((timestamp - twepoch) << timestampLeftShift) |
                (envId << envIdShift) |
                (datacenterId << datacenterIdShift) |
                sequence;
        return id.toString();
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    protected long getDatacenterId() throws Exception {

        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            long id;
            if (network == null) {
                id = 1;
            } else {
                byte[] mac = network.getHardwareAddress();
                id = ((0x000000FF & (long) mac[mac.length - 1]) | (0x0000FF00 & (((long) mac[mac.length - 2]) << 8))) >> 7;
            }
            return id;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}