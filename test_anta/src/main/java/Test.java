import java.util.Arrays;

/**
 * 将两个升序的数组进行合并为一个数组，新的数组还是升序状态
 *
 */
public class Test {

    public static void main(String[] args) {
        int[] a = {1,3,5};
        int[] b = {2,4,6,7};
        int[] merge = merge(a, b);
        String s = Arrays.toString(merge);
        System.out.println(s);
    }

    public static int[] merge(int[] a, int[] b) {
        int resArrLength = 0;
        if (a != null) {
            resArrLength += a.length;
        }

        if (b != null) {
            resArrLength += b.length;
        }

        int[] res = mergeIndex(a, 0, b, 0, new int[resArrLength], 0);
        return res;
    }

    public static int[] mergeIndex(int[] a, int aIndex, int[] b, int bIndex, int[] res, int resIndex) {
        if (a.length-1 >= aIndex && b.length-1 >= bIndex) {
            if (a[aIndex] > b[bIndex]) {
                res[resIndex++] = b[bIndex];
                mergeIndex(a, aIndex, b, ++bIndex, res, resIndex);
            } else if (a[aIndex] < b[bIndex]) {
                res[resIndex++] = a[aIndex];
                mergeIndex(a, ++aIndex, b, bIndex, res, resIndex);
            } else {
                res[resIndex++] = a[aIndex++];
                res[resIndex++] = b[bIndex++];
                mergeIndex(a, aIndex, b, bIndex, res, resIndex);
            }
        }
        if (a.length-1 < aIndex && b.length-1 >= bIndex) {
            res[resIndex++] = b[bIndex++];
            mergeIndex(a, aIndex, b, bIndex, res, resIndex);
        }
        if (b.length-1 < bIndex && a.length-1 >= aIndex) {
            res[resIndex++] = a[aIndex++];
            mergeIndex(a, aIndex, b, bIndex, res, resIndex);
        }
        return res;
    }
}
