package _06_uuid;

import org.apache.commons.codec.binary.Base64;

import java.util.UUID;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2018/12/16 14:41
 */
public class UUIDUtil {

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println("uuid=" + uuid);

        String compress = compressedUUID(uuid);
        System.out.println(compress);

        String uncompress = uncompress(compress);
        System.out.println(uncompress);

        byte b1 = -5;
        long long1 = b1;
        long long2 = b1 & 0XFF;
        System.out.println(long1);
        System.out.println(long2);
    }

    protected static String compressedUUID(UUID uuid) {
        byte[] byUuid = new byte[16];
        long least = uuid.getLeastSignificantBits();
        long most = uuid.getMostSignificantBits();
        long2bytes(most, byUuid, 0);
        long2bytes(least, byUuid, 8);
        //String compressUUID = Base64.encodeBase64URLSafeString(byUuid);
        String compressUUID = Base64.encodeBase64String(byUuid);
        return compressUUID;
    }

    protected static void long2bytes(long value, byte[] bytes, int offset) {
        for (int i = 7; i > -1; i--) {
            bytes[offset++] = (byte) ((value >> 8 * i) & 0xFF);
        }
    }

    public static String uncompress(String compressedUuid) {
//        if (compressedUuid.length() != 22) {
//            throw new IllegalArgumentException("Invalid uuid!");
//        }
        byte[] byUuid = Base64.decodeBase64(compressedUuid);
        long most = bytes2long(byUuid, 0);
        long least = bytes2long(byUuid, 8);
        UUID uuid = new UUID(most, least);
        return uuid.toString();
    }

    protected static long bytes2long(byte[] bytes, int offset) {
        long value = 0;
        for (int i = 7; i > -1; i--) {
            value |= (((long) bytes[offset++]) & 0xFF) << 8 * i;
        }
        return value;
    }

}
