package me.start.Day07;

/**
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。
 * 如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 */
public class LC70661143_1 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null ||text2 == null) {
            return 0;
        }
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    // 优化：
    // 在矩阵中只有相邻的两行会有用，之前的数据其实可以丢弃掉了，所以空间复杂的可以减少到 O(min(m, n))，代码如下
    // 利用两个变量储存左上角的值
    // 有的说这是滚动数组
    // 暂时还没看
    public int longestCommonSubsequence02(String text1, String text2) {
        //重点看优化为一维数组，此时使用两个变量作为存储左上角的元素，
        // 并在s1.charAt(i-1)==s2.charAt(j-1)的情况下把t/pre的值+1赋给dp[j];
        // 举例：当s1=“ab”,s2="abac"时，dp数组如下：
        //             a       b        a          c
        //       0     0       0        0          0
        //   a   0     1      '1'      '1'(而不是2)
        //   c
        // 当对比'a'和'b'时，由于不相等故取max(dp[j],dp[j-1])，接下来对比'a'和'a',由于相等，
        // 如果没有先存下dp[1][2]被修改前的值，那么dp[1][3]就会变成dp[1][2]+1=1+1=2,不符合实际情况，
        // 因此要通过两个变量在每一次循环中不断更新左上角的值，
        // 并在s1.charAt(i-1)==s2.charAt(j-1)时把左上角的值(代码中为pre变量)赋给dp[j];
        int n = text1.length();
        int m = text2.length();
        int[] dp = new int[m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1, pre = dp[0]; j < m + 1; j++) {
                int t = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = pre + 1;
                } else if (text1.charAt(i - 1) != text2.charAt(j - 1)) {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = t;
            }
        }
        return dp[m];
    }
}
