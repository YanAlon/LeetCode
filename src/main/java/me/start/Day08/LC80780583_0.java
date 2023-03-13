package me.start.Day08;

/**
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * 每步 可以删除任意一个字符串中的一个字符。
 * 示例 1：
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 */
public class LC80780583_0 {
    public int minDistance(String s1, String s2) {
        // 转换成字符数组
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int n = s1.length(), m = s2.length();
        //
        int[][] dp = new int[n + 1][m + 1];
        // 初始化
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                if (cs1[i - 1] == cs2[j - 1]) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
            }
        }
        return dp[n][m];
    }
}
