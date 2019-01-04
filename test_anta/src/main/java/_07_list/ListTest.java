package _07_list;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2018/12/25 20:26
 */
public class ListTest {

    public static final int TEST_NUM = 1000_000; // 测试量

    public static void main(String[] args) {
        ArrayList a = new ArrayList(10);
        for (int i = 0; i < 10; i++) {
            a.add(i + 1);
        }
        System.out.println(a.size());
        System.out.println();

        // ArrayListTest();
        // CopyOnWriteArrayListTest();
        LinkedListTest();
    }

    public static void ArrayListTest() {
        ArrayList copy = new ArrayList();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUM; i++) {
            copy.add(i + 1);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("ArrayList-测试数据量：" + TEST_NUM + "，用时：" + (t2 - t1) + "毫秒");
    }

    public static void CopyOnWriteArrayListTest() {
        CopyOnWriteArrayList copy = new CopyOnWriteArrayList();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUM; i++) {
            copy.add(i + 1);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("CopyOnWriteArrayList-测试数据量：" + TEST_NUM + "，用时：" + (t2 - t1) / 1000 + "秒");
    }

    public static void LinkedListTest() {
        LinkedList copy = new LinkedList();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUM; i++) {
            copy.add(i + 1);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("LinkedList-测试数据量：" + TEST_NUM + "，用时：" + (t2 - t1) + "毫秒");
    }
}
