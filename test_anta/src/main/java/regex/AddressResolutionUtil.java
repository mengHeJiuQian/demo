package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author yang.liu
 * @createtime 2020/9/27 12:43
 * @description
 */
public class AddressResolutionUtil {

    /**
     * 解析地址
     * @author lin
     * @param address
     * @return
     */
    public static List<String> addressResolution(String address){
        String regex = ".*?(路|乡|镇|园)";
        // Matcher m = Pattern.compile(regex).matcher(address);
        boolean matches = Pattern.matches(regex, address);
        System.out.println(matches);
        List<String> table = new ArrayList<>();
        return table;
    }

    public static void main(String[] args) {
        System.out.println(addressResolution("五宝路心愿公寓25楼"));
        System.out.println(addressResolution("光山县白雀园"));
        System.out.println(addressResolution("光山县白雀园镇"));
        System.out.println(addressResolution("光山县凉亭乡"));
    }

}
