package com.alg.exercise.mid.topcode20221107;

/**
 * 回溯
 */
public class WordSearch_79 {
    private int[][] directions = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
    private boolean[][] visited;
    private char[] charArray;

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String s = "ABCB";
        WordSearch_79 w = new WordSearch_79();
        System.err.println(w.exist(board, s));

    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];
        charArray = word.toCharArray();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (dfs(x, y, 0, board)) {
                    return true;
                }
            }

        }

        return false;
    }

    public boolean dfs(int x, int y, int start, char[][] board) {
        if (start == charArray.length - 1) {
            return board[x][y] == charArray[start];
        }
        //如果x,y位置上的字符等于单词中的字符
        if (board[x][y] == charArray[start]) {
            //回溯算法，选择
            visited[x][y] = true;
            //继续朝4个方向探索下一个位置的字符是否等于单词中下一个字符
            for (int[] direct : directions) {
                int xx = x + direct[0];
                int yy = y + direct[1];
                //判断是否越界，是否访问过
                if (inArea(xx, yy, board) && !visited[xx][yy]) {
                    if (dfs(xx, yy, start + 1, board)) {
                        return true;
                    }

                }
            }
            // 撤销选择
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y, char[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }


}
