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
        System.out.println("address:" + address);
        String town = null, detailAddress = null;
        if (true) {
            // []是单字符匹配，()是多字符匹配
            String regex = "(.*?(园镇|乡镇|路|乡|镇)).*";
            Matcher matcher = Pattern.compile(regex).matcher(address);
            if (matcher.find()) {
                town = matcher.group(1);
                address = address.substring(town.length());
            }
            detailAddress = address;
        }

        System.out.println("town:" + town);
        System.out.println("detailAddress:" + detailAddress);
        System.out.println("------------");
    }

    public static void main(String[] args) {
        addressResolution("北京市丰台区南四环西路188号1区31号楼");
        addressResolution("北京朝阳区南十里居28号东润枫景");
        addressResolution("北京市西城区裕民中路12号(原北三环宾馆)1-3层");
        addressResolution("北京市西城区西直门南大街2号成铭大厦D座4层");
        addressResolution("北京市朝阳区朝阳公园南路21号郡王府。朝阳公园桥西北角（郡王府体育中心）");
        addressResolution("北京市海淀区北四环西路52号方正国际大厦2层");
        addressResolution("北京市东城区珠市口东大街6号珍贝大厦2层");
        addressResolution("北京市朝阳区安立路西侧慧忠京师科技大厦2层");
        addressResolution("北京市朝阳区建华南路17号现代柏联大厦2层；南邻通惠河北路");
        addressResolution("北京市西城区莲花池东路甲5号院1号楼二层");
        addressResolution("北京市西城区西直门南大街2号成铭大厦D座5层");
        addressResolution("北京市顺义区顺平路南法信镇顺捷大厦A座二层203室");
        addressResolution("北京市朝阳区将台路6号丽都维景酒店商业楼5号3层");
        addressResolution("广州市天河区珠江新城花城大道7号南天广场商务中心5层（南天珠宝世界）");
        addressResolution("广州市天河区林和西路中泰国际广场商场5层");
        addressResolution("广州市天河区中山大道东方一路20-24号华港花园3层（BRT华景新城站）");
        addressResolution("广州市越秀区环市东路496号广发花园大厦3层（国宾健康检查中心）");
        addressResolution("上海长宁区定西路1018号3层");
        addressResolution("上海市杨浦区国宾路36号万达广场B座6层");
        addressResolution("上海市静安区康定路1437号（鑫康苑）2层");
        addressResolution("上海市黄浦区西藏南路770号（安基大厦）裙楼");
        addressResolution("上海市普陀区真光路1288号百联中环购物广场4层B区");
        addressResolution("上海市长宁区天山路30号（天山大厦）3层");
        addressResolution("上海市黄浦区江西南路29号工商联大厦2层");
        addressResolution("上海市浦东新区张杨路560号（中融恒瑞大厦）6楼西区");
        addressResolution("上海市浦东新区商城路1900号金桃大厦1-2层（源深体育场北）");
        addressResolution("天津市和平区南京路209号吉利大厦9层");
        addressResolution("天津市南开区南马路与南门外大街交口中粮广场6层");
        addressResolution("天津市河东区六纬路与大直沽八号路交口东润大厦4层");
        addressResolution("天津市河西区围堤道103号峰汇广场B座5层");
        addressResolution("重庆市江北区福康路25号龙湖.源著天街6楼");
        addressResolution("沈阳市沈河区青年大街166号");
        addressResolution("沈阳市和平区太原南街236号");
        addressResolution("南京市鼓楼区中央路19号金峰大厦3层");
        addressResolution("南京市浦口区江浦街道浦口大道1号新城总部大厦305、306、307、308、309、310");
        addressResolution("南京市江宁区双龙大道1118号金轮新都汇2层");
        addressResolution("南京市中山东路145号全民健身中心19层");
        addressResolution("武汉市江汉区后襄河二路59号海马中心写字楼商业裙楼三层");
        addressResolution("成都市高新区天韵路高新国际广场D座3层");
        addressResolution("成都市青羊区青龙大街18号罗马国际大厦4楼");
        addressResolution("成都市高新区吉泰三路8号新希望国际C座3楼");
        addressResolution("成都市锦江区人民南路一段新光华街7号航天科技大厦5层");
        addressResolution("成都市龙泉驿区大面街道金桉路88号百悦国际中心8-9楼");
        addressResolution("成都市武侯区二环路西一段置信路1号置信逸都城5层");
        addressResolution("西安市雁塔区慈恩西路南段曲江六号东门1-3层");
        addressResolution("长春市宽城区贵阳街287号建设大厦3楼（建设大厦原吉林省政务大厅南门）");
        addressResolution("无锡市新吴区长江路1-101号茂业百货F层");
        addressResolution("江阴市临港街道苏港路99号江阴检验检疫局1-2层");
        addressResolution("镇江市长江路33号镇江广电大厦裙楼3层");
        addressResolution("苏州工业园区东环路1408号东环时代广场商业裙楼2层");
        addressResolution("苏州高新区运河路77号乐嘉汇商务广场2幢101");
        addressResolution("常州市新北区龙锦路1268号B座座2-3楼");
        addressResolution("青岛市市北区敦化路138号西王大厦西侧门301、401户");
        addressResolution("烟台市开发区长江路97号国家羽毛球训练基地（东门）");
        addressResolution("烟台市芝罘区解放路156号世茂广场三楼");
        addressResolution("烟台市莱山区港城东大街588号第三城国际大厦副楼1-3层");
        addressResolution("潍坊市高新区卧龙东街与东方路交汇处");
        addressResolution("潍坊市奎文区民生东街66号（原凯远大厦）");
        addressResolution("芜湖市黄山中路64号鼎湖1876国际文化旅游广场2号楼4-5层");
        addressResolution("杭州市滨江区江南大道588号恒鑫大厦裙楼2层");
        addressResolution("杭州市下城区文晖路108号浙江出版物资大厦2层");
        addressResolution("杭州市西湖区文二西路718号西溪创意大厦1-2层");
        addressResolution("宁波市海曙区中山西路2号恒隆中心西裙楼4层（蔡家巷6号上电梯）");
        addressResolution("福州市六一北路328号金源花园三层");
        addressResolution("威海市海滨北路附36号府前商厦");
        addressResolution("长沙市岳麓区枫林三路49号西中心大厦（汽车西站旁）T1写字楼4层");
        addressResolution("长沙市雨花区湘府东路258号双塔国际广场A座2层");
        addressResolution("长沙市开福区芙蓉中路一段593号潇湘华天酒店6层");
        addressResolution("深圳市福田区滨河路北彩田路东交汇处联合广场裙楼B座201、203");
        addressResolution("深圳市南山区高新科技园中区科苑路科兴科学园东门B座3单元3A层（荣粤酒家正门左侧电梯上）");
        addressResolution("深圳市罗湖区宝安南路3044号天地大厦1层3层");
        addressResolution("深圳市福田区福田街道深圳国际文化大厦4层");
        addressResolution("广东省佛山市禅城区季华四路115号B座宏宇国金大厦二层");
        addressResolution("东莞市南城区元美路2号财富广场2楼");
        addressResolution("绵阳高新区火炬北路附21号（交警四大队对面）");
        addressResolution("贵州省贵阳市观山湖区世纪城龙泉苑街9号独栋商业楼");
        addressResolution("贵州省凯里市永乐路大地永乐家园4层");
        addressResolution("毕节市七星关区市西街道松山路95号三江花园B栋2层");
        addressResolution("贵州省六盘水市钟山区钟山路59号（雨田广场五层）A栋501.B栋502.503");
        addressResolution("银川市兴庆区文化西街106号国际贸易中心C栋3层");
        addressResolution("固原市原州区北京路华祺集团A区一层");
        addressResolution("五宝路心愿公寓25楼");
        addressResolution("白雀园");
        addressResolution("白雀园新园公寓25楼");
        addressResolution("白雀园镇新园公寓25楼");
        addressResolution("凉亭乡");
        addressResolution("凉亭乡镇北京路华祺集团A区一层");
        addressResolution("心愿公寓25楼");
    }

}
