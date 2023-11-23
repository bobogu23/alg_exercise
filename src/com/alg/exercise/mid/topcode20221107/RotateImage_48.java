package com.alg.exercise.mid.topcode20221107;

/**
 * https://leetcode.cn/problems/rotate-image/?favorite=2cktkvj
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class RotateImage_48 {

    /***
     * 沿着从左上往右下的对角线 对称位置交换数组的元素
     * 然后每一行数组进行反转
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            swap(matrix[i]);
        }


    }

    private void swap(int[] matrix) {
        int i = 0;
        int j = matrix.length - 1;
        while (i < j) {
            int temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }

    }


}
