package com.pvaen.leetcode.字符串.a0.无重复字符的最长子串;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 8 ms	38.6 MB	Java	2021/08/05 17:01
 */
public class P01 {

    public static void main(String[] args) {
        String a = "abcabcbb";
        System.out.println(new P01().lengthOfLongestSubstring(a));
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLength = 0;

        HashSet<Character> contain = new HashSet<>();
        while (right < s.length()) {
            if (left == right) {
                contain.add(s.charAt(left));
                maxLength = Math.max(maxLength, contain.size());
                right++;
            } else if (contain.contains(s.charAt(right))) {
                contain.remove(s.charAt(left));
                left++;
            } else if (!contain.contains(s.charAt(right))) {
                contain.add(s.charAt(right));
                maxLength = Math.max(maxLength, contain.size());
                right++;
            }
        }
        return maxLength;
    }

}
