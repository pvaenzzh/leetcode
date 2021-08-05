package com.pvaen.leetcode.数组.a0.删除有序数组中的重复项;

/**
 * 1 ms	39.6 MB	Java	2021/08/03 21:26
 */
public class P01 {

    public static void main(String[] args) {
        int[] ints = {-1};
        int i = new P01().removeDuplicates(ints);
        for (int j = 0; j < i; j++) {
            System.out.println(ints[j]);
        }
    }

    public int removeDuplicates(int[] nums) {
        int removeCount = 0, writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                removeCount++;
                continue;
            }
            nums[writeIndex] = nums[i];
            writeIndex++;
        }
        return nums.length - removeCount;
    }

}
