package com.alg.exercise.easy.topcode20220829;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/spiral-matrix/?plan=leetcode_75&plan_progress=zci8d5e
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};

        List<Integer> nums = spiralOrder2(array);
        nums.forEach(System.err::println);
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int totalSize = rows * columns;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int row = 0, column = 0;
        for (int i = 0; i < totalSize; i++) {
            result.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns
                    || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return result;

    }

    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int top = 0, right = matrix[0].length, left = 0, bottom = matrix.length;
        //从左往右，往下，往左，往上，
        //往右，往下，往左，往上 ，如此循环

        while (top <= bottom - 1 && left <= right-1) {
            for (int i = left; i < right; i++) {
                result.add(matrix[top][i]);
            }
            for (int i = top + 1; i < bottom; i++) {
                result.add(matrix[i][right-1]);
            }
            if(left < right-1 && top < bottom-1){
                for (int i = right - 2; i >= left; i--) {
                    result.add(matrix[bottom - 1][i]);
                }
                for (int i = bottom - 2; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }

            top++;
            left++;
            right--;
            bottom--;
        }

        return result;

    }


}
