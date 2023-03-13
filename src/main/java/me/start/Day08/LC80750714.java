package me.start.Day08;

/**
 * 714. ������Ʊ�����ʱ����������
 * ����һ���������� prices������ prices[i]��ʾ�� i ��Ĺ�Ʊ�۸� ��
 * ���� fee �����˽��׹�Ʊ���������á�
 * ��������޴ε���ɽ��ף�������ÿ�ʽ��׶���Ҫ�������ѡ�
 * ������Ѿ�������һ����Ʊ����������֮ǰ��Ͳ����ټ��������Ʊ�ˡ�
 * ���ػ����������ֵ��
 * ע�⣺�����һ�ʽ���ָ������в�������Ʊ���������̣�ÿ�ʽ�����ֻ��ҪΪ֧��һ�������ѡ�
 * ʾ�� 1��
 * ���룺prices = [1, 3, 2, 8, 4, 9], fee = 2
 * �����8
 * ���ͣ��ܹ��ﵽ���������:
 * �ڴ˴����� prices[0] = 1
 * �ڴ˴����� prices[3] = 8
 * �ڴ˴����� prices[4] = 4
 * �ڴ˴����� prices[5] = 9
 * ������: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
 */
public class LC80750714 {
    public int maxProfit(int[] prices, int pee) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = 0; // �����й�Ʊ��Ҳû����
        dp[0][1] = 0; // �����й�Ʊ������ȥ��
        dp[0][2] = -1 * prices[0]; // ���й�Ʊ�����������
        dp[0][3] = -1 * prices[0]; // ���й�Ʊ��֮ǰ�����
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][3])  + prices[i] - pee;
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) - 1 * prices[i];
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
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int pee = 2;
        LC80750714 solution = new LC80750714();
        int res = solution.maxProfit(prices, pee);
        System.out.println(res);
    }
}
