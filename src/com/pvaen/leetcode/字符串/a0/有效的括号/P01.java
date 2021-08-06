package com.pvaen.leetcode.字符串.a0.有效的括号;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/submissions/
 * 1 ms	36.4 MB	Java	2021/08/06 18:16
 */
public class P01 {

    public static void main(String[] args) {
        System.out.println(new P01().isValid("{[]}"));
    }

    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    public boolean isValid(String s) {

        Stack<Character> objects = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    objects.push(c);
                    break;
                case ')':
                    if (objects.isEmpty() || objects.pop() != '(') return false;
                    break;
                case '}':
                    if (objects.isEmpty() || objects.pop() != '{') return false;
                    break;
                case ']':
                    if (objects.isEmpty() || objects.pop() != '[') return false;
                    break;
                default:
                    break;
            }
        }
        return objects.isEmpty() ? true : false;
    }

}
