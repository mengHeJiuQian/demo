package transfer;


import java.io.File;
import java.util.*;
/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/9/18 14:28
 */
public class Test {

    public static String prop = "静态成员";

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("构造代码块");
    }

    public Test() {
        System.out.println("构造函数");
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println(1*31);
        System.out.println((1<<5) - 1);

        Test t1 = new Test();
        Test t2 = new Test();
        //Test t2 = (Test) t1.clone();

        /**
         *     00000000 00000000 00000000 00000001
         *
         */

        int a = 1, b = 32;
        int c = a << 31;
        int d = c << 1;
        int e = a << 33;
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        String[] headers = {"手机号", "提交发送时间", "发送状态", "回复内容"};
        List<String> transfer = transfer(headers);
        System.out.println(transfer);
    }

    public static <E> List<E> transfer(E ... elements ) {
        ArrayList<E> list = new ArrayList<>();
        Collections.addAll(list, elements);
        return list;
    }

}
