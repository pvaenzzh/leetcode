package com.pvaen.leetcode.数组.a1.在排序数组中查找元素的第一个和最后一个位置;

import java.util.Arrays;

/**
 * 事件复杂度 log n
 * 0 ms	41.8 MB	Java	2021/08/05 01:52
 */
public class P01 {

    public static void main(String[] args) {
//        int[] ints = new P01().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7);
        int[] ints = new P01().searchRange(new int[]{5, 5}, 5);
        System.out.println(Arrays.toString(ints));
    }

    public int[] searchRange(int[] nums, int target) {
        if (null == nums || nums.length == 0) return new int[]{-1, -1};

        int index1 = searchIndex(nums, target);
        if (index1 == 0) {
            index1 = nums[0] == target ? 0 : -1;
        } else if (index1 < nums.length) {
            index1 = nums[index1] == target ? index1 : -1;
        } else {
            index1 = -1;
        }

        int index2 = index1 == -1 ? -1 : searchIndex(nums, target + 1) - 1;
        if (index2 == -1) {

        } else if (index2 == 0) {
            index2 = nums[0] == target ? index2 : -1;
        } else if (index2 < nums.length) {
            index2 = nums[index2] == target ? index2 : -1;
        } else {
            index2 = -1;
        }

        return new int[]{index1, index2};
    }

    private static int searchIndex(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


}
