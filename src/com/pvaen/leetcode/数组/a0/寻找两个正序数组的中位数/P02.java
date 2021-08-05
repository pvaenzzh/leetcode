package com.pvaen.leetcode.数组.a0.寻找两个正序数组的中位数;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 	15 ms	39.3 MB	Java	2021/07/30 23:59
 */
public class P02 {

    public static void main(String[] args) {
        P02 p01 = new P02();
        System.out.println(p01.findMedianSortedArrays(new int[]{2,3,4,1,1,2}, new int[]{2,3,5}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        boolean isTwoMid = length % 2 == 0;
        int midIndex = length / 2;


        List<Integer> collect = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> collect2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        boolean b = collect.addAll(collect2);
        Collections.sort(collect);
        Integer[] integers = collect.toArray(new Integer[0]);

        return isTwoMid? (double) (integers[midIndex] + integers[midIndex-1])/2 : (double)integers[midIndex];
    }

}
