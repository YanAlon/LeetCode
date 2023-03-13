package me.start.Day08;

/**
 * 518. 零钱兑换 II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 * 示例 1：
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 */
public class LC80710518 {
    public int coinChange2(int[] coins, int amount) {
        if (amount <= 0 || coins == null) {
            return -1;
        }
        int[] dp =new int[amount + 1];
        dp[0] = 1; // 只有当不选取任何硬币时，金额之和才为0，因此只有 1 种硬币组合
        for (int coin : coins) {
            System.out.println("coin: " + coin);
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
