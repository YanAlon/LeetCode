package me.start.Day08;

/**
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；
 * 整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。
 * 如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * 示例 1：
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
 */
public class LC80750714 {
    public int maxProfit(int[] prices, int pee) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = 0; // 不持有股票，也没卖出
        dp[0][1] = 0; // 不持有股票，卖出去了
        dp[0][2] = -1 * prices[0]; // 持有股票，今天买入的
        dp[0][3] = -1 * prices[0]; // 持有股票，之前买入的
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][3])  + prices[i] - pee;
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) - 1 * prices[i];
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
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int pee = 2;
        LC80750714 solution = new LC80750714();
        int res = solution.maxProfit(prices, pee);
        System.out.println(res);
    }
}
