package com.pvaen.leetcode.数组.a0.搜索旋转排序数组;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class P01 {

    public static void main(String[] args) {
        System.out.println(new P01().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int mid;
        int start = 0, end = nums.length - 1;

        boolean b1, b2, b3;
        while (start < end) {
            if (nums[start] == target) return start;
            mid = (end + start) / 2;

            b1 = nums[start] <= target;
            b2 = nums[mid] < nums[start];
            b3 = target <= nums[mid];

            if (b1 ^ b2 ^ b3) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start == end && nums[start] == target ? start : -1;
    }

}
