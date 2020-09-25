
/**
 * 将两个升序的数组进行合并为一个数组，新的数组还是升序状态
 *
 */
public class Test {

    public static void main(String[] args) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader.getClass());

        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println(classLoader.getClass());
    }
}
