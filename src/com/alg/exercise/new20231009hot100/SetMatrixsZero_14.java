package com.alg.exercise.new20231009hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 按照行遍历矩阵，如果行数组中有元素为0，则这一行数组需要全部置为0，记录当前行数组的索引i。并且记录列索引 j，每个
 * 行数组中j位置的数字置为0。
 *
 * @author ben.gu
 */
public class SetMatrixsZero_14 {

    //[[0,0,0,5],[4,3,1,4],[0,1,1,4],[1,2,1,3],[0,0,1,1]]
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0, 5}, {4, 3, 1, 4}, {0, 1, 1, 4}, {1, 2, 1, 3}, {0, 0, 1, 1}};
        SetMatrixsZero_14 m = new SetMatrixsZero_14();
        m.setZeroes(matrix);
        System.err.println(matrix);
    }

    public void setZeroes(int[][] matrix) {

        Set<Integer> zero_row = new HashSet<>();
        Set<Integer> zero_col = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) {
                    zero_row.add(i);
                    zero_col.add(j);
                }
            }
        }

        if (zero_row.size() > 0) {
            zero_row.forEach(row->{
                Arrays.fill(matrix[row], 0);
            });
            zero_col.forEach(col->{
                fillZero(matrix, col);
            });
        }
    }

    private void fillZero(int[][] matrix, int colIndex) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][colIndex] = 0;
        }
    }


}
