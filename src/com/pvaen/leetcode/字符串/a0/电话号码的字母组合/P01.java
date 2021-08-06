package com.pvaen.leetcode.字符串.a0.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 7 ms	38.7 MB	Java	2021/08/06 17:05
 */
public class P01 {

    public static void main(String[] args) {
        List<String> strings = new P01().letterCombinations("2");
        System.out.println(strings);
    }

    public List<String> letterCombinations(String digits) {

        List<String> preResult = new ArrayList();
        List<String> nowResult = new ArrayList();

        for (int i = 0; i < digits.length(); i++) {// 设置结果的第i+1个

            for (int j = 0; j < getValue(digits.charAt(i)).length; j++) {
                char c = getValue(digits.charAt(i))[j];
                if (preResult.isEmpty()) {
                    nowResult.add(c + "");
                } else {
                    for (int k = 0; k < preResult.size(); k++) {
                        nowResult.add(preResult.get(k) + c);
                    }
                }
            }
            preResult = nowResult;
            nowResult = new ArrayList();
        }
        return preResult;
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
