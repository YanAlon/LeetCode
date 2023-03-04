package me.start.Day05;

import com.sun.javaws.jnl.RContentDesc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 90. �Ӽ� II
 * ����һ���������� nums �����п��ܰ����ظ�Ԫ�أ�
 * ���㷵�ظ��������п��ܵ��Ӽ����ݼ�����
 * �⼯ ���� �����ظ����Ӽ������صĽ⼯�У��Ӽ����԰� ����˳�� ���С�
 * ʾ�� 1��
 * ���룺nums = [1,2,2]
 * �����[[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class LC50500090 {
    ArrayList<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result.add(new ArrayList<>(list));
        boolean[] used = new boolean[nums.length];
        com(nums, 0, used);
        return result;
    }

    public void com(int[] nums, int startIndex, boolean[] used) {
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            used[i] = true;
            com(nums, i + 1, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        LC50500090 solution = new LC50500090();
        List<List<Integer>> lists = solution.subsetsWithDup(nums);
        System.out.println(lists);
    }
}
