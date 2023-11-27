package com.alg.exercise.new20231009hot100.backtrace;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/n-queens/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * <p>
 * 解法：
 * 遍历每一行，尝试在每一行的每一列上放置皇后，看是否满足不能攻击的条件。
 * <p>
 * 使用回溯算法，其实是在遍历一颗决策树，树的每一层代表棋盘的每列，
 *
 * @author ben.gu
 */
public class Solve_N_Queue_08 {
    public static void main(String[] args) {
        int n = 8;
        Solve_N_Queue_08 queen = new Solve_N_Queue_08();
        List<List<String>> res = queen.solveNQueens(n);
        res.forEach(CollectionPrintUtils::printList);

    }


    public List<List<String>> solveNQueens(int n) {
        //初始化一个n*n的棋盘
        List<String> board = new ArrayList<>(n);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(".");
        }
        String line = builder.toString();
        for (int i = 0; i < n; i++) {
            board.add(line);
        }
        backtrace(board, 0);
        return res;
    }

    private List<List<String>> res = new ArrayList<>();

    //row之前的行都放置好了符合条件的皇后
    //在row行的每一列尝试放置皇后
    private void backtrace(List<String> board, int row) {
        if (board.size() == row) {
            res.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            String line = board.get(row);
            char[] chars = line.toCharArray();
            //选择
            chars[col] = 'Q';
            board.set(row, String.valueOf(chars));
            backtrace(board, row + 1);
            //撤销选择
            chars[col] = '.';
            board.set(row, String.valueOf(chars));
        }

    }


    // 判断是否能在 board[row][col] 放置皇后
    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();
        //同一行
        String line = board.get(row);
        if (line.contains("Q")) {
            return false;
        }

        //同一列
        for (int i = 0; i < row; i++) {
            char sameCol = board.get(i).charAt(col);
            if (sameCol == 'Q') {
                return false;
            }
        }

        //左下到右上
        int preCol = col;
        for (int i = row - 1; i >= 0; i--) {
            preCol++;
            if (preCol >= n) {
                break;
            }
            if (board.get(i).charAt(preCol) == 'Q') {
                return false;
            }
        }

        //左上到右下
        int lefUpCol = col;
        for (int i = row - 1; i >= 0; i--) {
            lefUpCol--;
            if (lefUpCol < 0) {
                break;
            }
            if (board.get(i).charAt(lefUpCol) == 'Q') {
                return false;
            }
        }
        return true;
    }

}
