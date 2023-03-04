package me.start.Day05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。
 * 该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 */
public class LC50480216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (k < 0 || n < k) {
            return res;
        }
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>();
        // 输入数，长度，当前深度，路径，状态，结果
        dfs(n, k, 1, 0, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, int sum,
                     Deque<Integer> path, List<List<Integer>> res) {
        if (sum > n) {
            return;
        }
        if (path.size() == k && sum == n) {
//            res.add(path); // 出错，对象的赋值是地址传递，所以最终都是一个空列表
            // 实际上path也确实被加进去了，
            // 但是由于Java的特性，下次递归的时候，实际上是又在修改这个path，以及相应的res，致
            // 使在最后一次递归复原的时候，把path加入的东西全吐出来了。
            // 所以加入最终答案的时候必须new一个新的对象来存放！
            res.add(new ArrayList<>(path));
            return;
        }

        // 每次增加的i，如果比需要的还大，则直接剪枝
        // 例如：k=3，那么本次i就不能>6，因为后两次最小也是1+2
        for (int i = begin; i <= 9 && i <= n - sum - (Sum(k - path.size() - 1)); i++) {
            path.addLast(i);
            sum += i;
            dfs(n, k, i + 1, sum, path, res);
            // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，
            // 代码在形式上和递归之前是对称的
            path.removeLast();
            sum -= i;
        }
    }
    public int Sum(int num) {
        int sum = 0;
        for(; num > 0 ; num--){
            sum += num;
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        int n = 45, k = 9;
        LC50480216 solution = new LC50480216();
        List<List<Integer>> lists = solution.combinationSum3(k, n);
        System.out.println(lists);
    }
}
