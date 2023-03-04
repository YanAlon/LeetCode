package me.start.Day05;

import com.sun.javaws.jnl.RContentDesc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，
 * 请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
