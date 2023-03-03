package me.start.Day05;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。
 * 你可以 按任意顺序 返回答案。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class LC50430046 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 使用一个boolean数组标记状态
        boolean[] used = new boolean[len];
        // 使用动态数组保存路径
        List<Integer> path = new ArrayList<>();
        // 输入数，长度，当前深度，路径，状态，结果
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
//            res.add(path); // 出错，对象的赋值是地址传递，所以最终都是一个空列表
            // 实际上path也确实被加进去了，
            // 但是由于Java的特性，下次递归的时候，实际上是又在修改这个path，以及相应的res，致
            // 使在最后一次递归复原的时候，把path加入的东西全吐出来了。
            // 所以加入最终答案的时候必须new一个新的对象来存放！
            res.add(new ArrayList<>(path));
            return;
        }

        // 在非叶子结点处，产生不同的分支，这一操作的语义是：
        // 在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，
                // 代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        LC50430046 solution = new LC50430046();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }
}
