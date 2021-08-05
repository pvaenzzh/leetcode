package com.pvaen.leetcode.数组.a0.寻找两个正序数组的中位数;

import java.awt.geom.IllegalPathStateException;

/**
 * <pre>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * </pre>
 */
public class P01 {

    public static void main(String[] args) {
        P01 p01 = new P01();
        System.out.println(p01.findMedianSortedArrays(new int[]{2,3,4}, new int[]{2,3,5}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int length = nums1.length + nums2.length;
        boolean isTwoMid = length % 2 == 0;
        int midIndex = length / 2;

        if (nums1.length == 0) {
            return isTwoMid ?
                    (double) nums2[midIndex] + nums2[midIndex - 1] / 2 :
                    (double) nums2[midIndex];
        }
        if (nums2.length == 0) {
            return isTwoMid ?
                    (double) (nums1[midIndex] + nums1[midIndex - 1]) / 2 :
                    (double) nums1[midIndex];
        }

        int pre = -1;
        int now = -1;
        boolean canOver = false;
        for (int k = 0; k < length; k++) {

            if (midIndex == k) {
                canOver = true;
            }

            if (i == nums1.length) {
                now = nums2[j];
                j++;
            } else if (j == nums2.length) {
                now = nums1[i];
                i++;
            } else if (nums1[i] <= nums2[j]) {
                now = nums1[i];
                i++;
            } else {
                now = nums2[j];
                j++;
            }

            if (canOver) {
                return isTwoMid ? (double) (pre + now) / 2 : now;
            }
            pre = now;
        }
        throw new IllegalPathStateException("不合法参数");
    }

}
