package me.start.Day05;

import java.util.*;

/**
 * 40. ����ܺ� II
 * ����һ����ѡ�˱�ŵļ��� candidates ��һ��Ŀ���� target ��
 * �ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
 * candidates �е�ÿ��������ÿ�������ֻ��ʹ�� һ�� ��
 * ע�⣺�⼯���ܰ����ظ�����ϡ�
 * ʾ�� 1:
 * ����: candidates = [10,1,2,7,6,1,5], target = 8,
 * ���:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class LC50470040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // ����������߽��򶼿��ԣ��������Ǽ�֦��ǰ��
        Arrays.sort(candidates);

        boolean[] used = new boolean[len];

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, used, path, res);
        return res;
    }

    /**
     * @param candidates ��ѡ����
     * @param begin      �������
     * @param len        ����������� candidates ������ԣ����Բ���
     * @param target     ÿ��ȥһ��Ԫ�أ�Ŀ��ֵ��С
     * @param path       �Ӹ���㵽Ҷ�ӽ���·������һ��ջ
     * @param res        ������б�
     */
    private void dfs(int[] candidates, int begin, int len, int target, boolean[] used,
                     Deque<Integer> path, List<List<Integer>> res) {
        // target Ϊ������ 0 ��ʱ���ٲ����µĺ��ӽ��
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // �ص��������� begin ��ʼ����������
        for (int i = begin; i < len; i++) {
//            if (used[i]) {
//                System.out.println("1 : " + i);
//                continue;
//            }
            // ��֦������i > 0 ��Ϊ�˱�֤ nums[i - 1] ������
            // д !used[i - 1] ����Ϊ nums[i - 1] ��������ȱ����Ĺ����иոձ�����ѡ��
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            used[i] = true;

            // ע�⣺����ÿһ��Ԫ�ز������ظ�ʹ�ã���һ����������㽫�� i + 1
            dfs(candidates, i + 1, len, target - candidates[i], used, path, res);

            // ״̬����
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] candidates  = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        LC50470040 solution = new LC50470040();
        List<List<Integer>> lists = solution.combinationSum2(candidates, target);
        System.out.println(lists);
    }
}
