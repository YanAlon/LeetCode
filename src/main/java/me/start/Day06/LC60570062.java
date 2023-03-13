package me.start.Day06;

import java.util.Arrays;

/**
 * 题目描述
 * 评论 (2.3k)
 * 题解 (4.0k)
 * 提交记录
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。
 * 机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 示例 1：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 */
public class LC60570062 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
                System.out.println("i:" + i + ", j: " + j);
                System.out.println(dp[j]);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        LC60570062 solution = new LC60570062();
        int res = solution.uniquePaths(m, n);
        System.out.println(res);
    }
}
