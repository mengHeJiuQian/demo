package collections.set;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;

/**
 * @Description 测试set集合特性
 * @Author yang.liu
 * @Date 2019/4/19 17:10
 */
public class SetsTest {

    @Test
    public void testSets() {
        Set<String> couponScopeSets = Sets.newHashSet("WX");
        List<String> couponScopeList = Lists.newArrayList("WX");

        List<String> shopList = Lists.newArrayList("AAA", "BBB", "TGW1", "AAA", "BBB", "TGW1");
        shopList.stream().forEach(shop -> {
                if (shop.equals("TGW1") || shop.equals("TGW1A01")) {
                couponScopeSets.add("OFFICAL");
                couponScopeList.add("OFFICAL");
            }
        });

        System.out.println("-" + JSONUtils.toJSONString(couponScopeSets) + "-");
        System.out.println("-" + JSONUtils.toJSONString(couponScopeList) + "-");

        System.out.println("-" + StringUtils.collectionToDelimitedString(couponScopeSets, ",") + "-");
        System.out.println("-" + StringUtils.collectionToDelimitedString(couponScopeList, ",") + "-");
    }

}
