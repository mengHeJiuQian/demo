package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
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
        String regex = "";
        Matcher m = Pattern.compile(regex).matcher(address);
        String town = null, village = null;
        List<String> table = new ArrayList<>();
        return table;
    }

    public static void main(String[] args) {
        System.out.println(addressResolution("北京北京市朝阳区"));
        System.out.println(addressResolution("湖北省武汉市洪山区"));
        System.out.println(addressResolution("北京北京市东城区岚皋路"));
    }

}
