package com.alg.exercise.new20231009hot100;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/spiral-matrix/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 右-》下—》左—》上的顺序遍历矩阵，
 * 同时定义好上，右，下，左 的边界，不断缩小边界。
 * 终止条件是遍历完矩阵的所有元素
 * <p>
 * row
 *
 * @author ben.gu
 */
public class SpiralMatrix_15 {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix = {{7}, {9}, {6}};
//        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        SpiralMatrix_15 s = new SpiralMatrix_15();
        List<Integer> res = s.spiralOrder(matrix);
        CollectionPrintUtils.printList(res);

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>(m * n);
        int up = 0;
        int right = n - 1;
        int down = m - 1;
        int left = 0;
        while (list.size() < m * n) {
            //右
            if (up <= down) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[up][i]);
                }
                up++;
            }

            //下
            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
            }

            //左
            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[down][i]);
                }
                down--;
            }

            //上
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
        }
        return list;
    }

}
