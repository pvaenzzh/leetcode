package com.pvaen.leetcode.数组.a0.盛最多水的容器;

public class P01 {

    public static void main(String[] args) {
        System.out.println(new P01().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));;
    }

    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                result = Math.max(result, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return result;
    }

}
