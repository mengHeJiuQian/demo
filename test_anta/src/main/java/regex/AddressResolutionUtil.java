package regex;

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
    public static void addressResolution(String address){
        String town = null, detailAddress = null;
        if (true) {
            // []是单字符匹配，()是多字符匹配
            String regex = "(.*?(园镇|乡镇|路|乡|镇|园)).*";
            Matcher matcher = Pattern.compile(regex).matcher(address);
            boolean find = matcher.find();
            if (find) {
                town = matcher.group(1);
                detailAddress = address.substring(town.length());
            } else {
                detailAddress = address;
            }
        }
        System.out.println("address:" + address);
        System.out.println("town:" + town);
        System.out.println("detailAddress:" + detailAddress);
        System.out.println("------------");
    }

    public static void main(String[] args) {
        addressResolution("江山路明发  滨江新城353栋801室（宿舍      ）                                                                                        ");
        addressResolution("五宝路心愿公寓25楼");
        addressResolution("白雀园");
        addressResolution("白雀园新园公寓25楼");
        addressResolution("白雀园镇新园公寓25楼");
        addressResolution("凉亭乡");
        addressResolution("心愿公寓25楼");
    }

}
