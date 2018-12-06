package guavalearn.collection;

import com.google.common.collect.ImmutableSortedSet;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/8/29 10:13
 */
public class ImmutableTest {
    public static void main(String[] args) {
        ImmutableSortedSet<String> immutableSortedSet = ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
        System.out.println(immutableSortedSet);

    }
}
