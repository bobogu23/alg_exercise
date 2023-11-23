package com.alg.exercise.new20231009hot100;

import com.alg.exercise.utils.CollectionPrintUtils;

/**
 * https://leetcode.cn/problems/rotate-image/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给矩阵顺时针旋转90度
 * <p>
 * 解：
 * 1、沿着 0，0 到 n-1,n-1 对角线，将两侧的数组中的元数的互换。
 * 2、按行将数组中的数字两两对换。0->n-1, 1->n-2
 *
 * @author ben.gu
 */
public class RotateImage_16 {
    public static void main(String[] args) {
        RotateImage_16 r = new RotateImage_16();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        r.rotate(matrix);
        CollectionPrintUtils.printNestedIntArray(matrix);
    }

    public void rotate(int[][] matrix) {
        //沿着对角线，将两侧数字交换
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //逐行将从左右两端开始，对换位置上的数字
        for (int i = 0; i < len; i++) {
            swap(matrix[i]);
        }
    }

    private void swap(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int tmp = arr[r];
            arr[r] = arr[l];
            arr[l] = tmp;
            l++;
            r--;
        }
    }

}
