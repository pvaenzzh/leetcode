package com.pvaen.leetcode.字符串.a0.罗马数字转整数;

import java.util.HashMap;


/**
 * 15 ms	39.2 MB	Java	2021/08/06 15:16
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
public class P01 {

    public static void main(String[] args) {
        System.out.println(new P01().romanToInt("IX"));
    }

    public int romanToInt(String s) {
        HashMap<String, Integer> romanToInt = new HashMap<>();
        romanToInt.put("M", 1000);
        romanToInt.put("CM", 900);
        romanToInt.put("D", 500);
        romanToInt.put("CD", 400);
        romanToInt.put("C", 100);
        romanToInt.put("XC", 90);
        romanToInt.put("L", 50);
        romanToInt.put("XL", 40);
        romanToInt.put("X", 10);
        romanToInt.put("IX", 9);
        romanToInt.put("V", 5);
        romanToInt.put("IV", 4);
        romanToInt.put("I", 1);

        int result = 0;
        String tmpRoman;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length()) {
                tmpRoman = s.charAt(i) + "" + s.charAt(i + 1);
                if (romanToInt.containsKey(tmpRoman)) {
                    result += romanToInt.get(tmpRoman);
                    i++;
                    continue;
                }
            }
            tmpRoman = s.charAt(i) + "";
            result += romanToInt.get(tmpRoman);
        }
        return result;
    }

}
