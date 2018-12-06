package guavalearn.collection;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;

import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {
        // guava的静态工厂方法
        // _01_staticFactoryMethod();

        // List类型的工具类
        // _02_Lists();

        // 字符串操作工具类
        _03_Strings();

    }

    public static void _03_Strings() {
        String str = "a=1, b=2 ; c=3";
        // 检查字符串是否为空或者null
        System.out.println(Strings.isNullOrEmpty(str)); // false

        // Splitter拆分字符串（可去掉空格），比较蛋疼的是返回类型是Iterable。
        Iterable<String> splitResults = Splitter.onPattern("[,;]").trimResults().omitEmptyStrings().split(str);
        System.out.println(splitResults.toString()); // [a=1, b=2, c=3]

        // 同样可以用Joiner拼接
        String joinResult = Joiner.on(",").join(splitResults);
        System.out.println(joinResult); // a=1,b=2,c=3

        // 二次拆分，返回Map类型
        Map<String, String> kvs = Splitter.onPattern("[,;]").trimResults().omitEmptyStrings()
                .withKeyValueSeparator('=').split(str);
        System.out.println(kvs.toString()); // {a=1, b=2, c=3}
        // 使用Joiner拼接
        String kvsJoinResult = Joiner.on(",").withKeyValueSeparator("=").join(kvs);
        System.out.println(kvsJoinResult); // a=1,b=2,c=3


    }


    public static void _02_Lists() {

        List<String> mutableList = Lists.newArrayList("aa", "bb", "cc");
        List<String> immutableList = Collections.unmodifiableList(mutableList);
        System.out.println(immutableList);
        mutableList.add("dd");
        System.out.println(immutableList);

        List countUp = Ints.asList(1, 2, 3, 4, 5);
        List countdown = Lists.reverse(countUp);
        List partition = Lists.partition(countUp, 2);
        System.out.println("");

        List<String> allValidCustomers = Lists.newArrayList();
        List<String> allValidCustomers1=Lists.newArrayList();
        allValidCustomers1 = Lists.transform(allValidCustomers, new Function<String, String>() {
            @Override
            public String apply(String input) {
                return "";
            }
        });
    }

    public static void _01_staticFactoryMethod() {
        List<String> oldWay = new ArrayList<>();
        Collections.addAll(oldWay, "alpha", "beta", "gamma");

        List<String> theseElements = Lists.newArrayList("alpha", "beta", "gamma");
        System.out.println(theseElements.size());

        List<String> exactly100 = Lists.newArrayListWithCapacity(100);
        List<String> approx100 = Lists.newArrayListWithExpectedSize(100);
        Set<String> approx100Set = Sets.newHashSetWithExpectedSize(100);
        Multiset<String> multiset = HashMultiset.create();
    }

}
