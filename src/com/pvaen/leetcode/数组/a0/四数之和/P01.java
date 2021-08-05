package com.pvaen.leetcode.数组.a0.四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4 ms	38.7 MB	Java	2021/08/03 21:14
 */
public class P01 {

    public static void main(String[] args) {
        System.out.println(new P01().fourSum(new int[]{-2, -1, 0, 0, 1, 2}, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        int c, d;
        int sum;
        for (int i = 0; i < nums.length - 3; i++) {
            //需要注意去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                //需要注意去重
                //需要注意只能向前(j-1)检验重复
                //注意j从i + 1开始验证
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) continue;

                c = j + 1;
                d = nums.length - 1;
                while (c < d) {
                    sum = nums[i] + nums[j] + nums[c] + nums[d] - target;
                    if (sum < 0) {
                        c++;
                    } else if (sum == 0) {
                        List<Integer> objects = new ArrayList<>(4);
                        objects.add(nums[i]);
                        objects.add(nums[j]);
                        objects.add(nums[c]);
                        objects.add(nums[d]);
                        result.add(objects);
                        while (c < d && nums[c] == nums[c + 1]) c++;
                        while (c < d && nums[d] == nums[d - 1]) d--;
                        c++;
                        d--;
                    } else if (sum > 0) {
                        d--;
                    }
                }
            }
        }
        return result;
    }

}
