package com.pvaen.leetcode.字符串.a0.整数转罗马数;

import java.util.HashMap;

/**
 * 7 ms	38.3 MB	Java	2021/08/06 14:50
 */
public class P01 {

    public static void main(String[] args) {
        System.out.println(new P01().intToRoman(1));
    }

    public String intToRoman(int num) {
        HashMap<Integer, String> intTiRomanMap = new HashMap<>();
        intTiRomanMap.put(1000, "M");
        intTiRomanMap.put(900, "CM");
        intTiRomanMap.put(500, "D");
        intTiRomanMap.put(400, "CD");
        intTiRomanMap.put(100, "C");
        intTiRomanMap.put(90, "XC");
        intTiRomanMap.put(50, "L");
        intTiRomanMap.put(40, "XL");
        intTiRomanMap.put(10, "X");
        intTiRomanMap.put(9, "IX");
        intTiRomanMap.put(5, "V");
        intTiRomanMap.put(4, "IV");
        intTiRomanMap.put(1, "I");
        int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();
        int a;// 进制的倍数
        int b;// 除以进制的 余数
        int c = num;// 当前剩余的数
        int d;// 进制数

        for (int i = 0; i < ints.length; i++) {
            d = ints[i];
            a = c / d;

            b = c % d;
            c = b;
            while (a > 0) {
                result.append(intTiRomanMap.get(d));
                a--;
            }
        }

        return result.toString();

    }

}
