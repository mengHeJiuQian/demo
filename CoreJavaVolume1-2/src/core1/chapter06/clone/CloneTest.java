package core1.chapter06.clone;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/1/6 11:47
 */
public class CloneTest {

    @Test
    public void testArrayClone() {
        int[] arrInt = new int[2];
        arrInt[0] = 1;
        arrInt[1] = 2;
        int[] arr2Int = arrInt.clone();
        System.out.println(Arrays.toString(arrInt));
        System.out.println(Arrays.toString(arr2Int));
        arrInt[0] = 11;
        System.out.println(Arrays.toString(arrInt));
        System.out.println(Arrays.toString(arr2Int));

    }

    @Test
    public void testStringClone() {
        String[] strInt = new String[2];
        strInt[0] = "1";
        strInt[1] = "2";
        String[] str2Int = strInt.clone();
        System.out.println(Arrays.toString(strInt));
        System.out.println(Arrays.toString(str2Int));
        strInt[0] = "11";
        System.out.println(Arrays.toString(strInt));
        System.out.println(Arrays.toString(str2Int));

    }

}
