package recursive;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/27 17:26
 */
public class TestRecursive {
    public static void main(String[] args) {
        int recursion = 0;
        long start = System.currentTimeMillis();
        recursion(recursion);
        long end = System.currentTimeMillis();
        System.out.println("使用了" + (end - start) + "毫秒");

    }
    public static void recursion(int i) {
        if (i == 60) {
            //System.out.println("递归" + i + "次");
            return;
        } else {
            System.out.println("递归" + ++i + "次");
            recursion(i);
        }
    }
}
