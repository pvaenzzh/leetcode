package com.pvaen.leetcode.字符串.a0.无重复字符的最长子串;

import java.util.HashMap;

/**
 * 6 ms	38.4 MB	Java	2021/08/05 17:30
 */
public class P02 {

    public static void main(String[] args) {
        String a = "tmmzuxt";
        System.out.println(new P02().lengthOfLongestSubstring(a));
    }


    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        Character tempChar;
        HashMap<Character, Integer> char2IndexMap = new HashMap<>();
        while (right < s.length()) {
            tempChar = s.charAt(right);
            if (char2IndexMap.containsKey(tempChar)) {
                left = char2IndexMap.get(tempChar) < left ? left : char2IndexMap.get(tempChar) + 1;//有可能取到left之前的值
            }
            max = Math.max(max, right - left + 1);
            char2IndexMap.put(tempChar, right);
            right++;
        }
        return max;
    }
}