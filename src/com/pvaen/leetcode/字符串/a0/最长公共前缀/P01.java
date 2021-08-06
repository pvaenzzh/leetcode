package com.pvaen.leetcode.字符串.a0.最长公共前缀;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/submissions/
 * 1 ms	36.6 MB	Java	2021/08/06 16:08
 */
public class P01 {

    public static void main(String[] args) {
        System.out.println(new P01().longestCommonPrefix(new String[]{"","flow","f"}));

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        int index = 0;//这个位置之前的都相同
        char tmpChar;

        for (index = 0; index < strs[0].length(); index++) {
            tmpChar = strs[0].charAt(index);
            for (int i = 0; i < strs.length; i++) {
                if (index >= strs[i].length() || strs[i].charAt(index) != tmpChar) {
                    return strs[0].substring(0, index);
                }
            }
        }
        return strs[0].substring(0, index);
    }

//    public String longestCommonPrefix(String[] strs) {
//        int index = 0;//这个位置之前的都相同
//        char tmpChar;
//
//        boolean search = true;
//        while (search) {
//            for (int i = 0; i < strs.length; i++) {
//                if (index >= strs[i].length() || strs[i].charAt(index) != tmpChar) {//tmpChar不好获取值
//                    search = false;
//                    break;
//                }
//            }
//            index++;
//        }
//
//    }

}
