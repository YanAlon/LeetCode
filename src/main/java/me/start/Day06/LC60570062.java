package me.start.Day06;

import java.util.Arrays;

/**
 * ��Ŀ����
 * ���� (2.3k)
 * ��� (4.0k)
 * �ύ��¼
 * 62. ��ͬ·��
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ ��Start�� ����
 * ������ÿ��ֻ�����»��������ƶ�һ����
 * ��������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ ��Finish�� ����
 * ���ܹ��ж�������ͬ��·����
 * ʾ�� 1��
 * ���룺m = 3, n = 2
 * �����3
 * ���ͣ�
 * �����Ͻǿ�ʼ���ܹ��� 3 ��·�����Ե������½ǡ�
 * 1. ���� -> ���� -> ����
 * 2. ���� -> ���� -> ����
 * 3. ���� -> ���� -> ����
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
