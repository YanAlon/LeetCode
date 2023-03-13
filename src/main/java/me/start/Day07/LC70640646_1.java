package me.start.Day07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 646. �������
 * ����һ���� n ��������ɵ��������� pairs ��
 * ���� pairs[i] = [lefti, righti] �� lefti < righti ��
 * ���ڣ����Ƕ���һ�� ���� ��ϵ�����ҽ��� b < c ʱ������ p2 = [c, d]
 * �ſ��Ը��� p1 = [a, b] ���档������������ʽ������ ������ ��
 * �ҳ��������ܹ��γɵ� ��������ĳ��� ��
 * �㲻��Ҫ�õ����е����ԣ���������κ�˳��ѡ�����е�һЩ���������졣
 * ʾ�� 1��
 * ���룺pairs = [[1,2], [2,3], [3,4]]
 * �����2
 * ���ͣ������������ [1,2] -> [3,4] ��
 */
public class LC70640646_1 {
    // 1����̬�滮
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 2��̰���㷨
    public int findLongestChain02(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);            //Lambda���ʽ,����Comparator�ӿڵ�ʵ�ַ���
        //�����Ѿ����յڶ��е�Ԫ�ش�С�����ź���,
        //�ں����ɼ����Ԫ���У��������ĵ�һ�����Ǻ����еڶ���������Сֵ��
        //ÿ�μ���Ķ��ǵڶ�����Сֵ�ģ����������ʾһ��Ӧ�þͶ�Ϊʲô�����������Ž�ĵ�����

        int cur=Integer.MIN_VALUE,ans=0;
        // int left=pairs[0][0],right=pairs[0][1];

        for(int[] pair:pairs){
            if(cur<pair[0]){
                cur=pair[1];                 //�滻�ڶ��е����ֵ,ʼ������β���Եĵڶ�����ֵ
                ans++;
            }
        }
        return ans;
    }
}
