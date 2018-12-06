package lambda;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/9/7 15:01
 */
public class OrElseTest {

    static String B() {
        System.out.println("B()...");
        return "B";
    }

    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        System.out.println(a.size());

        System.out.println(new Date());
//        System.out.println(Optional.of("A").orElse("B"));
//        System.out.println(Optional.of("A").orElseGet(() -> B()));
        //System.out.println(Optional.of("A").orElse(B()));
        //System.out.println(Optional.of("A").orElseGet(() -> B()));

        System.out.println(Optional.ofNullable(null).orElse(B()));      // 输出B()... B
        System.out.println(Optional.ofNullable("A").orElse(B()));       // 输出B()... A

        // System.out.println(Optional.ofNullable(null).orElseGet(()->B())); // 输出B()... B
         System.out.println(Optional.ofNullable("A").orElseGet(()->B()));  // A
    }

}
