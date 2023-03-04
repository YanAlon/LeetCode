package me.start.Day05;

import java.util.*;

/**
 * 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
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
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(candidates);

        boolean[] used = new boolean[len];

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, used, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private void dfs(int[] candidates, int begin, int len, int target, boolean[] used,
                     Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
//            if (used[i]) {
//                System.out.println("1 : " + i);
//                continue;
//            }
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            used[i] = true;

            // 注意：由于每一个元素不可以重复使用，下一轮搜索的起点将是 i + 1
            dfs(candidates, i + 1, len, target - candidates[i], used, path, res);

            // 状态重置
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
