package com.pvaen.leetcode.字符串.a0.字形变换;

/**
 * 25 ms	38.6 MB	Java	2021/08/05 23:50
 */
public class P01 {

    public static void main(String[] args) {
        System.out.println(new P01().convert("1234567890abcdefg", 5));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        int length = s.length();
        //两个相邻完整列的第一个元素的距离
        int distance = numRows + Math.max(numRows - 2, 0);
        //总个数
        int column = length / distance * (1 + distance % numRows) + (length % distance <= numRows ? 1 : length % distance - numRows + 1);//总结公式

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < column; j++) {
                boolean flag = j % (numRows - 1) == 0;
                int index = flag ? j / (numRows - 1) * distance + i : j / (numRows - 1) * distance + numRows - 1 + j % (numRows - 1);//总结公式
                if (index >= s.length()) break;
                if (j % (numRows - 1) == 0 || j % (numRows - 1) == numRows - 1 - i) {
                    result.append(s.charAt(index));
                }
            }
        }
        return result.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows == 1) return s;

        int length = s.length();
        //两个相邻完整列的第一个元素的距离
        int distance = numRows + Math.max(numRows - 2, 0);
        int i1 = length % distance;
        //总个数
        int column = length / distance * (1 + distance % numRows) + (i1 <= numRows ? 1 : i1 - numRows + 1);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < column; j++) {
                int i3 = j % (numRows - 1);
                boolean flag = i3 == 0;
                int i2 = j / (numRows - 1);
                int index = flag ? i2 * distance + i : i2 * distance + numRows - 1 + i3;
                if (index >= s.length()) break;
                if (i3 == 0 || i3 == numRows - 1 - i) {
                    result.append(s.charAt(index));
                }
            }
        }
        return result.toString();
    }


}
