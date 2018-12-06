package guavalearn.range;

import com.google.common.collect.Range;

import java.util.List;

/**
 * @Description 测试guava的区间工具类Range
 * @Author shuyun
 * @Date 2018/8/29 15:37
 */
public class RangeTest {
    public static void main(String[] args) {


        System.out.println(Range.closedOpen(4, 4).lowerBoundType()); // returns true
        System.out.println(Range.closedOpen(4, 4).isEmpty()); // returns true
        System.out.println(Range.openClosed(4, 4).isEmpty()); // returns true
        System.out.println(Range.closed(4, 4).isEmpty()); // returns false
        // System.out.println(Range.open(4, 4).isEmpty()); // Range.open throws IllegalArgumentException
        System.out.println(Range.closed(3, 10).lowerEndpoint()); // returns 3
        System.out.println(Range.open(3, 10).lowerEndpoint()); // returns 3
        System.out.println(Range.closed(3, 10).lowerBoundType()); // returns CLOSED
        System.out.println(Range.open(3, 10).upperBoundType()); // returns OPEN

        System.out.println(Range.open(3, 6).intersection(Range.open(5, 10)));
    }
}
