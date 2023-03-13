package me.start.Day06;

/**
 * 343. �������
 * ����һ�������� n ��������Ϊ k �� ������ �ĺͣ� k >= 2 ����
 * ��ʹ��Щ�����ĳ˻���󻯡������� ����Ի�õ����˻� ��
 * ʾ�� 1:
 * ����: n = 2
 * ���: 1
 * ����: 2 = 1 + 1, 1 �� 1 = 1��
 * ʾ�� 2:
 * ����: n = 10
 * ���: 36
 * ����: 10 = 3 + 3 + 4, 3 �� 3 �� 4 = 36��
 */
public class LC60600343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) { // ��2��ʼ���۳����ֵ
            for (int j = 1; j <= i - 1; j++) { // ���ƽ���
                // �����õķ����Ǵ�2��ʼ�����ۼӼ����ֻ������ֵ��һֱ�㵽Ŀ����
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
                System.out.println(dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 2;
        LC60600343 solution = new LC60600343();
        int res = solution.integerBreak(n);
        System.out.println(res);
    }
}
