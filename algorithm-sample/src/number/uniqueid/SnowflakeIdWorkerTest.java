package number.uniqueid;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/31 19:44
 * 版本：1.0
 * 内容描述：
 */
public class SnowflakeIdWorkerTest {

    public static void main(String[] args) {
        SnowflakeIdWorker snow = new SnowflakeIdWorker(5, 5);
        for (int i = 0; i < 100; i++) {
            System.out.println(snow.nextId());
        }
    }

}
