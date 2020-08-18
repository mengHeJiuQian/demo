package core1.chapter05.wrapper;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/1/5 15:23
 */
public class WrapperTest {

    private static int TEST_NUM = 10_000_000;

    public static void main(String[] args) {
        Integer i = 0;
        i++;

        Character c1 = 'd';
        Character c2 = 'd';
        System.out.println(c1 == c2);

        testInt();
        testInteger();
    }

    public static void testInt() {
        int[] arr = new int[TEST_NUM];
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUM; i++) {
            arr[i] = i;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("int---用时：" + (t2 - t1) + "毫秒");
    }

    public static void testInteger() {
        Integer[] arr = new Integer[TEST_NUM];
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUM; i++) {
            //arr[i] = i;
             arr[i] = new Integer(i);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Integer---用时：" + (t2 - t1) + "毫秒");
    }
}
