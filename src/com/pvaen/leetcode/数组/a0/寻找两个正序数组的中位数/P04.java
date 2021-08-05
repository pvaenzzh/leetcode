package com.pvaen.leetcode.数组.a0.寻找两个正序数组的中位数;

/**
 * 未完成
 */
public class P04 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0d;
    }

    public static void main(String[] args) {
        findKInTwoArray(new int[]{0, 1, 2, 3}, new int[]{1}, 3);
    }

    private static Integer findKInTwoArray(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;

        int p1 = length1 / 2, p1Start = 0, p1End = length1;// [p1Start, p1) + [p1, p1End-1] = nums1
        int p2 = length2 / 2, p2Start = 0, p2End = length2;

        Integer result = null;

        int preCount;
        while (result == null) {
            preCount = p1 + 1 + p2 + 1;

//            if (p1End - p1Start < 3){
//                result = -1;
//            }
//            if (p2End - p2Start < 3){
//                if (preCount < k){
//                    return nums1[p1 + (k - (p2End - p2Start))];
//                }else {
//
//                }
//                result = -1;
//            }

            if (nums1[p1] < nums2[p2]) {
                if (preCount < k) {//可以排除 [p1Start, p1)
                    p1Start = p1 + 1;
                    p1 = p1Start + (p1End - p1Start) / 2;
                } else if (preCount == k) {//可以排除 [p2, p2End-1]
                    p2End = p2;
                    p2 = p2Start + (p2End - p2Start) / 2;
                } else {//可以排除 [p2, p2End-1]
                    p2End = p2;
                    p2 = p2Start + (p2End - p2Start) / 2;
                }
            } else if (nums1[p1] == nums2[p2]) {
                if (preCount < k) {//可以排除掉小的集合的子集
                    p1Start = p1 + 1;
                    p1 = p1Start + (p1End - p1Start) / 2;
                    p2Start = p2 + 1;
                    p2 = p2Start + (p2End - p2Start) / 2;
                } else if (preCount == k) {//直接获得结果
                    result = nums1[p1];
                } else {//可以排除大的一部分的子集
                    p1End = p1;
                    p1 = p1Start + (p1End - p1Start) / 2;
                    p2End = p2;
                    p2 = p2Start + (p2End - p2Start) / 2;
                }
            } else {
                if (preCount < k) {//可以排除掉小的集合的子集
                    p2Start = p2;
                    p2 = p2Start + (p2End - p2Start) / 2;
                } else if (preCount == k) {//可以排除大的一部分的子集
                    result = nums1[p1];
                } else {//可以排除大的一部分的子集, k = k
                    p1End = p1;
                    p1 = p1Start + (p1End - p1Start) / 2;
                }
            }
        }
        return result;
    }

}