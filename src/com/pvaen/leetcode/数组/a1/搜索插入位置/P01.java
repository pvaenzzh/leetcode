package com.pvaen.leetcode.数组.a1.搜索插入位置;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class P01 {

    public static void main(String[] args) {
        System.out.println(new P01().binarySearchL(new int[]{1, 3, 5, 6}, 7));
    }

    public int searchInsert(int[] nums, int target) {
        return binarySearchL(nums, target);
    }

    /**
     * 找到比target小的数的个数[0, nums.length]
     */
    private static int binarySearchL(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = right + left >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


}
