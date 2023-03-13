package me.start.Day08;

/**
 * 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1：
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 */
public class LC80770188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k + 1][2];
        for (int j = 0; j < k + 1; j++) {
            dp[0][j][0] = 0; // 手中不持有股票
            dp[0][j][1] = -1 * prices[0]; // 手中持有股票
        }
        for (int i = 1; i < n; i++) {
            // 初始化
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            for (int j = 1; j < k + 1; j++) {
                // 上一次买入的股票卖出后，就开始新一次的未持有股票
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}
