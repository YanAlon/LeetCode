package me.start.Day08;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。
 * 在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1:
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class LC80740309 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = 0; // 不持有股票，也没卖出
        dp[0][1] = 0; // 不持有股票，卖出去了
        dp[0][2] = -1 * prices[0]; // 持有股票，今天买入的
        dp[0][3] = -1 * prices[0]; // 持有股票，之前买入的
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][3])  + prices[i];
            // 只计算dp[i - 1][0]的是因为冻结期
            dp[i][2] = dp[i - 1][0] - prices[i];
            // 注意是max，因为负的数越大，说明它的股价越低，这样卖出时才会得到最大利益
            dp[i][3] = Math.max(dp[i -1][2], dp[i - 1][3]);
            System.out.println("dp[" + (i-1) + "][2]: " + dp[i - 1][2]);
            System.out.println("dp[" + (i-1) + "][3]: " + dp[i - 1][3]);
            System.out.println("dp[" + (i) + "][0]: " + dp[i][0]);
            System.out.println("dp[" + (i) + "][1]: " + dp[i][1]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        LC80740309 solution = new LC80740309();
        int res = solution.maxProfit(prices);
        System.out.println(res);
    }
}
