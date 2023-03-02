package me.start.Day03;

/**
 * 53. ����������
 * ����һ���������� nums ��
 * �����ҳ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 * ������ �������е�һ���������֡�
 * ʾ�� 1��
 * ���룺nums = [-2,1,-3,4,-1,2,1,-5,4]
 * �����6
 * ���ͣ����������� [4,-1,2,1] �ĺ����Ϊ 6 ��
 */
public class LC30210053 {
    // �ӵ�һ��������ʼ������Ϊ���������¿�ʼ����
    // ��̬�滮
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        // dp[i]��ʾ��i��β������
        dp[0] = nums[0];
        // max��ʾ���������������
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
