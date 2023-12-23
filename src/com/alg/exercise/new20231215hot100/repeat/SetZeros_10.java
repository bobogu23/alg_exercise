package com.alg.exercise.new20231215hot100.repeat;

/**
 * @Author: gu
 * @Date: 2023/12/23 下午12:51
 */
public class SetZeros_10 {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] zero_row = new boolean[row];
        boolean[] zero_col = new boolean[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                  if(matrix[i][j] == 0){
                      zero_row[i] = true;
                      zero_col[j] = true;
                  }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                 if(zero_row[i] || zero_col[j]){
                     matrix[i][j] =0;
                 }
            }
        }


    }

}
