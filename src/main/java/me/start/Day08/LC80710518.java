package me.start.Day08;

/**
 *
 */
public class LC80710518 {
    public int coinChange2(int[] coins, int amount) {
        if (amount <= 0 || coins == null) {
            return -1;
        }
        int[] dp =new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            System.out.println("coin: " + coin);
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
                System.out.println("i: " + i + ", dp[i]:" + dp[i] + ", dp[" + (i - coin) + "]: " + dp[i - coin]);
            }
        }
        return dp[amount];
    }
}
