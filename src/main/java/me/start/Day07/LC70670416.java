package me.start.Day07;

/**
 * 416. �ָ�Ⱥ��Ӽ�
 * ����һ�� ֻ���������� �� �ǿ� ���� nums ��
 * �����ж��Ƿ���Խ��������ָ�������Ӽ���ʹ�������Ӽ���Ԫ�غ���ȡ�
 * ʾ�� 1��
 * ���룺nums = [1,5,11,5]
 * �����true
 * ���ͣ�������Էָ�� [1, 5, 5] �� [11] ��
 */
public class LC70670416 {
    public boolean canPartition(int[] nums) {
        int sum = Sum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i]||dp[i-num];
            }
        }
        return dp[W];
    }

    public int Sum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
