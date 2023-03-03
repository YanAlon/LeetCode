package me.start.Day05;

import java.util.*;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */
public class LC50440047 {
    // 修改46，加一个重复验证，但是效率极低，所以不采用，改为在46基础上剪枝
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        // 使用一个boolean数组标记状态
        boolean[] used = new boolean[len];
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>(len);
        // 输入数，长度，当前深度，路径，状态，结果
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
//            res.add(path); // 出错，对象的赋值是地址传递，所以最终都是一个空列表
            // 实际上path也确实被加进去了，
            // 但是由于Java的特性，下次递归的时候，实际上是又在修改这个path，以及相应的res，致
            // 使在最后一次递归复原的时候，把path加入的东西全吐出来了。
            // 所以加入最终答案的时候必须new一个新的对象来存放！
//            if (!res.contains(path)) {
//                res.add(new ArrayList<>(path));
//                return;
//            }
            res.add(new ArrayList<>(path));
            return;
        }

        // 在非叶子结点处，产生不同的分支，这一操作的语义是：
        // 在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, path, used, res);
            // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，
            // 代码在形式上和递归之前是对称的
            used[i] = false;
//            path.remove(path.size() - 1);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        LC50440047 solution = new LC50440047();
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);
    }
}
