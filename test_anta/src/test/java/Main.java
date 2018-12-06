import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Collections.singleton(null);
        StringBuffer sb= new StringBuffer("update checklist set ");
        sb.append("group_id='").append("?").append("',");
        sb.append("entry_mode ='").append("?").append("',");
        sb.append("last_update ='").append("?").append("',");
        sb.append("last_operator ='").append("?").append("',");
        sb.append("remark ='").append("?").append("',");
        sb.append("system_code ='").append("?").append("' ");

        sb.append("where `type` = '").append("?").append("' ");
        sb.append("and subject_id = '").append("?").append("' ");
        sb.append("and customerno= '").append("?");
        sb.append("and brand_code ='").append("?").append("';");
        System.out.println(sb.toString());

        test("1", "a","b");

        String str = "abcd";
        System.out.println(str.substring(0,1).toUpperCase());
        System.out.println(str.substring(1));
    }

    public static void test(String a, String... args) {
        System.out.println(a);
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        List<String> s = new ArrayList<>();
        s.add("7");
        s.add("8");
        System.out.println(s.toString());

    }
}
