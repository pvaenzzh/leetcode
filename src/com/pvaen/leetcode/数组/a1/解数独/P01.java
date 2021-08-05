package com.pvaen.leetcode.数组.a1.解数独;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 未完成
 * 回溯法
 * https://leetcode-cn.com/problems/sudoku-solver/
 */
public class P01 {

    public static void main(String[] args) {
//        String board = "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
        String board = "[[\".\",\".\",\"9\",\"7\",\"4\",\"8\",\".\",\".\",\".\"],[\"7\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\"2\",\".\",\"1\",\".\",\"9\",\".\",\".\",\".\"],[\".\",\".\",\"7\",\".\",\".\",\".\",\"2\",\"4\",\".\"],[\".\",\"6\",\"4\",\".\",\"1\",\".\",\"5\",\"9\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\"3\",\".\",\".\"],[\".\",\".\",\".\",\"8\",\".\",\"3\",\".\",\"2\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\"6\"],[\".\",\".\",\".\",\"2\",\"7\",\"5\",\"9\",\".\",\".\"]]";

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

        P01 p01 = new P01();

        p01.solveSudoku(chars);

    }

    public void solveSudoku(char[][] board) {
        initEffectiveRange(board);
        int needFillingCount = getNeedFillingCount(board);
        while (needFillingCount > 0) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    char c = board[i][j];
                    if (c != '.') continue;
                    Set<Character> effectiveRange = getEffectiveRange(board, i, j);
                    if (effectiveRange.size() == 1) {
                        fillBoard(board, i, j, effectiveRange.stream().findFirst().get());
                    }
                }
            }
            needFillingCount--;
        }

        ArrayList detail = getDetail(board);
        print(board);
        System.out.println("");

    }

    //debug
    private static void print(char[][] chars) {
        System.out.println("====");
        for (int k = 0; k < chars.length; k++) {
            for (int l = 0; l < chars[0].length; l++) {
                System.out.print(chars[k][l] + " ");
            }
            System.out.println("");
        }
    }

    //debug
    private static ArrayList getDetail(char[][] chars) {
        ArrayList<HashMap<String, Set<Character>>> objects = new ArrayList<>();
        initEffectiveRange(chars);

        for (int k = 0; k < chars.length; k++) {
            for (int l = 0; l < chars[0].length; l++) {
                if (chars[k][l] != '.') continue;
                HashMap<String, Set<Character>> objectObjectHashMap = new HashMap<>();
                objectObjectHashMap.put(k + "" + l, getEffectiveRange(chars, k, l));
                objects.add(objectObjectHashMap);
            }
        }

        Collections.sort(objects, (o1, o2) -> {
            int size = o1.entrySet().stream().findFirst().get().getValue().size();
            int size2 = o2.entrySet().stream().findFirst().get().getValue().size();
            return size - size2;
        });
        return objects;
    }

    private static int getNeedFillingCount(char[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') result++;
            }
        }
        return result;
    }

    private static void fillBoard(char[][] board, int i, int j, Character value) {
        board[i][j] = value;
        Set<Character> columnSet = COLUMN_EFFECTIVE_RANGE_MAP.get(j);
        Set<Character> rowSet = ROW_EFFECTIVE_RANGE_MAP.get(i);
        Set<Character> areaSet = AREA_EFFECTIVE_RANGE_MAP.get(i / 3 * 10 + j / 3);
        columnSet.remove(board[i][j]);
        rowSet.remove(board[i][j]);
        areaSet.remove(board[i][j]);
    }

    private static Set<Character> getEffectiveRange(char[][] board, int i, int j) {
        Set<Character> columnSet = COLUMN_EFFECTIVE_RANGE_MAP.get(j);
        Set<Character> rowSet = ROW_EFFECTIVE_RANGE_MAP.get(i);
        Set<Character> areaSet = AREA_EFFECTIVE_RANGE_MAP.get(i / 3 * 10 + j / 3);
        HashSet<Character> result = new HashSet<>(columnSet);
        result.retainAll(rowSet);
        result.retainAll(areaSet);
        return result;
    }

    private static final Map<Integer, Set<Character>> ROW_EFFECTIVE_RANGE_MAP = new HashMap<>();
    private static final Map<Integer, Set<Character>> COLUMN_EFFECTIVE_RANGE_MAP = new HashMap<>();
    private static final Map<Integer, Set<Character>> AREA_EFFECTIVE_RANGE_MAP = new HashMap<>();

    private static void initEffectiveRange(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            ROW_EFFECTIVE_RANGE_MAP.put(i, getRowEffectiveRange(board, i, 0));
        }

        for (int j = 0; j < board[0].length; j++) {
            COLUMN_EFFECTIVE_RANGE_MAP.put(j, getColumnEffectiveRange(board, 0, j));
        }

        HashMap<Integer, Set<Character>> areaMap = new HashMap<>();
        int areaX = board.length / 3;
        int areaY = board[0].length / 3;
        for (int i = 0; i < areaX; i++) {
            for (int j = 0; j < areaY; j++) {
                AREA_EFFECTIVE_RANGE_MAP.put(i * 10 + j, getAreaEffectiveRange(board, i * 3, j * 3));
            }
        }
    }

    private static Set<Character> getDefaultEffectiveRange() {
        HashSet<Character> hashSet = new HashSet(9);
        for (char k = '0'; k < '9'; ) {
            hashSet.add(++k);
        }
        return hashSet;
    }

    private static Set<Character> getRowEffectiveRange(char[][] board, int i, int j) {
        Set<Character> hashSet = getDefaultEffectiveRange();
        for (int k = 0; k < 9; k++) {
            hashSet.remove(board[i][k]);
        }
        return hashSet;
    }

    private static Set<Character> getColumnEffectiveRange(char[][] board, int i, int j) {
        Set<Character> hashSet = getDefaultEffectiveRange();
        for (int k = 0; k < 9; k++) {
            hashSet.remove(board[k][j]);
        }
        return hashSet;
    }

    private static Set<Character> getAreaEffectiveRange(char[][] board, int i, int j) {
        Set<Character> hashSet = getDefaultEffectiveRange();
        int x = i / 3;
        int y = j / 3;
        for (int k = x * 3; k < x * 3 + 3; k++) {
            for (int l = y * 3; l < y * 3 + 3; l++) {
                hashSet.remove(board[k][l]);
            }
        }
        return hashSet;
    }

}
