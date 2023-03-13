package me.start.Day06;

/**
 * 343. 整数拆分
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），
 * 并使这些整数的乘积最大化。，返回 你可以获得的最大乘积 。
 * 示例 1:
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 */
public class LC60600343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) { // 从2开始算累乘最大值
            for (int j = 1; j <= i - 1; j++) { // 控制进度
                // 它采用的方法是从2开始不断累加计算拆分积的最大值，一直算到目标数
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
                System.out.println(dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 2;
        LC60600343 solution = new LC60600343();
        int res = solution.integerBreak(n);
        System.out.println(res);
    }
}
