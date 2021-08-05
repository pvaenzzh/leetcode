package com.pvaen.leetcode.数组.a0.最接近的三数之和;

import java.util.Arrays;

/**
 * 9 ms	37.9 MB	Java	2021/08/03 20:27
 */
public class P01 {

    public static void main(String[] args) {
        new P01().threeSumClosest(new int[]{-11, -22, 23, 4, 5, 6, 7, 8, 9}, 1);
    }

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int a, b, c, minSum = Integer.MAX_VALUE, lastSum, nowSum;
        for (int i = 0; i < nums.length; i++) {
            a = i;
            b = i + 1;
            c = nums.length - 1;
            lastSum = Integer.MAX_VALUE;
            while (b < c) {
                nowSum = nums[a] + nums[b] + nums[c] - target;
                if (Math.abs(lastSum) < Math.abs(nowSum)) {
                    break;
                }
                if (nowSum > 0) {
                    c--;
                } else if (nowSum == 0) {
                    return target;
                } else if (nowSum < 0) {
                    b++;
                }
                minSum = Math.abs(minSum) < Math.abs(nowSum) ? minSum : nowSum;

                lastSum = nums[a] + nums[b] + nums[c] - target;
            }

        }
        return minSum + target;
    }


}
