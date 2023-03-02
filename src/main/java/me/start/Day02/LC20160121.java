package me.start.Day02;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，
 * 在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；
 * 同时，你不能在买入前卖出股票。
 */
public class LC20160121 {
    // 动态规划做题步骤
    // 1.明确 dp(i) 应该表示什么（二维情况：dp(i)(j)）；
    // 2.dp(i) 和 dp(i?1) 的关系得出状态转移方程；
    //  例：dp[i]=max(dp[i?1], prices[i]?minprice)
    // 3.确定初始条件，如 dp(0)。
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int [] dp = new int[prices.length];
        dp[0] = 0;
        int minprice = prices[0];
        for (int i = 1; i < prices.length - 1; i++) {
            // 每次只与之前出现的最小数比较
            dp[i] = Math.max(dp[i - 1], prices[i] - minprice);
            // 当出现新的最小数时，替换掉，因为后续比较不可能再与前面出现的数产生更大分差
            minprice = Math.min(prices[i], minprice);
        }
        return dp[prices.length - 1];
    }
}
