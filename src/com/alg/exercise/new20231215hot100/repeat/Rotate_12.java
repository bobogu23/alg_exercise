package com.alg.exercise.new20231215hot100.repeat;

/**
 * @Author: gu
 * @Date: 2023/12/23 下午3:54
 */
public class Rotate_12 {
    //对角线两侧调换，然后每行翻转
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //每行翻转
        for (int i = 0; i < m; i++) {
            reverse(matrix[i]);
        }
    }

    private void reverse(int[] matrix) {
        int end = matrix.length - 1;
        int start = 0;
        while (start < end) {
            int tmp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = tmp;
            start++;
            end--;
        }
    }


}
