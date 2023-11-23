package com.alg.exercise.new20231009hot100;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 二分查找
 *
 * @author ben.gu
 */
public class Search2DMatrix_17 {

    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            if(binarySearch(matrix[i],target)){
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

}
