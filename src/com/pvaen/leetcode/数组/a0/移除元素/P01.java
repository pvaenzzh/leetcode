package com.pvaen.leetcode.数组.a0.移除元素;

/**
 * 0 ms	37.2 MB	Java	2021/08/03 21:33
 */
public class P01 {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 2, 3, 0};
        int i = new P01().removeElement(ints, 3);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.print(ints[j]);
        }
    }

    public int removeElement(int[] nums, int val) {
        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }
        return writeIndex;
    }

}
