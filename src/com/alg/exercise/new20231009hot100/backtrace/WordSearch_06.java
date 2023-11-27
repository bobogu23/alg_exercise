package com.alg.exercise.new20231009hot100.backtrace;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/word-search/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 *
 * 深度优先遍历，同时使用备忘录标记某个位置是否已经访问过了，同一个单元格内的字母不允许被重复使用。
 *
 * 遇到这种单元格遍历，不能重复使用的情况，就要使用 备忘录记录走过的位置是否访问过
 *
 *
 * 第一，为什么要用两层循环把dfs套在里面？
 *
 * 我们知道很多题目，直接dfs求解就可以返回了，而这题不可以，关键在于这个字符串的起始位置可以不在[0, 0]这个位置。
 * 而你如果不用循环套起来，就默认起点只能在[0, 0]，这样会丢掉很多解。
 *
 * 第二，为什么要用visit？
 *
 * 由于我们这条路是可以回头的，并非只能往右下方向走，所以可能会遇到回踩前一个刚刚访问过的格子，
 * 而这个格子，题目里说是不可以重复使用的。
 *
 * 第三，为什么visit需要复位？
 *
 * 因为当前格子作为中途某一处的起始点，并且走不通时，它是可以回退到上一个格子，并且选择其他方向重新开始的。
 * 而此时我们不希望当前格子的遍历路径影响到回退后新路径的尝试。
 *
 * @author ben.gu
 */
public class WordSearch_06 {
    public static void main(String[] args) {
        WordSearch_06 ws = new WordSearch_06();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},
                {'A','D','E','E'} };
        boolean res = ws.exist(board, "ABCCED");
        System.err.println(res);

    }

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                 dfs(board,i,j,word,0);
                 if(res){
                     return true;
                 }
            }
        }
        return false;
    }

    private boolean res = false;
    private boolean[][] visited;

    //从 row,col 开始向四周搜索，看是否匹配 word[p..]
    private void dfs(char[][] board, int row, int col, String word, int p) {
        //word已经匹配完了，找到了
        if (p == word.length()) {
            res = true;
            return;
        }

        //如果已经找到了一个答案，不需要再找了
        if (res) {
            return;
        }

        //边界情况
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        //row,col 位置字符不匹配，或者访问过了
        if (board[row][col] != word.charAt(p) || visited[row][col]) {
            return;
        }
        //选择条件
        visited[row][col] = true;
        //向四周扩散寻找。todo 此处每个方向寻找后，判断下结果，可以减少寻找次数，加速执行效率
        dfs(board, row - 1, col, word, p + 1);
        dfs(board, row + 1, col, word, p + 1);
        dfs(board, row, col + 1, word, p + 1);
        dfs(board, row, col - 1, word, p + 1);
        //撤销条件
        visited[row][col] = false;

    }
}
