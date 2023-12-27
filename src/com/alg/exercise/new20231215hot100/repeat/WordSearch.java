package com.alg.exercise.new20231215hot100.repeat;

import java.util.LinkedList;

/**
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * @Author: gu
 * @Date: 2023/12/25 上午10:25
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board ={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        WordSearch w = new WordSearch();
        String word  ="ABCCED";
        boolean exist = w.exist(board, word);
        System.err.println(exist);
    }

    // 遍历网格的每个位置，从该位置出发，往上，下，左，右 移动，看是否能组成 单词word
    //终止条件，遍历到边界了，判断字符组合是否匹配。 或者 字符组合达到 word的长度了，判断字符组合是否匹配。
    //同一单元格字母不能重复使用，需要有个备忘录记录走过的路径

     private boolean exist = false;
    private boolean[][] memo = null;

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        memo = new boolean[row][col];

        for(int i = 0;i<row;i++){
            for(int j = 0;j < col;j++){
                dfs(board,word,i,j,0);
                if(exist){
                    return true;
                }
            }

        }
        return exist;
    }

    private void dfs(char[][] board, String word,int row,int col,int p){
        //终止条件
        if(p == word.length()){
            exist=true;
            return;
        }
        if(exist){
            return;
        }
        //边界条件
        int m = board.length;
        int n = board[0].length;
        if(row < 0 || row >=m || col <0 || col >= n){
            return;
        }
        if(memo[row][col]){
           return ;
        }
        if(board[row][col] != word.charAt(p)){
            return;
        }
        memo[row][col]=true;
        dfs(board,word,row,col+1,p+1);
        dfs(board,word,row,col-1,p+1);
        dfs(board,word,row-1,col,p+1);
        dfs(board,word,row+1,col,p+1);
        memo[row][col]=false;

    }




}
