package me.start.Day08;

/**
 * 377. ����ܺ� ��
 * ����һ���� ��ͬ ������ɵ����� nums ����һ��Ŀ������ target ��
 * ����� nums ���ҳ��������ܺ�Ϊ target ��Ԫ����ϵĸ�����
 * ��Ŀ���ݱ�֤�𰸷��� 32 λ������Χ��
 * ʾ�� 1��
 * ���룺nums = [1,2,3], target = 4
 * �����7
 * ���ͣ�
 * ���п��ܵ����Ϊ��
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * ��ע�⣬˳��ͬ�����б�������ͬ����ϡ�
 */
public class LC80730377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // ʲô��������ҪҲ��һ�ַ���
        // ��˳�����ϣ���fori����foreach������if�ж�
        for (int i = 1; i < target + 1; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
