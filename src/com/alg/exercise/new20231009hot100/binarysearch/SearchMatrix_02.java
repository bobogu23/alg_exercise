package com.alg.exercise.new20231009hot100.binarysearch;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * <p>
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 * <p>
 * 解题：
 * 先二分查找每行的第一个整数，找到第一个大于等于 target的那个整数，假设所在行为n.
 * 如果 整数刚好是 target，return true。
 * 否则 target在n-1行 。
 *
 *
 * <p>
 * 然后二分查找这一行的数据
 *
 * @author ben.gu
 */
public class SearchMatrix_02 {


    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int l = 0, h = rows - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        int row = l - 1 < 0 ? 0 : l - 1;
        int[] line = matrix[row];
        int left = 0, right = line.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (line[mid] == target) {
                return true;
            } else if (line[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
