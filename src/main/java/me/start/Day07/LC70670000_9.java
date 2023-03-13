package me.start.Day07;

/**
 * (0-1����������)
 * 0-1 ����
 * ��һ������Ϊ W �ı�����Ҫ���������װ����Ʒ�ļ�ֵ�����Щ��Ʒ���������ԣ���� weights �ͼ�ֵ values��
 * ʾ��1��
 * ����W = 6�� N = 4, weights = {1, 3, 4, 2}, values = {5, 2, 7, 2}
 */
public class LC70670000_9 {
    // W Ϊ���������
    // N Ϊ��Ʒ����
    // weights ����洢 N ����Ʒ������
    // values ����洢 N ����Ʒ�ļ�ֵ
    // 1��·���滮
    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = 1; j <= W; j++) {
                if (j >= w) {
                    // ��һ��ת�Ʒ�����������ͬ�������ѡ������ֵ
                    // �ǻ᲻����ֳ������������أ�����Ҳû�мӱ߽��жϣ�
                    // ���ǣ������ᡣ�ٸ�����
                    // ��һ����Ʒ��w��2������ֻ����j=2����һ�̲ſ�ʼ����
                    // �ڶ�����Ʒ��w��3����j=3ʱ�������ӵļ�ֵ��dp[1��[0]�ļ�ֵ��
                    // Ҳ����˵���ڵ���ʱҲ�Ǵ�0��ʼ�ģ�ֻ���ƶ���ǰһ����Ʒ�����w��λ�ú󣬲Ż���ǰһ����Ʒ����
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                    System.out.println(">= dp[" + i + "][" + j + "]: " + dp[i][j]);
                } else {
                    System.out.println("w: " + w);
                    dp[i][j] = dp[i - 1][j];
                    System.out.println("< dp[" + i + "][" + j + "]: " + dp[i][j]);
                }
            }
        }
        return dp[N][W];
    }

    // 2���ռ��Ż�
    public int knapsack02(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = W; j >= 1; j--) {
                if (j >= w) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int W = 6, N = 4;
        int[] weights = {2, 3, 4, 2}, values = {5, 2, 7, 2};
        LC70670000_9 solution = new LC70670000_9();
        int res = solution.knapsack(W, N, weights, values);
        System.out.println(res);
    }
}
