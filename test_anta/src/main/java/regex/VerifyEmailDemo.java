package regex;

import org.junit.jupiter.api.Test;
import org.testng.collections.Lists;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 内容描述：
 * 创建人：yang.liu
 * 创建时间：2019/7/3 16:54
 * 版本：1.0
 */
public class VerifyEmailDemo {

    /**
     * https://blog.csdn.net/liudglink/article/details/78511759
     */
    @Test
    public void testEmail() {
        String regex = "^[a-z0-9A-Z-_.]+@([a-z0-9A-Z-]+\\.)+[a-z0-9A-Z]{2,6}$";

        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern compile = Pattern.compile(regex);

        List<String> testSample = Lists.newArrayList(
                "441030517@QQcom",
                "119941779@qq,com",
                "5579001QQ@.COM",
                "1107531656@q?q?.com",
                "654088115@@qq.com",
                "495456580@qq@139.com",
                "279985462@qq。com.cn",
                "chen@foxmail.com)m",
                "2990814514@?￡QQ.COM",
                "xxxxxxxxx@___.com.cn",
                "xxxxxxxxx@wwew_163sadasdf.com.cn",

                "xxxxxxx@163.com",
                "xxxxxxxxx@wwew-163.com.cn",
                "hjkjhk@645654.2121-6878.com.wcn",

                "yang.liu@shuyun.com");

        testSample.stream().forEach(email -> {
            if (compile.matcher(email).find()) {
                System.out.println(email);
            }
        });

    }

}
