package com.pvaen.leetcode.数组.a0.三数之和;

import java.util.Arrays;

public class Utils {

    public static int[] getParam(String p) {
        String trim = p.trim();
        String substring = trim.substring(1, trim.length() - 1);
        String[] split = substring.split(",");
        int[] ints = Arrays.stream(split).map(t -> Integer.valueOf(t.trim())).mapToInt(Integer::valueOf).toArray();
        return ints;
    }

}
