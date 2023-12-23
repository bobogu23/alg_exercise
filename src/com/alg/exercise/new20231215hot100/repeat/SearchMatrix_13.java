package com.alg.exercise.new20231215hot100.repeat;

/**
 * @Author: gu
 * @Date: 2023/12/23 下午4:09
 */
public class SearchMatrix_13 {

    public static void main(String[] args) {
        int[][] m = {{1},{3},{5}};
        int t = 5;
        SearchMatrix_13 s = new SearchMatrix_13();
        boolean b = s.searchMatrix(m, t);
        System.err.println(b);
    }

    //第一列二分查找，找到第一个小于target的行 row
    // 在 0~row 行中 每行二分查找target
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;

        int low = 0;
        int high = rows - 1;
        int row_max = -1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            int num = matrix[mid][0];
            if (num == target) {
                return true;
            }
            if (num < target) {
                //找到第一个小于 target的行
                if(mid + 1 >= rows || matrix[mid+1][0] > target){
                    row_max = mid;
                    break;
                }else{
                    low  = mid + 1 ;
                }
            }
            else {
                high = mid - 1;
            }
        }

        if(row_max == -1){
            return false;
        }

        for (int r = 0; r <= row_max; r++) {
            int[] arr = matrix[r];
            int l = 0;
            int h = arr.length - 1;

            while (l <= h) {
                int mid = h - (h - l) / 2;
                int num = arr[mid];
                if (num == target) {
                    return true;
                }
                if (num < target) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }

        return false;
    }


}
