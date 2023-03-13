package me.start.Day07;

/**
 * 474. һ����
 * ����һ���������ַ������� strs ���������� m �� n ��
 * �����ҳ������� strs ������Ӽ��ĳ��ȣ����Ӽ��� ��� �� m �� 0 �� n �� 1 ��
 * ��� x ������Ԫ��Ҳ�� y ��Ԫ�أ����� x �Ǽ��� y �� �Ӽ� ��
 * ʾ�� 1��
 * ���룺strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * �����4
 * ���ͣ������ 5 �� 0 �� 3 �� 1 ������Ӽ��� {"10","0001","1","0"} ����˴��� 4 ��
 * �����������⵫��С���Ӽ����� {"0001","1"} �� {"10","1","0"} ��{"111001"} ���������⣬��Ϊ���� 4 �� 1 ������ n ��ֵ 3 ��
 */
public class LC70690474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            // Ԥ����strs�е�ÿһ���ַ���
            int zeros = 0, ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones ; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);

                }
            }
        }
        return dp[m][n];
    }
}
