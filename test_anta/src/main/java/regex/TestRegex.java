package regex;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/28 11:40
 */
@Slf4j
public class TestRegex {


    @Test
    public void regex() {
        System.out.println("%".replaceAll("%", "\\\\%"));

        System.out.println("\\");
    }

    /**
     * 测试 String pStr = "\\((.*?)\\)";//获取括号"()"中的内容
     */
    @Test
    public void test1() {
        String regex = "\\((.*?)\\)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher("CREATE TABLE `t1` (  `name` varchar(20) DEFAULT NULL,  `age` int(11) DEFAULT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8");

        boolean matches = m.matches(); //尝试将整个输入序列与该模式匹配。
        String column = null;
        while (m.find()) {
            column = m.group();
            break;
        }
        System.out.println(column);

    }

    public static void main(String[] args) {
        Pattern REGEX_MOBILE_NODE = Pattern.compile("^(13[0-9]|14[0-9]|15[0-9]|18[0-9]|17[0-9]){1}\\d{8}$");
        Pattern MOBILE_N = Pattern.compile("^0?1[3-9]\\d{9}$");
        Pattern MOBILE_EPASSPORT = Pattern.compile("0?(13|14|15|18|17)[0-9]{9}");
        Pattern MOBILE_E = Pattern.compile("0?(13|14|15|16|17|18|19)[0-9]{9}");

        // MYSQL_REGEX_MOBILE("'^(1[3,4,5,6,7,8,9]){1}[0-9]{9}$'");

        //Pattern pattern = ContactValidatorRegex.JAVA_REGEX_EMAIL.getPattern();

        String[] mobiles = {"25038709853", "15645656535", "13175983201", "17506072130", "19968075524", "1996807552", "199680755222",
                "01317598320", "013175983201"};

        for (int i = 0; i < mobiles.length; i++) {
            if (!MOBILE_N.matcher(mobiles[i]).matches()) {
                log.info("手机号输入有误，可输入符合规则手机号, {}。", mobiles[i]);
            }
        }


        List<String> needDistributorSubmit = Lists.newArrayList("tdiscountECANTA", "tcommunicateWechat");
        String typeSql = needDistributorSubmit.stream()
                .map(metaNode -> "'" + metaNode + "'")
                .collect(Collectors.joining(",", "(", ")"));


        StringBuffer sql = new StringBuffer();
        sql.append("select count(1) from campaign_entry camp, workflow_node wn ")
                .append("where camp.workflow_id = wn.workflow_id ")
                .append("and wn.type in " + typeSql + " ")
                .append("and camp.id = ")
                .append("10000400");
        System.out.println(sql);

        System.out.println(needDistributorSubmit.toString());



        ArrayList list = new ArrayList();
        list.add("a");
        list.add("d");
        list.add("c");
        System.out.println(StringUtils.join(list,"," ));
        System.out.println("list=" + list);
        List nonExist = filterNonExist(list);
        System.out.println(nonExist);
        list.removeAll(nonExist);
        System.out.println(list);
        //System.out.println(JSONUtils.toJSONString(list));
    }

    public static List<String> filterNonExist(List<String> idList) {
        idList = Lists.newArrayList(idList); // 所有的
        List<String> exist = Lists.newArrayList("a"); //查询得到的
        idList.removeAll(exist);
        return idList;
    }


    // 测试 hibernate Validator 中的 @Pattern
    // @Pattern(regex=,flag=) 被注释的元素必须符合指定的正则表达式
    @Test
    public void testPattern() {
        Pattern pattern = Pattern.compile("^NO_LIMIT|LIMIT_PRODUCT$");
        System.out.println(pattern.matcher("NO_LIMIT").matches());
        System.out.println(pattern.matcher("LIMIT_PRODUCT").matches());
        System.out.println(pattern.matcher("NT").matches());
    }

    @Test
    public void testPatternNULL() {
        Pattern pattern = Pattern.compile("^NO_LIMIT|LIMIT_PRODUCT$");
        System.out.println(pattern.matcher(null).matches());  // NullPointerException
        System.out.println(pattern.matcher("LIMIT_PRODUCT").matches());
        System.out.println(pattern.matcher("NT").matches());
    }

    @Test
    public void testReplact() {
        String rulesSql = " select store_no,store_name,store_type_name,store_source,status  from plt_skx_store  where 1=1  and store_no in (\"NDLF\",\"SG15\") ";
        log.info("规则sql:{}.", rulesSql);
        String afterReplace = rulesSql.replaceAll("select.*from", " select * from ");
        log.info("规则afterReplace:{}.", afterReplace);
    }
}
