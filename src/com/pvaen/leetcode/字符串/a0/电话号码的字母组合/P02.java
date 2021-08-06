package com.pvaen.leetcode.字符串.a0.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 7 ms	38.7 MB	Java	2021/08/06 17:05
 */
public class P02 {

    public static void main(String[] args) {
        List<String> strings = new P02().letterCombinations("22");
        System.out.println(strings);
    }

    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        int count = 1;

        for (int i = 0; i < length; i++) {
            count = count * getValue(digits.charAt(i)).length;
        }

        ArrayList<String> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add("");
        }

        int index = 0, indexLength;
        for (int i = 0; i < length; i++) {
            char[] value = getValue(digits.charAt(i));
            indexLength = value.length;
            for (int j = 0; j < result.size(); j++) {
                result.set(j, result.get(j) + value[index]);
                index = (index + 1) % indexLength;
            }
        }
        return result;
    }

    private static final char[] c2 = new char[]{'a', 'b', 'c'};
    private static final char[] c3 = new char[]{'d', 'e', 'f'};
    private static final char[] c4 = new char[]{'g', 'h', 'i'};
    private static final char[] c5 = new char[]{'j', 'k', 'l'};
    private static final char[] c6 = new char[]{'m', 'n', 'o'};
    private static final char[] c7 = new char[]{'p', 'q', 'r', 's'};
    private static final char[] c8 = new char[]{'t', 'u', 'v'};
    private static final char[] c9 = new char[]{'w', 'x', 'y', 'z'};

    public char[] getValue(char num) {
        switch (num) {
            case '2':
                return c2;
            case '3':
                return c3;
            case '4':
                return c4;
            case '5':
                return c5;
            case '6':
                return c6;
            case '7':
                return c7;
            case '8':
                return c8;
            case '9':
                return c9;
        }
        return new char[0];
    }


}
