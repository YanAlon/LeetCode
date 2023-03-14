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
public class LC80780583_9 {
    public int minDistance(String s1, String s2) {
        // ת�����ַ�����
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int n = s1.length(), m = s2.length();
        //
        int[][] dp = new int[n + 1][m + 1];
        // ��ʼ��
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
//                // ��Ԥ�費��ȣ���+1������
//                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);// 2, 1, 2, 3| 1, 2, 1, 2
//                // ����ȣ����滻��Ԥ��ֵ
//                if (cs1[i - 1] == cs2[j - 1]) {
//                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]); // 0, 0
//                }
                // �ı��Ϸ���˳�򣬲�Ԥ�裬������˳�������
                // ʵ��֤��������
                if (cs1[i - 1] == cs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[n][m];
    }


    // �����������
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
