package _01_regex;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/28 11:40
 */
@Slf4j
public class TestRegex {
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

    }
}
