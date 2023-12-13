package com.alg.exercise.new20231009hot100.dp;

/**
 * 0-1 背包问题
 * <p>
 * 动态规划：
 * dp[i][w]:对于前i个物品，当背包容量为w，可以装下的最大价值是dp[i][w]
 * <p>
 * base case :dp[0][...], dp[...][0], 背包中没有物品或者容量为0 ，价值为0
 * <p>
 * i从 1 开始，第i个物品的重量是 wt[i-1],价值是value[i-1]
 *
 * @Author: gu
 * @Date: 2023/12/12 上午11:02
 */
public class ZeroOneBag_05 {
    public static void main(String[] args) {
        int n =3,w=4;
        int[] wt ={2,1,3};
        int[] val ={4,2,3};
        ZeroOneBag_05 z = new ZeroOneBag_05();
        int res = z.maxValue(wt, val, w, n);
        System.err.println(res);

    }

    //w:背包最大重量w，n:背包能装n个物品
    public int maxValue(int[] wt, int[] val, int w, int n) {

        int[][] dp = new int[n + 1][w + 1];
        //base case
        for (int i = 0; i < w + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if(j - wt[i-1] < 0){
                    //背包容量不够,不放入背包
                    dp[i][j] = dp[i-1][j];
                }else {
                    //选择放入背包，或者不放入背包
                    dp[i][j] = Math.max(
                            dp[i-1][j],//不放入背包
                            dp[i-1][j-wt[i-1]]+ val[i-1] //放入背包。
                            //能放入背包的前提是，加入第i物品之后，重量仍满足条件。
                            // 也就是 w-wt[i-1] >= 0
                    );
                }
            }
        }
        return dp[n][w];

    }


}
