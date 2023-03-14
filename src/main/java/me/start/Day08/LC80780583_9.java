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
public class LC80780583_9 {
    public int minDistance(String s1, String s2) {
        // 转换成字符数组
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int n = s1.length(), m = s2.length();
        //
        int[][] dp = new int[n + 1][m + 1];
        // 初始化
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
//                // 先预设不相等，则+1步操作
//                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);// 2, 1, 2, 3| 1, 2, 1, 2
//                // 若相等，则替换掉预设值
//                if (cs1[i - 1] == cs2[j - 1]) {
//                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]); // 0, 0
//                }
                // 改变上方的顺序，不预设，按正常顺序可以吗？
                // 实践证明，可以
                if (cs1[i - 1] == cs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[n][m];
    }


    // 最长子序列做法
    public int minDistance01(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int max = dp[word1.length()][word2.length()];
        return word1.length() - max + word2.length() - max;
    }
}
