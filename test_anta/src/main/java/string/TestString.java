package string;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/13 14:14
 */
public class TestString {

    public static void main(String[] args) {
        Object obj = "大货";
        System.out.println(String.valueOf(obj));
        System.out.println((String) obj);

        String str = "123";
        System.out.println(new String(str.getBytes()));

        int flag = 1;
        if (flag++ % 2 == 0) {
            System.out.println("抛出异常");
        }
        long l = 12;
        System.out.println(String.valueOf(l));

    }

    @Test
    public void joinString() {
        List<String> idList = new ArrayList<>();
        idList.add("aa");
        idList.add("bb");
        idList.add("cc");
        String join = StringUtils.join(idList, ",");
        System.out.println(join);
    }

    @Test
    public void twoList() {
        List<String> l1 = new ArrayList<>();
        l1.add("aa");
        l1.add("bb");
        l1.add("cc");
        String join = StringUtils.join(l1, ",");
        System.out.println(join);
        List<String> l2 = new ArrayList<>();
        l2.add("aa");
        l2.add("bb");
        l2.add("");
        boolean b = l1.removeAll(l2);
        System.out.println(l1);
    }

}
