package array;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/17 17:53
 * 版本：1.0
 * 内容描述：求数组中最大子序列和的问题
 */
public class MaxSubSequenceSample {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, 20, -6, 5};
        int i = maxSubSequence(arr);
        System.out.println(i);

        int i1 = maxSubSequence2(arr);
        System.out.println(i1);
    }

    /**
     * 时间复杂度为O(n^2)
     */
    public static int maxSubSequence(int[] arr) {

        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            int iSum = 0;
            for (int j = i; j < arr.length; j++) {
                iSum += arr[j];
                if (iSum > maxSum) {
                    maxSum = iSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * Kadane算法
     * 时间复杂度为O(n^2)
     * 视频讲解：https://www.bilibili.com/video/av52421507?from=search&seid=3623534585276596200
     *          https://www.youtube.com/watch?v=86CQq3pKSUw
     */
    public static int maxSubSequence2(int[] arr) {

        int maxSum = arr[0];
        int iSum = 0;

        for (int i = 0; i < arr.length; i++) {
            iSum = Math.max(arr[i], iSum + arr[i]);
            if (iSum < 0) {
                iSum = 0;
            }
            if (iSum > maxSum) {
                maxSum = iSum;
            }
        }
        return maxSum;
    }
}
