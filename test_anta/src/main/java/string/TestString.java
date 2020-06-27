package string;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/13 14:14
 */
public class TestString {

    @Test
    public void testSubString() {
        String serviceCode = "7F8441F2-3B2D-4EAE-925D-AFD4CCF1B98A";
        String substring = serviceCode.substring(0, serviceCode.indexOf("_"));
        System.out.println(substring);
    }


    @Test
    public void testEmoji() {
        String emoji = "%E2%98%A3%EF%B8%8E%E2%98%A2%EF%B8%8E%E2%9C%8C%F0%9F%87%A6%F0%9F%87%B1%F0%9F%87%A9%F0%9F%87%BF%F0%9F%87%A9%F0%9F%87%BF%F0%9F%87%A9%F0%9F%87%BF%F0%9F%87%A9%F0%9F%87%BF";
        System.out.println();
        System.out.println(emoji.getBytes().length);
        List<String> list = Lists.newArrayList("a","b","c");
        Object[] a = list.stream().filter(s -> s.equals("a")).toArray();
        System.out.println(a);

    }

    private  static  String generatePrepareStatementValueSql(int paramNum) {
        StringBuilder prepareStatementValueSql = new StringBuilder("(");
        for (int i = 1; i <= paramNum; i++) {
            prepareStatementValueSql.append("?,");
        }
        prepareStatementValueSql.deleteCharAt(prepareStatementValueSql.length() - 1);
        prepareStatementValueSql.append(")");
        return prepareStatementValueSql.toString();
    }

    public static void main(String[] args) {
        String s = generatePrepareStatementValueSql(7);
        System.out.println(s);
    }

    @Test
    public void testReplace() {
        String sql = "select * from table where id in('1','2')";

        sql = sql.replaceAll("'", "\"");
        System.out.println(sql);
    }


    @Test
    public void testJoin() {
        List<String> ruleSqlList = new ArrayList<>();
        ruleSqlList.add("select store_no,store_name,store_type_name,store_source,status  from plt_skx_store  where 1=1  and store_no in ('DL03-A-DF-01','TES4-A-DF-03A')");
        ruleSqlList.add("select store_no,store_name,store_type_name,store_source,status  from plt_skx_store  where 1=1  and store_no in ('SA44','SA43') ");

        ruleSqlList.forEach(sql -> sql.replaceAll("'", "\""));
        String join = StringUtils.join(ruleSqlList, " union ");
        System.out.println(join);
    }

    @Test
    public void testStringEqualsObject() {
        Object str1 = "123";
        String str2 = "123";
        System.out.println(str2.equals(str1));
    }


    @Test
    public void testTrim() {
        String tel = " 131 7598 3201 ";
        tel = null;
        String trim = tel.trim();
        System.out.println(tel);
        System.out.println(trim);
    }


    /**
     * 复现权益商品选择器中“只显示选中按钮”的bug
     */
    @Test
    public void testSelectIds() {
        String selectedIds = "000000000731800010,101116-1/36,101116-1/37,";
        int num = selectedIds.length() - selectedIds.replaceAll(",", "").length();
        num = selectedIds.charAt(selectedIds.length() - 1) == ',' ? num : ++num;
        //int length = selectedIds.length();
        //int num = (',' == selectedIds.charAt(selectedIds.length() - 1)) ?
//        int replaceAll = selectedIds.replaceAll(",", "").length();
//        int num = length - replaceAll + 1;
        System.out.println(num);
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

    /**
     * 测试字符串包含
     */
    @Test
    public void testcontentEquals() {
        String scope = "OFFICAL_SITE";
        String wx = "WECHAT_MALL";
        String site = "OFFICAL_SITE";

        String wxId = "";
        String siteId = "1";
        if (scope.contains(wx) && StringUtils.isEmpty(wxId)) {
            return ;
        }
        if (scope.contains(site) && StringUtils.isEmpty(siteId)) {
            return ;
        }
        System.out.println("success");
    }


}
