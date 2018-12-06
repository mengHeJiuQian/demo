package exception;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/9/5 13:05
 */
public class Main {

    public static void main(String[] args) {
        Business business = new Business();
        System.out.println("异常出现前");
        business.throwAException();
        System.out.println("异常出现后");
    }

}
