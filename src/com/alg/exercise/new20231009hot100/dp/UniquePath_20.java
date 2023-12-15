package com.alg.exercise.new20231009hot100.dp;

/**
 * https://leetcode.cn/problems/unique-paths/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 解法：
 * 机器人只能向下或者向右移动，
 * 到右下角有多少条路径，等于 到左边的格子的路径+到上面的格子的路径
 * <p>
 * 状态：网格的坐标
 * 选择：向下，向右
 * <p>
 * dp[i][j] 到 坐标i,j 的路径数量。
 * <p>
 * dp[0][...] 的路径数量1
 * dp[..][0]路径数量1
 *
 * @Author: gu
 * @Date: 2023/12/14 下午6:49
 */
public class UniquePath_20 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        //状态
        for(int i = 1;i<m;i++){
            for(int j =1;j<n;j++){
                //选择
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


}
