package thread.objectMethod;

/**
 * 测试Object方法的一些使用场景
 */
public class ObjectDemo {

    public static void main(String[] args) {
        ObjectDemo demo = new ObjectDemo();
        synchronized (demo) {
            boolean b = Thread.holdsLock(demo);

            System.out.println(b);
        }
    }


}
