package me.start.Day09;

import java.util.Arrays;

/**
 * 169. ����Ԫ��
 * ����һ����СΪ n ������ nums ���������еĶ���Ԫ�ء�
 * ����Ԫ����ָ�������г��ִ��� ���� ? n/2 ? ��Ԫ�ء�
 * ����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�
 * ʾ�� 1��
 * ���룺nums = [3,2,3]
 * �����3
 */
public class LC90880169_9 {
    // 1������Ԫ�أ���ô��������м�λ�õ�����һ�����������Ԫ��
    public int majorityElement01(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len / 2];
    }

    // 2��Ħ��ͶƱ�� ��ûϸ��
    public int majorityElement(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i])
                ++count;
            else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }
}
