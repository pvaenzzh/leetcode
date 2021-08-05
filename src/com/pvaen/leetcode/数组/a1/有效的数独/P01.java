package com.pvaen.leetcode.数组.a1.有效的数独;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01 {

    public static void main(String[] args) {
        String board = "[[\".\",\".\",\"4\",\".\",\".\",\".\",\"6\",\"3\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\"5\",\".\",\".\",\".\",\".\",\".\",\".\",\"9\",\".\"],[\".\",\".\",\".\",\"5\",\"6\",\".\",\".\",\".\",\".\"],[\"4\",\".\",\"3\",\".\",\".\",\".\",\".\",\".\",\"1\"],[\".\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"5\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"]]";
        String substring = board.substring(1, board.length() - 1);
        Pattern compile = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = compile.matcher(substring);

        Pattern compile1 = Pattern.compile("[1-9.]");


        char[][] chars = new char[9][9];

        int i = 0, j = 0;

        while (matcher.find()) {
            String group = matcher.group();
            Matcher matcher1 = compile1.matcher(group);
            j = 0;
            while (matcher1.find()) {
                String group1 = matcher1.group();
                int i1 = group1.charAt(0);
                char i11 = (char) i1;
                chars[i][j] = i11;
                j++;
                System.out.print(i11 + " ");
            }
            System.out.println();
            i++;
        }

        boolean validSudoku = new P01().isValidSudoku(chars);
        System.out.println(validSudoku);
    }

    public boolean isValidSudoku(char[][] board) {
        /**
         * 约定: 每行放在一个set, 每列放在一个set, 3*3 也对应一个set
         * [000-008]: 000 代表第1行, 008代表第9行
         * [100-108]: 100 代表第1列, 108代表第9列
         * [200-202, 20X-22X]: 200代表 3*3 的00块, 212代表 3*3的 第2行, 第3列
         */
        Map<Integer, Set> record = new HashMap<>();
        int row = board.length;
        int column = board[0].length;

        for (int i = 0; i < board.length; i++) {
            record.put(i, new HashSet());
        }
        for (int i = 0; i < board.length; i++) {
            record.put(i + 100, new HashSet());
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                record.put(200 + i * 10 + j, new HashSet());
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (record.get(i).contains(board[i][j])) {
                    return false;
                } else {
                    record.get(i).add(board[i][j]);
                }

                if (record.get(100 + j).contains(board[i][j])) {
                    return false;
                } else {
                    record.get(100 + j).add(board[i][j]);
                }

                if (record.get(200 + (i / 3) * 10 + j / 3).contains(board[i][j])) {
                    return false;
                } else {
                    record.get(200 + (i / 3) * 10 + j / 3).add(board[i][j]);
                }

            }
        }
        return true;
    }

}
