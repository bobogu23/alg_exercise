package com.alg.exercise.easy.topcode20220829;

/**
 * https://leetcode.cn/problems/where-will-the-ball-fall/?plan=leetcode_75&plan_progress=zci8d5e
 */
public class FindBall {


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}};
        //[[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
        findBall(arr);
    }

    public static int[] findBall(int[][] grid) {
        //从顶部一行开始，如果往右下滚动，则先右移，再下移。碰到向左的挡板，则往左移，再下移。
        //成对出现 左挡板，或者右挡板 才能从底部掉出来。
        if (grid.length == 1 && grid[0].length == 1) {
            return new int[]{-1};
        }
        int[] result = new int[grid[0].length];
        int row = grid.length;
        int column = grid[0].length;
        for (int col = 0; col < column; col++) {
            int rowIndex = 0;
            int colIndex = col;
            while (rowIndex < row && colIndex >= 0 && colIndex < column) {
                if (grid[rowIndex][colIndex] == 1) {
                    //到边了，或者右边是 左挡板
                  if(colIndex + 1 == column || grid[rowIndex][colIndex + 1] == -1){
                      result[col] = -1;
                      break;
                  }
                  rowIndex++;
                  colIndex++;
                }else if (grid[rowIndex][colIndex] == -1) {
                    //到边了，或者左边是 右挡板
                    if(colIndex == 0 || grid[rowIndex][colIndex-1] == 1){
                        result[col] = -1;
                        break;
                    }
                    rowIndex++;
                    colIndex--;
                }
            }
            if(result[col] != -1){
                result[col] =colIndex;
            }
        }

        return result;
    }
}
