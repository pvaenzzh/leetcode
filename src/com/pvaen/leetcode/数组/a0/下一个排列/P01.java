package com.pvaen.leetcode.数组.a0.下一个排列;


import java.util.Arrays;

/**
 * 1 ms	38.6 MB	Java	2021/08/04 00:30
 */
public class P01 {

    public static void main(String[] args) {
        int[] ints = {1, 3, 2};
        new P01().nextPermutation(ints);
        System.out.println(Arrays.toString(ints));

    }

    /**
     * <pre>
     *     例: 1243210
     *     1. 从后向前找, 找到第一个 nums[i] < nums[i+1] (解释: 243210 , 找到2 < 4)
     *     2. index i 的数字需要换成 [i+1, nums.length)中 比 nums[i]大的最少的值 (解释: 需要在43210 找到第一个 小于等于 2  的 值, 这里是210中的2)
     *     3. 交换 找到的值前面的值 和 index i
     *     4. 将 i 后面的值 翻转, 不包括i
     *     5. 如果第2不找不到值, 将数组翻转结束程序
     *
     * </pre>
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;

        for (int i = nums.length - 1; i > -1; i--) {
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) {//index i 需要替换为 后面比他 大的最少的值
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] >= nums[j]) {//nums[j-1]是比nums[i]大的最少的值
                        swap(nums, j - 1, i);
                        revertArray(nums, i + 1, nums.length - 1);
                        return;
                    } else if (j == nums.length - 1) {//index j就是需要和 index i 交换的值
                        swap(nums, i, nums.length - 1);
                        revertArray(nums, i + 1, nums.length - 1);
                        return;
                    }
                }
            }
        }
        revertArray(nums);
        return;

    }

    private static void swap(int[] param, int index1, int index2) {
        int r;
        r = param[index1];
        param[index1] = param[index2];
        param[index2] = r;
    }

    private static void revertArray(int[] param) {
        revertArray(param, 0, param.length - 1);
    }

    private static void revertArray(int[] param, int startIndex, int endIndex) {
        int r;
        while (startIndex < endIndex) {
            r = param[startIndex];
            param[startIndex] = param[endIndex];
            param[endIndex] = r;
            startIndex++;
            endIndex--;
        }
    }

}
