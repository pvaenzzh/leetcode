package com.pvaen.leetcode.字符串.a0.括号生成;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 未完成
 */
public class P02 {

    public static void main(String[] args) {
        System.out.println(new P02().generateParenthesis(2));
    }


    public List<String> generateParenthesis(int n) {
        List<O1> lList = new ArrayList<>();
        List<O1> rList = new ArrayList<>();
        int length = n * 2;

        O1 o1 = new O1("", n);
        lList.add(o1);
        for (int i = 0; i < length; i++) {
            Iterator<O1> iterator = lList.iterator();
            while (iterator.hasNext()) {
                O1 next = iterator.next();
                if (next.hasNext()) {
                    rList.addAll(next.nextO1List());
                }
            }
            lList = rList;
            rList = new ArrayList<>();
        }

        return lList.stream().map(t -> t.getS()).collect(Collectors.toList());
    }

    private static final char[] RANGE1 = new char[]{'(', ')'};
    private static final char[] RANGE2 = new char[]{'('};
    private static final char[] RANGE3 = new char[]{')'};
    private static final char[] RANGE4 = new char[0];

    class O1 {
        private int l = 0;//左括号个数
        private String s;//当前括号样子
        private Stack<Character> stack;//括号队列
        private char[] nextRange;//括号队列
        private int n;

        public O1(String s, int n) {
            this.n = n;
            this.s = s;
            this.stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    l++;
                    stack.push(s.charAt(i));
                } else {
                    stack.pop();
                }
            }

            nextRange = nextRange(n);
        }

        private O1(int l, String s, Stack stack, int n) {
            this.l = l;
            this.s = s;
            this.stack = stack;
            this.n = n;

            this.nextRange = nextRange(n);
        }

        public boolean hasNext() {
            return nextRange.length != 0;
        }

        public List<O1> nextO1List() {
            List<O1> objects = new ArrayList<>();
            if (nextRange.length == 1) {
                s = s + nextRange[0];
                if (nextRange[0] == '(') {
                    l++;
                    stack.push('(');
                } else if (nextRange[0] == ')') {
                    stack.pop();
                }
                objects.add(this);
            } else if (nextRange.length == 2) {
                for (int i = 0; i < 2; i++) {
                    s = s + nextRange[0];
                    if (i == 0) {
                        if (nextRange[0] == '(') {
                            l++;
                            stack.push('(');
                        } else if (nextRange[0] == ')') {
                            stack.pop();
                        }
                        objects.add(this);
                    } else {
                        Stack<Character> objects1 = new Stack<>();
                        if (!stack.isEmpty()) objects1.push('(');
                        objects.add(new O1(l, s, objects1, n));
                    }
                }
            }
            return objects;
        }

        private char[] nextRange(int n) {
            return stack.isEmpty() ?
                    (s.length() == n * 2 ? RANGE4 : RANGE2) : //括号抵消了
                    (l == n ? RANGE3 : RANGE1);//还有一个前括号
        }

        public int getL() {
            return l;
        }

        public void setL(int l) {
            this.l = l;
        }

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }

        public char[] getNextRange() {
            return nextRange;
        }
    }

}
