package com.pvaen.leetcode.字符串.a0.最长回文子串;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/submissions/
 * 43 ms	38.3 MB	Java	2021/08/05 20:18
 */
public class P01 {

    public static void main(String[] args) {
        String a = "tattarrattat";

        System.out.println(new P01().longestPalindrome(a));
    }

    public String longestPalindrome(String s) {
        int left, right, max = 0;
        int longLeft = 0, longRight = 0;
        boolean isLongestPalindrome;
        for (int i = 0; i < s.length(); i++) {
            //找奇数对称, nums[i-1] = num[i+1]
            left = i;
            right = i;
            isLongestPalindrome = true;
            while (left > 0 && right < s.length() - 1) {
                if (!(s.charAt(--left) == s.charAt(++right))) {
                    isLongestPalindrome = false;
                    break;
                }
            }
            if (isLongestPalindrome) {
                if (right - left + 1 > max) {
                    longLeft = left;
                    longRight = right;
                    max = right - left + 1;
                }
            } else {
                if (right - 1 - (left + 1) + 1 > max) {
                    longLeft = left + 1;
                    longRight = right - 1;
                    max = right - left - 1;
                }
            }

            //找偶数对称, nums[i] = num[i+1]
            left = i;
            right = i + 1;
            isLongestPalindrome = true;
            while (left > -1 && right < s.length()) {
                if (!(s.charAt(left--) == s.charAt(right++))) {
                    isLongestPalindrome = false;
                    break;
                }
            }
            if (isLongestPalindrome) {//代表 s.left+1 = s.right-1
                if (right - 1 - (left + 1) + 1 > max) {
                    longLeft = left + 1;
                    longRight = right - 1;
                    max = right - 1 - (left + 1) + 1;
                }
            } else {//上上次是相等的
                if (right - 2 - (left + 2) + 1 > max) {
                    longLeft = left + 2;
                    longRight = right - 2;
                    max = right - 2 - (left + 2) + 1;
                }
            }
        }
        return s.substring(longLeft, longRight + 1);
    }
}
