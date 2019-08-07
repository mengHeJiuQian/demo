package uuid;

import java.util.UUID;

/**
 * describe: 尝试将uuid压缩
 *
 * @author 梦合九千
 * @date 2018/12/16 10:10
 */
public class GenerateUUID {

    // 使用jdk自带的工具类生成一个36个字符长度的uuid
    public static String generateByJDK() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String compressUUID(String uuid) {
        uuid = uuid.replace("-", "");
        return new String();
    }

    public static byte[] hex2Bytes(String hex) {
        return hex.getBytes();
    }



    public static void main(String[] args) {
        // 8+4+4+4+12
        //Stream.generate(GenerateUUID::generateByJDK).limit(10).forEach(System.out::println);
        System.out.println(GenerateUUID.generateByJDK());
        System.out.println(generateByJDK().length());
        byte[] bytes = generateByJDK().getBytes();
        System.out.println(bytes.length);
    }
}
