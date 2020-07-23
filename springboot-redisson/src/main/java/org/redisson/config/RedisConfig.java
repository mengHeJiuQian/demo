package org.redisson.config;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class RedisConfig {

    private static int count = 0;

    private String address = "47.100.117.86:6379";
    private String password = "961113";
//    private String poolSize= "20";
//    private String database= "10";

    public RedissonClient getRedission(){
        RedissonClient redissonClient = null;
        if(StringUtils.isNotEmpty(address)&& address.indexOf(",") > 0){
            redissonClient = getMultiRedis(address.split(","));
        }else{
            redissonClient = getSingleRedis(address);
        }
        return redissonClient;
    }


    // 单点 redis
    public RedissonClient getSingleRedis(String address){
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress(address);
        if(StringUtils.isNotEmpty(password)){
            singleServerConfig.setPassword(password);
        }
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }

    // 集群redis
    public RedissonClient getMultiRedis(String[] addresses){
        Config config = new Config();
        ClusterServersConfig clusterServersConfig = config.useClusterServers();
        clusterServersConfig.setScanInterval(2000).addNodeAddress(addresses);
        if(StringUtils.isNotEmpty(password)){
            clusterServersConfig.setPassword(password);
        }
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }

    public static void main(String[] args) throws InterruptedException {
        String address = "redis://47.100.117.86:6379";

        Config config = new Config();
        config.useSingleServer().setAddress(address).setPassword("961113");
        RedissonClient redisson = Redisson.create(config);
        System.out.println(redisson);

        int nThreads = 500;
        ExecutorService exec = Executors.newFixedThreadPool(nThreads);

        List tasks = new ArrayList(nThreads);
        for (int i = 0; i < nThreads; i++) {
            tasks.add((Callable) () -> {
                Thread.sleep(10); //代替处理业务的时间

                RLock lock = redisson.getLock("redis");
                try {
                    boolean b = lock.tryLock(60, TimeUnit.SECONDS);
                    if (b) {
                        ++RedisConfig.count;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

                return RedisConfig.count;
            });
        }

        exec.invokeAll(tasks);
        exec.shutdown();

        while (true) {
            if (exec.isTerminated()) {
                System.out.println("所有的子线程都结束了！");
                break;
            }
        }
        System.out.println("count = " + count);
        redisson.shutdown();
    }



}