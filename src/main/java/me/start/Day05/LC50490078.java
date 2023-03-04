package me.start.Day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。
 * 返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class LC50490078 {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        // 使用动态数组保存路径
        List<Integer> path = new ArrayList<>();
        int sum = len;
        // 输入数，长度，当前深度，路径，状态，结果
        backtrack(nums,0, path, res);
        res.add(new ArrayList<>());
        return res;
    }

    public static void backtrack(int[] nums, int i, List<Integer> path, List<List<Integer>> res) {
        for (int j = i; j < nums.length; j++) {
            // 剪枝
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            path.add(nums[j]);
            res.add(new ArrayList<Integer>(path));
            backtrack(nums, j + 1, path, res);
            path.remove(path.size() - 1);
            // 或者再用一个递归替换掉for循环, 下面重写了一个函数，可以参考
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
