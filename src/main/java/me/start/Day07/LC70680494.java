package me.start.Day07;

import java.util.Arrays;

/**
 * 494. Ŀ���
 * ����һ���������� nums ��һ������ target ��
 * �������е�ÿ������ǰ��� '+' �� '-' ��Ȼ�������������������Թ���һ�� ���ʽ ��
 * ���磬nums = [2, 1] �������� 2 ֮ǰ��� '+' ���� 1 ֮ǰ��� '-' ��
 * Ȼ���������õ����ʽ "+2-1" ��
 * ���ؿ���ͨ��������������ġ����������� target �Ĳ�ͬ ���ʽ ����Ŀ��
 * ʾ�� 1��
 * ���룺nums = [1,1,1,1,1], target = 3
 * �����5
 * ���ͣ�һ���� 5 �ַ���������Ŀ���Ϊ 3 ��
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 */
public class LC70680494 {
    public int findTargetSumWays(int[] nums, int target) {
        if (target < 0) {
            target = -target;
        }
        int sum = Sum(nums);
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        int W = (sum + target) / 2;
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
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

    public static void main(String[] args) {
        int[] nums = new int[]{100};
        int target = -200;
        LC70680494 solution = new LC70680494();
        int res = solution.findTargetSumWays(nums, target);
        System.out.println(res);
    }
}
