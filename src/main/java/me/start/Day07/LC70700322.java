package me.start.Day07;

/**
 * 322. ��Ǯ�һ�
 * ����һ���������� coins ����ʾ��ͬ����Ӳ�ң�
 * �Լ�һ������ amount ����ʾ�ܽ�
 * ���㲢���ؿ��Դճ��ܽ������� ���ٵ�Ӳ�Ҹ��� ��
 * ���û���κ�һ��Ӳ�����������ܽ����� -1 ��
 * �������Ϊÿ��Ӳ�ҵ����������޵ġ�
 * ʾ�� 1��
 * ���룺coins = [1, 2, 5], amount = 11
 * �����3
 * ���ͣ�11 = 5 + 5 + 1
 */
public class LC70700322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins == null) {
            return 0;
        }
        int[] dp =new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount ; i++) {
                // ��һ�γ��ָ�Ӳ�ң�dp+1
                if (i == coin) {
                    dp[i] = 1;
                } else if (dp[i] == 0 && dp[i - coin] != 0) {
                    // ��ǰλ��Ϊ0����ȥ��ֵ��λ�ò�Ϊ0����ζ�Ÿ�Ӳ�Ҵ�ǰ�����Ҽ��Ϲ���
                    // �����ܼ�ֵ�������������ڴ�ǰ������+1
                    dp[i] = dp[i - coin] + 1;
                } else if (dp[i - coin] != 0) {
                    // �����ǰλ�ò�Ϊ0�����Ҽ�ȥ��ֵ��λ��Ҳ��Ϊ0����ζ�ţ���ǰ�Ѿ��ӹ�����Ӳ��
                    // ��˽���ǰ��Ӳ����dp[i]����ϵ�ǰ��ö+1Ӳ�����Ƚϣ�ȡС��ֵ
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        LC70700322 solution = new LC70700322();
        int res = solution.coinChange(coins, 11);
        System.out.println(res);
    }
}
