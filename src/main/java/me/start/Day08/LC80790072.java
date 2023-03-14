package me.start.Day08;

/**
 * 72. �༭����
 * ������������ word1 �� word2��
 * �뷵�ؽ� word1 ת���� word2 ��ʹ�õ����ٲ�����  ��
 * ����Զ�һ�����ʽ����������ֲ�����
 * ����һ���ַ�
 * ɾ��һ���ַ�
 * �滻һ���ַ�
 * ʾ�� 1��
 * ���룺word1 = "horse", word2 = "ros"
 * �����3
 * ���ͣ�
 * horse -> rorse (�� 'h' �滻Ϊ 'r')
 * rorse -> rose (ɾ�� 'r')
 * rose -> ros (ɾ�� 'e')
 */
public class LC80790072 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        // ��ʼ��j = 0
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i; // �൱��Ŀ��word2Ϊnull����Ҫ��word1ȫɾ��
        }
        // ��ʼ��i= 0
        for (int j = 0; j < len2 + 1; j++) {
            dp[0][j] = j; // �൱��word1Ϊnull����Ҫ��Ŀ��word2ȫ����
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
