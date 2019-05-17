package exception;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/4/24 11:20
 */
public class TryCatchException {

    public void testTry() {
        if (true) {
            throw new RuntimeException();
        }
    }
}
