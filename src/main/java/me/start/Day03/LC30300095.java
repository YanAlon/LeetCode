package me.start.Day03;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成
 * 且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * 示例 1:
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 */
public class LC30300095 {
    // 本题的关键：这是个二叉搜索树，左子树 < 根节点 < 右子树
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

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> lTrees = generateTrees(start, i - 1);
            // 获得所有可行的右子树集合
            List<TreeNode> rTrees = generateTrees(i + 1, end);
            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            // 在同一节点下，左右子树的元素是确定的，所以不会出现冲突
            for (TreeNode l : lTrees) {
                for (TreeNode r : rTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = l;
                    currTree.right = r;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
