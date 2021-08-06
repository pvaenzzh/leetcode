package com.pvaen.leetcode.字符串.a0.罗马数字转整数;


/**
 * 6 ms	38.4 MB	Java	2021/08/06 15:25
 */
public class P02 {

    public static void main(String[] args) {
        System.out.println(new P02().romanToInt("IX"));
    }

    public int romanToInt(String s) {
        int result = 0;
        int tmpValue, nextValue;
        for (int i = 0; i < s.length(); i++) {
            tmpValue = getValue(s.charAt(i));
            if (i + 1 < s.length()) {
                nextValue = getValue(s.charAt(i+1));
                if (tmpValue < nextValue) {
                    result -= tmpValue;
                    result += nextValue;
                    i++;
                }else {
                    result += getValue(s.charAt(i));
                }
            }else {
                result += getValue(s.charAt(i));
            }
        }
        return result;
    }

    private static int getValue(char c) {
        switch (c){
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
        }
        return 0;
    }

}
