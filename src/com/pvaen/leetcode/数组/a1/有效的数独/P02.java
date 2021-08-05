package com.pvaen.leetcode.数组.a1.有效的数独;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 1 ms	38.1 MB	Java	2021/08/05 13:18
 */
public class P02 {

    public static void main(String[] args) {
        String board = "[[\".\",\".\",\"4\",\".\",\".\",\".\",\"6\",\"3\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\"5\",\".\",\".\",\".\",\".\",\".\",\".\",\"9\",\".\"],[\".\",\".\",\".\",\"5\",\"6\",\".\",\".\",\".\",\".\"],[\"4\",\".\",\"3\",\".\",\".\",\".\",\".\",\".\",\"1\"],[\".\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"5\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"]]";
//        String board = "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]\n" +
//                ",[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]\n" +
//                ",[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]\n" +
//                ",[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]\n" +
//                ",[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]\n" +
//                ",[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]\n" +
//                ",[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]\n" +
//                ",[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]\n" +
//                ",[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
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

        boolean validSudoku = new P02().isValidSudoku(chars);
        System.out.println(validSudoku);
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                if (rowRepeat(board, i, j) || columnRepeat(board, i, j) || areaRepeat(board, i, j)) return false;
            }
        }
        return true;
    }

    private static boolean rowRepeat(char[][] board, int i, int j) {
        for (int k = i + 1; k < board.length; k++) {
            if (board[i][j] == board[k][j]) {
                return true;
            }
        }
        return false;
    }

    private static boolean columnRepeat(char[][] board, int i, int j) {
        for (int k = j + 1; k < board[0].length; k++) {
            if (board[i][j] == board[i][k]) {
                return true;
            }
        }
        return false;
    }

    private static boolean areaRepeat(char[][] board, int i, int j) {
        int x = i / 3;
        int y = j / 3;
        for (int k = x * 3; k < x * 3 + 3; k++) {
            for (int l = y * 3; l < y * 3 + 3; l++) {
                if (!(k == i && l == j) && board[i][j] == board[k][l]) return true;
            }
        }
        return false;
    }


}
