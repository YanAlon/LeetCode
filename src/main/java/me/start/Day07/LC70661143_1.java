package me.start.Day07;

/**
 * 1143. �����������
 * ���������ַ��� text1 �� text2�������������ַ������ ���������� �ĳ��ȡ�
 * ��������� ���������� ������ 0 ��
 * һ���ַ����� ������ ��ָ����һ���µ��ַ�����
 * ������ԭ�ַ����ڲ��ı��ַ������˳��������ɾ��ĳЩ�ַ���Ҳ���Բ�ɾ���κ��ַ�������ɵ����ַ�����
 * ���磬"ace" �� "abcde" �������У��� "aec" ���� "abcde" �������С�
 * �����ַ����� ���������� ���������ַ�������ͬӵ�е������С�
 * ʾ�� 1��
 * ���룺text1 = "abcde", text2 = "ace"
 * �����3
 * ���ͣ�������������� "ace" �����ĳ���Ϊ 3 ��
 */
public class LC70661143_1 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null ||text2 == null) {
            return 0;
        }
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    // �Ż���
    // �ھ�����ֻ�����ڵ����л����ã�֮ǰ��������ʵ���Զ������ˣ����Կռ临�ӵĿ��Լ��ٵ� O(min(m, n))����������
    // �������������������Ͻǵ�ֵ
    // �е�˵���ǹ�������
    // ��ʱ��û��
    public int longestCommonSubsequence02(String text1, String text2) {
        //�ص㿴�Ż�Ϊһά���飬��ʱʹ������������Ϊ�洢���Ͻǵ�Ԫ�أ�
        // ����s1.charAt(i-1)==s2.charAt(j-1)������°�t/pre��ֵ+1����dp[j];
        // ��������s1=��ab��,s2="abac"ʱ��dp�������£�
        //             a       b        a          c
        //       0     0       0        0          0
        //   a   0     1      '1'      '1'(������2)
        //   c
        // ���Ա�'a'��'b'ʱ�����ڲ���ȹ�ȡmax(dp[j],dp[j-1])���������Ա�'a'��'a',������ȣ�
        // ���û���ȴ���dp[1][2]���޸�ǰ��ֵ����ôdp[1][3]�ͻ���dp[1][2]+1=1+1=2,������ʵ�������
        // ���Ҫͨ������������ÿһ��ѭ���в��ϸ������Ͻǵ�ֵ��
        // ����s1.charAt(i-1)==s2.charAt(j-1)ʱ�����Ͻǵ�ֵ(������Ϊpre����)����dp[j];
        int n = text1.length();
        int m = text2.length();
        int[] dp = new int[m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1, pre = dp[0]; j < m + 1; j++) {
                int t = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = pre + 1;
                } else if (text1.charAt(i - 1) != text2.charAt(j - 1)) {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = t;
            }
        }
        return dp[m];
    }
}
