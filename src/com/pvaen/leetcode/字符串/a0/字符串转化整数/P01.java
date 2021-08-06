package com.pvaen.leetcode.字符串.a0.字符串转化整数;

import java.util.Stack;

public class P01 {


    public static void main(String[] args) {
        int a = Integer.MIN_VALUE + 10;
        a -= 20d;
        System.out.println(a);
//        System.out.println(new P01().myAtoi(" -13212313131231"));
    }


    public int myAtoi(String s) {
        boolean ge0 = true;
        int startIndex = -1;
        Stack<Integer> integers = new Stack<>();

        char tmpChar;
        for (int i = 0; i < s.length(); i++) {
            tmpChar = s.charAt(i);
            if (tmpChar == ' ') continue;
            if (startIndex == -1) {
                if (tmpChar == '-') {
                    ge0 = false;
                    startIndex = i;
                    continue;
                } else if (tmpChar == '+') {
                    ge0 = true;
                    startIndex = i;
                    continue;
                }
            }
            if ('0' <= tmpChar && tmpChar <= '9') {
                integers.push(Integer.valueOf(tmpChar + ""));
            } else {
                break;
            }
        }
        int ans = 0, ans2 = 0;
        long result = 0;
        int size = integers.size();
        for (int i = 0; i < size; i++) {
            ans2 += (int) Math.pow(10, i) * integers.pop();
            if (ans > ans2) {
                ans = ge0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                return ans;
            }
            ans = ans2;
        }
        ans = ge0 ? ans : -ans;
        return (int) ans;

    }
}
