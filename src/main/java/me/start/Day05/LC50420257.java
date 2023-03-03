package me.start.Day05;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给你一个二叉树 root ，按 任意顺序 ，
 * 返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * 示例 1：
 *      1
 *    /   \
 *   2      3
 *    \
 *     5
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 */
public class LC50420257 {
    // 定义一个树
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>(); // 保存结果
        dfs(root, "", res); // 潇洒，不需要返回path，所以直接不定义了？
        return res;
    }

    private void dfs(TreeNode root, String path, List<String> res) {
        // 如果为空，直接返回
        if (root == null)
            return;
        // 如果是叶子节点，说明找到了一条路径，把它加入到res中
        // 左子树和右子树都null，说明是叶子结点
        if (root.left == null && root.right == null) {
            // 此处的root.val为当前子树的根结点，并不一定是总根结点
            res.add(path + root.val); // 简洁！
            return;
        }
        //如果不是叶子节点，在分别遍历他的左右子节点
        dfs(root.left, path + root.val + "->", res);
        dfs(root.right, path + root.val + "->", res);
    }
}
