package exception;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/9/5 13:08
 */
public class Business {

    public void throwAException() {
        try {
            int i = 9 / 0;
        } catch (Exception e) {

        }
    }

}
