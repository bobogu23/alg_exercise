package com.alg.exercise.new20230625.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/n-queens/
 * <p>
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位
 * <p>
 * 解法：
 * 回溯算法。
 * 定义变量row，从0开始，到n-1。
 * <p>
 * 先把棋盘初始化好，棋盘默认都是 "."
 * <p>
 * 每一行从第一列开始放棋子，判断是否能放。
 */
public class NQueens_02 {

    private List<List<String>> res = new ArrayList<>();
    private List<String> track = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        return null;
    }

    private void backtrack(List<String> board, int row) {
        //终止条件
        if (board.size() == row) {
            res.add(board);
            return;
        }
        //宽度
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            //判断当前位置是否能放棋子
            if (!isValid(board, col, row)) {
                continue;
            }
            // 做选择
            char[] arr = board.get(row).toCharArray();
            arr[col] = 'Q';
            board.set(row, String.valueOf(arr));
            //回溯
            backtrack(board, row + 1);
            //撤销选择
            arr[col] = '.';
            board.set(row, String.valueOf(arr));
        }

    }

    //只需判断相同列，左上，右上是否存在 棋子。左下，右下 还没开始放棋子，所以不用判断
    private boolean isValid(List<String> board, int col, int row) {
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        if (col > 0 && row > 0 && board.get(row - 1).charAt(col - 1) == 'Q') {
            return false;
        }

        if (row > 0 && col + 1 < board.get(row - 1).length() && board.get(row - 1).charAt(col + 1) == 'Q') {
            return false;
        }
        return true;
    }


}
