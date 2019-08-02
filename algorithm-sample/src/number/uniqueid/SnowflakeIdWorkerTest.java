package number.uniqueid;

import org.junit.jupiter.api.Test;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/31 19:44
 * 版本：1.0
 * 内容描述：
 */
public class SnowflakeIdWorkerTest {

    public static void main(String[] args) {
        SnowflakeIdWorker snow = new SnowflakeIdWorker(5, 5);
        int count = 0;
        long start = System.currentTimeMillis(), end;
        while (true) {
            end = System.currentTimeMillis();
            if (end - start < 1000) {
                System.out.println(snow.nextId());
                count++;
            } else {
                break;
            }
        }
        System.out.println("snowflake一秒内生成唯一ID个数为" + count);
    }

    @Test
    public void test() {
        System.out.println(System.currentTimeMillis());
    }

}
