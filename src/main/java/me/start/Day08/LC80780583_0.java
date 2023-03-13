package me.start.Day08;

/**
 * 583. �����ַ�����ɾ������
 * ������������ word1 �� word2 ������ʹ�� word1 ��  word2 ��ͬ�������С������
 * ÿ�� ����ɾ������һ���ַ����е�һ���ַ���
 * ʾ�� 1��
 * ����: word1 = "sea", word2 = "eat"
 * ���: 2
 * ����: ��һ���� "sea" ��Ϊ "ea" ���ڶ����� "eat "��Ϊ "ea"
 */
public class LC80780583_0 {
    public int minDistance(String s1, String s2) {
        // ת�����ַ�����
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int n = s1.length(), m = s2.length();
        //
        int[][] dp = new int[n + 1][m + 1];
        // ��ʼ��
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
