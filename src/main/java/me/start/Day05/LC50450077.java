package me.start.Day05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class LC50450077 {
    public List<List<Integer>> combine(int n, int k) {
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (k < 0 || n < k) {
            return res;
        }
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>();
        // 输入数，长度，当前深度，路径，状态，结果
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin,
                     Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
//            res.add(path); // 出错，对象的赋值是地址传递，所以最终都是一个空列表
            // 实际上path也确实被加进去了，
            // 但是由于Java的特性，下次递归的时候，实际上是又在修改这个path，以及相应的res，致
            // 使在最后一次递归复原的时候，把path加入的东西全吐出来了。
            // 所以加入最终答案的时候必须new一个新的对象来存放！
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.addLast(i);

            dfs(n, k, i + 1, path, res);
            // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，
            // 代码在形式上和递归之前是对称的
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        LC50450077 solution = new LC50450077();
        List<List<Integer>> lists = solution.combine(n, k);
        System.out.println(lists);
    }
}
