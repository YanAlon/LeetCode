package me.start.Day06;

/**
 * 413. �Ȳ����л���
 * ���һ������ ����������Ԫ�� ������������������Ԫ��֮����ͬ����Ƹ�����Ϊ�Ȳ����С�
 * ���磬[1,3,5,7,9]��[7,7,7,7] �� [3,-1,-5,-9] ���ǵȲ����С�
 * ����һ���������� nums ���������� nums ������Ϊ�Ȳ������ ������ ������
 * ������ �������е�һ���������С�
 * ʾ�� 1��
 * ���룺nums = [1,2,3,4]
 * �����3
 * ���ͣ�nums ���������ӵȲ����飺[1, 2, 3]��[2, 3, 4] �� [1,2,3,4] ����
 */
public class LC60590413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        // dp[i]ֻ��ʾ��nums[i]��β�ĵȲ�����ĸ���
        int[] dp = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                // ��[1��2��3]��1�֣��ټ���4�����൱��1��2��3��4��2��3��4
            }
        }
        int total = 0;
        for (int count : dp) {
            total += count;
        }
        return total;
    }
}
