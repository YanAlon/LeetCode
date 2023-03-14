package me.start.Day08;

/**
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2，
 * 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 */
public class LC80790072 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化j = 0
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i; // 相当于目标word2为null，需要将word1全删掉
        }
        // 初始化i= 0
        for (int j = 0; j < len2 + 1; j++) {
            dp[0][j] = j; // 相当于word1为null，需要将目标word2全插入
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    System.out.println("2dp[" + i + "][" + j + "]: " + dp[i][j]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        LC80790072 solution = new LC80790072();
        int res = solution.minDistance(word1, word2);
        System.out.println(res);
    }
}
