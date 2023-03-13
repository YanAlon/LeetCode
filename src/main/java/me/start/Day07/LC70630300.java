package me.start.Day07;

import java.util.Arrays;

/**
 * 300. �����������
 * ����һ���������� nums ���ҵ�������ϸ���������еĳ��ȡ�
 * ������ ���������������������У�ɾ������ɾ���������е�Ԫ�ض����ı�����Ԫ�ص�˳��
 * ���磬[3,6,2,7] ������ [0,3,1,6,2,2,7] �������С�
 * ʾ�� 1��
 * ���룺nums = [10,9,2,5,3,7,101,18]
 * �����4
 * ���ͣ�������������� [2,3,7,101]����˳���Ϊ 4 ��
 */
public class LC70630300 {
    // 1��github ������iΪ��ʱ��β������ǰ�����������֮���бȽϣ��ٱ���i���γɲ��ϵ������ֵ�����
    public int lengthOfLIS01(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // 1-n��Ϊ�Ա�����ѭ��
        for (int i = 0; i < n; i++) {
            int max = 1;
            // ����ǰ�������
            for (int j = 0; j < i; j++) {
                // ��j����i���Լ��ں���
                if (nums[j] < nums[i]) {
                    // ����dp[j]ʱ���Ѿ������dp[i]�ˣ����Դ�ʱdp[j]��ʵ�Ѿ�����ֵ
                    // ���ڼ���dp[j]ʱ��+1��û�и���dp[j]��������Ϊһ����ʱ������max�Ƚ�
                    max = Math.max(max, dp[j] + 1);
                    System.out.println(j + " j: " + max);
                }
            }
            dp[i] = max;
            System.out.println(i + " i: " + dp[i]);
        }
        // ��������ɵ�������iΪ��β��dp���бȽϣ��ҳ�max
//        return Arrays.stream(dp).max().orElse(0);
        //��ʽ����ʱ�������������һ��forѭ���滻
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 2���޸������ս�����ж���ʽ
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums  = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        LC70630300 solution = new LC70630300();
        int res1 = solution.lengthOfLIS01(nums);
        int res2 = solution.lengthOfLIS(nums);
        System.out.println(res1);
        System.out.println(res2);
    }
}
