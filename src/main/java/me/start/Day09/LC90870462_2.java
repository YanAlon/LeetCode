package me.start.Day09;

import java.util.Arrays;

/**
 * 462. ��С��������ʹ����Ԫ����� II
 * ����һ������Ϊ n ���������� nums ������ʹ��������Ԫ�������Ҫ����С��������
 * ��һ�β����У������ʹ�����е�һ��Ԫ�ؼ� 1 ���߼� 1 ��
 * ʾ�� 1��
 * ���룺nums = [1,2,3]
 * �����2
 * ���ͣ�
 * ֻ��Ҫ���β�����ÿ�β���ָ��ʹһ��Ԫ�ؼ� 1 ��� 1����
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class LC90870462_2 {
    // ��ƽ��ֵ��Ȼ������ֵ ��
    // ��Ӧ����ƽ��ֵ����Ӧ���ƶ�����λ��
    public int minMoves200(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += nums[i];
        }
        int ave = Math.round(count / len);
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = res + Math.abs(nums[i] - ave);
        }
        return res;
    }

    // ���ǲ���
    public int minMoves201(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int median = 0;
        if (len == 2) {
            median = (nums[0] + nums[1]) / 2;
        }
        if (len % 2 != 0) {
            median = nums[len / 2];
        } else {
            median = (nums[len / 2] + nums[len / 2 + 1]) / 2;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.abs(nums[i] - median);
        }
        return res;
    }

    public int minMoves2(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int median = nums[len / 2];
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - median);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 8, 6};
        LC90870462_2 solution = new LC90870462_2();
        int res = solution.minMoves2(nums);
        System.out.println(res);
    }
}
