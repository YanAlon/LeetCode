package me.start.Day08;

/**
 * 309. ���������Ʊʱ�����䶳��
 * ����һ����������prices�����е�  prices[i] ��ʾ�� i ��Ĺ�Ʊ�۸� ��
 * ���һ���㷨������������
 * ����������Լ�������£�����Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ��:
 * ������Ʊ�����޷��ڵڶ��������Ʊ (���䶳��Ϊ 1 ��)��
 * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 * ʾ�� 1:
 * ����: prices = [1,2,3,0,2]
 * ���: 3
 * ����: ��Ӧ�Ľ���״̬Ϊ: [����, ����, �䶳��, ����, ����]
 */
public class LC80740309 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = 0; // �����й�Ʊ��Ҳû����
        dp[0][1] = 0; // �����й�Ʊ������ȥ��
        dp[0][2] = -1 * prices[0]; // ���й�Ʊ�����������
        dp[0][3] = -1 * prices[0]; // ���й�Ʊ��֮ǰ�����
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][3])  + prices[i];
            // ֻ����dp[i - 1][0]������Ϊ������
            dp[i][2] = dp[i - 1][0] - prices[i];
            // ע����max����Ϊ������Խ��˵�����Ĺɼ�Խ�ͣ���������ʱ�Ż�õ��������
            dp[i][3] = Math.max(dp[i -1][2], dp[i - 1][3]);
            System.out.println("dp[" + (i-1) + "][2]: " + dp[i - 1][2]);
            System.out.println("dp[" + (i-1) + "][3]: " + dp[i - 1][3]);
            System.out.println("dp[" + (i) + "][0]: " + dp[i][0]);
            System.out.println("dp[" + (i) + "][1]: " + dp[i][1]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        LC80740309 solution = new LC80740309();
        int res = solution.maxProfit(prices);
        System.out.println(res);
    }
}
