package com.pvaen.leetcode.字符串.a0.括号生成;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 14 ms	38.5 MB	Java	2021/08/06 18:50
 */
public class P01 {

    public static void main(String[] args) {
        System.out.println(new P01().generateParenthesis(8));
    }

    public List<String> generateParenthesis(int n) {
        List<String> lList = new ArrayList<>();
        List<String> rList = new ArrayList<>();

        int parenthesisLength = n * 2;
        for (int i = 0; i < parenthesisLength; i++) {
            if (lList.isEmpty()) {
                char[] chars = nextRange("", n);
                for (int j = 0; j < chars.length; j++) {
                    rList.add(chars[j] + "");
                }
            } else {
                for (int j = 0; j < lList.size(); j++) {
                    char[] chars = nextRange(lList.get(j), n);
                    for (int k = 0; k < chars.length; k++) {
                        rList.add(lList.get(j) + "" + chars[k]);
                    }
                }
            }
            lList = rList;
            rList = new ArrayList<>();
        }
        return lList;
    }

    private static final char[] RANGE1 = new char[]{'(', ')'};
    private static final char[] RANGE2 = new char[]{'('};
    private static final char[] RANGE3 = new char[]{')'};
    private static final char[] RANGE4 = new char[0];

    private static char[] nextRange(String s, int n) {
        Stack<Object> objects = new Stack<>();
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
                objects.push(s.charAt(i));
            } else {
                objects.pop();
            }
        }
        return objects.isEmpty() ?
                (s.length() == n * 2 ? RANGE4 : RANGE2) : //括号抵消了
                (l == n ? RANGE3 : RANGE1);//还有一个前括号
    }


}
