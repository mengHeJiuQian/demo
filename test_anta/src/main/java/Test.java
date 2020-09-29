import java.util.ArrayList;
import java.util.UUID;

/**
 * 将两个升序的数组进行合并为一个数组，新的数组还是升序状态
 *
 */
public class Test {

    public static void main(String[] args) {
//        ArrayList strings = new ArrayList();
//        strings.add("北京市");
//        strings.add("重庆市");
//        strings.add("河南省");
//        strings.add("天津市");
//        strings.add("上海市");

        ArrayList strings = new ArrayList();
        for (int i = 1; i <= 100; i++) {
            String format = String.format("%03d", i);
            String item = format + "-" + UUID.randomUUID().toString().replace("-", "");
            strings.add(item);
        }
        for (Object string : strings) {
            System.out.println(string);
        }
    }
}
