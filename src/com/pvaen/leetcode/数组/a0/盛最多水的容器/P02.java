package com.pvaen.leetcode.数组.a0.盛最多水的容器;

public class P02 {

    public static void main(String[] args) {
        System.out.println(new P02().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

    }

    /**
     * 双指针法, 每次移动 矮的一边, 计算完毕后, 取结果的最大值
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int result = -1;
        int startIndex = 0, endIndex = height.length - 1;

        while (startIndex != endIndex) {
            result = Math.max(result, (endIndex - startIndex) * Math.min(height[startIndex], height[endIndex]));
            if (height[startIndex] <= height[endIndex]) {
                startIndex++;
            } else {
                endIndex--;
            }
        }
        return result;
    }

}
