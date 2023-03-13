package me.start.Day07;

/**
 * (0-1背包补充题)
 * 0-1 背包
 * 有一个容量为 W 的背包，要用这个背包装下物品的价值最大，这些物品有两个属性：体积 weights 和价值 values。
 * 示例1：
 * 输入W = 6， N = 4, weights = {1, 3, 4, 2}, values = {5, 2, 7, 2}
 */
public class LC70670000_9 {
    // W 为背包总体积
    // N 为物品数量
    // weights 数组存储 N 个物品的重量
    // values 数组存储 N 个物品的价值
    // 1、路径规划
    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = 1; j <= W; j++) {
                if (j >= w) {
                    // 这一个转移方程做到了在同样体积下选择最大价值
                    // 那会不会出现超出体积的情况呢，这里也没有加边界判断？
                    // 答案是，并不会。举个例子
                    // 第一个物品的w是2，那它只有在j=2的那一刻才开始存入
                    // 第二个物品的w是3，当j=3时，它叠加的价值是dp[1】[0]的价值，
                    // 也就是说，在叠加时也是从0开始的，只有移动了前一个物品的体积w个位置后，才会与前一个物品叠加
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                    System.out.println(">= dp[" + i + "][" + j + "]: " + dp[i][j]);
                } else {
                    System.out.println("w: " + w);
                    dp[i][j] = dp[i - 1][j];
                    System.out.println("< dp[" + i + "][" + j + "]: " + dp[i][j]);
                }
            }
        }
        return dp[N][W];
    }

    // 2、空间优化
    public int knapsack02(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = W; j >= 1; j--) {
                if (j >= w) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int W = 6, N = 4;
        int[] weights = {2, 3, 4, 2}, values = {5, 2, 7, 2};
        LC70670000_9 solution = new LC70670000_9();
        int res = solution.knapsack(W, N, weights, values);
        System.out.println(res);
    }
}
