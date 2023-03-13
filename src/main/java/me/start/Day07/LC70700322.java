package me.start.Day07;

/**
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；
 * 以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 */
public class LC70700322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins == null) {
            return 0;
        }
        int[] dp =new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount ; i++) {
                // 第一次出现该硬币，dp+1
                if (i == coin) {
                    dp[i] = 1;
                } else if (dp[i] == 0 && dp[i - coin] != 0) {
                    // 当前位置为0，减去币值的位置不为0，意味着该硬币此前出现且加上过，
                    // 并且总价值还不够，所以在此前基础上+1
                    dp[i] = dp[i - coin] + 1;
                } else if (dp[i - coin] != 0) {
                    // 如果当前位置不为0，而且减去币值的位置也不为0，意味着，此前已经加过其它硬币
                    // 因此将此前的硬币数dp[i]与加上当前这枚+1硬币数比较，取小的值
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        LC70700322 solution = new LC70700322();
        int res = solution.coinChange(coins, 11);
        System.out.println(res);
    }
}
