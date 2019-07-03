package sort.mergesort;

/**
 * describe：逆序对问题
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * @author 梦合九千
 * @date 2018/12/23 19:54
 */
public class InversePairs {

    public int inversePairs(int [] array) {
        if (null == array || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        // System.arraycopy(array, 0, copy, 0, array.length);
        return inversePairsCore(array, 0, array.length - 1, copy);
    }

    public int inversePairsCore(int[] data, int start, int end, int[] copy) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = inversePairsCore(data, start, start+length, copy);
        int right = inversePairsCore(data, start+length + 1, end, copy);

        int num = 0; // 逆序对
        int k = end; //开始拷贝的copy的数组起始位置
        int i = start + length; // 前半段的最后一个数字的下标
        int j = end;

        while (i >= start && j >= start +length + 1) {
            // 左边的那一组元素大
            if (data[i] > data[j]) {
                copy[k] = data[i];
                k--;
                i--;
                num += j - (start + length);
            } else {
                copy[k] = data[j];
                k--;
                j--;
            }
        }

        for (; i>= start; ) {
            copy[k] = data[i];
            k--;
            i--;
        }
        for (; j>= start + length + 1; ) {
            copy[k] = data[j];
            k--;
            j--;
        }


//        while (i >= start) {
//            copy[k] = data[i];
//            k--;
//            i--;
//        }
//        while (j >= start + length +1) {
//            copy[k] = data[j];
//            k--;
//            j--;
//        }

        // 将临时数组中的有序数列拷贝到目标排序数组的对应位置上
        k = end;
        while (start <= end) {
            data[end--] = copy[k--];
        }

        return left + right + num;
    }

    public static void main(String[] args) {
        InversePairs ip = new InversePairs();

        int[] test1 = {1,2,3,4,5,6,7,0};
        int res = ip.inversePairs(test1);
        System.out.println(res);
    }
}
