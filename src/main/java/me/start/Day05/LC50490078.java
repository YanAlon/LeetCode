package me.start.Day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. �Ӽ�
 * ����һ���������� nums �������е�Ԫ�� ������ͬ ��
 * ���ظ��������п��ܵ��Ӽ����ݼ�����
 * �⼯ ���� �����ظ����Ӽ�������԰� ����˳�� ���ؽ⼯��
 * ʾ�� 1��
 * ���룺nums = [1,2,3]
 * �����[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class LC50490078 {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        // ʹ��һ����̬���鱣�����п��ܵ�ȫ����
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // ����������߽��򶼿��ԣ��������Ǽ�֦��ǰ��
        Arrays.sort(nums);
        // ʹ�ö�̬���鱣��·��
        List<Integer> path = new ArrayList<>();
        int sum = len;
        // �����������ȣ���ǰ��ȣ�·����״̬�����
        backtrack(nums,0, path, res);
        res.add(new ArrayList<>());
        return res;
    }

    public static void backtrack(int[] nums, int i, List<Integer> path, List<List<Integer>> res) {
        for (int j = i; j < nums.length; j++) {
            // ��֦
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            path.add(nums[j]);
            res.add(new ArrayList<Integer>(path));
            backtrack(nums, j + 1, path, res);
            path.remove(path.size() - 1);
            // ��������һ���ݹ��滻��forѭ��, ������д��һ�����������Բο�
        }
    }

    public void process(int[] nums, int i, List<Integer> integers, List<List<Integer>> res) {
        if (i >= nums.length) return;
        integers.add(nums[i]);
        process(nums, i + 1,integers, res);
        res.add(new ArrayList<>(integers));
        integers.remove(integers.size() - 1);
        process(nums, i + 1,integers, res);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        LC50490078 solution = new LC50490078();
        List<List<Integer>> lists = solution.subsets(nums);
        System.out.println(lists);
    }
}
