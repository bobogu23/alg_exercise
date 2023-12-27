package com.alg.exercise.new20231215hot100.repeat;

/**
 *
 *
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 *
 * @Author: gu
 * @Date: 2023/12/25 下午9:13
 */
public class SearchMatrix {


    //二分查找 ，m*n 矩阵 转换成 m*n 长度的数组，查找matrix中对应的位置时，做一下转换
    // row = mid / matrix.length, col = mid % matrix[0].length
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int len = m * n;
        int low = 0 ,high = len-1;
        while (low <= high){
            int mid  = high -(high-low)/2;
            int row = mid / m;
            int col = mid % m;
            int num = matrix[row][col];
            if( num == target){
                return true;
            }
            if(num < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return false;

    }

}
