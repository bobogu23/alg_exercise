package com.alg.exercise.new20231009hot100.dp;

/**
 * 给定不同面额的硬币和一个总金额，假设每种面额的硬币数量无限，凑成总金额的组合数是多少？
 * <p>
 * 动态规划：
 * 状态： 背包的容量，可选择的物品
 * 选择： 装进或者不装进背包，
 * <p>
 * 动态规划框架：
 * for(状态1：状态1的集合)
 *    for(状态2：状态2的集合)
 *      ...
 *      dp[状态1][状态2][...] = 计算（选择1，选择2...）
 *
 * @Author: gu
 * @Date: 2023/12/12 下午1:11
 */
public class CoinChange2_07 {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins= {1,2,5};
        CoinChange2_07 c  = new CoinChange2_07();
        int res = c.coinChange(coins, amount);
        System.err.println(res);

    }

    //dp[amount][n] 装满amount的背包，使用前n个硬币，有dp[amount][n]种组合
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[][] dp = new int[amount + 1][ len+ 1];
        //base case.金额为0，组合数为1.不使用硬币，无法凑出金额
        for (int i = 0; i <= len; i++) {
            dp[0][i] = 1;
        }
        //默认0.不写也没事。
//        for (int i = 0; i <= amount; i++) {
//            dp[i][0] = 0;
//        }

        //套动态规划框架
        for(int i=1;i<=amount;i++){
            for(int j=1;j<=len;j++){
                //背包满了
                if(i-coins[j-1] <0){
                    dp[i][j] = dp[i][j-1];
                }else {
                    //装或者不装进背包.组合数= 不装，装 的情况总和。
                    //不装进背包，则和使用前 j-1个硬币，容量为 i 的组合数一致。
                    //在容量为i的前提下，要想能装进背包，则组合数要基于dp[i-coins[j-1]][j].
                    //此处跟0-1背包问题不同，硬币数可以无限。不需要取 j-1个硬币。
                    dp[i][j] = dp[i][j-1]+dp[i-coins[j-1]][j];
                }
            }
        }

        return dp[amount][len];

    }

}
