package number.uniqueid;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/31 15:37
 * 版本：1.0
 * 内容描述：
 */
public class GenerateIdTest {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        System.out.println(set.add("aaa"));
        System.out.println(set.size());
        System.out.println(set.add("aaa"));
        System.out.println(set.size());
        boolean aaa = set.contains("aaa");
        System.out.println(aaa);
    }

    private static final int TEST_NUM = 10_0000;
    private static final int val = 1;
    @Test
    public void testUUID() {
        Map<String, Integer> map = new ConcurrentHashMap<>(TEST_NUM);

        class ID implements Runnable{
            @Override
            public void run() {
                for (int i = 0; i < TEST_NUM; i++) {
                    UUID uuid = UUID.randomUUID();
                    String id = uuid.toString();
                    if (map.containsKey(id)) {
                        System.out.println(id);
                        System.out.println(map.containsKey(id));
                    } else {
                        map.put(id, val);
                    }
                }
            }
        }

        for (int i = 0; i < 50; i++) {
            new Thread(new ID()).start();
        }


    }

    public static String generateSequenceID(){
        String uuid = UUID.randomUUID().toString();
//        String ranEight = String.format("%08d", new Random().nextInt(99999999));
//        System.out.println(uuid +"--"+ ranEight);
        return uuid;
    }
}
