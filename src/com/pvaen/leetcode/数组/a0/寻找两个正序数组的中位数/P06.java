package com.pvaen.leetcode.数组.a0.寻找两个正序数组的中位数;

public class P06 {

    public static void main(String[] args) {
        System.out.println(new P06().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        boolean isTwoMid = (nums1.length + nums2.length) % 2 == 0;
        if (isTwoMid) {
            int midIndex1 = (nums1.length + nums2.length) / 2, midIndex2 = midIndex1 - 1;
            return (double) (findKInTwoArray(nums1, nums2, midIndex1 + 1) + findKInTwoArray(nums1, nums2, midIndex2 + 1)) / 2;
        } else {
            int midIndex1 = (nums1.length + nums2.length) / 2;
            return (double) findKInTwoArray(nums1, nums2, midIndex1 + 1);
        }
    }

    /**
     * @param nums1
     * @param nums2
     * @param k     需要寻找的第k个, k从 1开始
     * @return
     */
    private static int findKInTwoArray(int[] nums1, int[] nums2, int k) {
        int n1Index = 0, n2Index = 0;//当前下标, 该位置之前的元素被排除了, 不包含该位置

        int n1Length = nums1.length, n2Length = nums2.length;//仅表示长度


        int needK;//本次需要排除的个数
        int leftCount = k;//还需要排除的个数
        int computerN1Index, computerN2Index;//计算包含该位置之前的位置被排除
        while (true) {
            needK = leftCount / 2;
            if (n1Index == n1Length) {
                return nums2[k - n1Length - 1];
            }
            if (n2Index == n2Length) {
                return nums1[k - n2Length - 1];
            }
            if (leftCount == 1) {
                return Math.min(nums1[n1Index], nums2[n2Index]);
            }
            computerN1Index = Math.min(n1Index + needK - 1, n1Length - 1);
            computerN2Index = Math.min(n2Index + needK - 1, n2Length - 1);
            if (nums1[computerN1Index] <= nums2[computerN2Index]) {//排除本身
                n1Index = computerN1Index + 1;
            } else {
                n2Index = computerN2Index + 1;
            }
            leftCount = k - n1Index - n2Index;
        }
    }


}
