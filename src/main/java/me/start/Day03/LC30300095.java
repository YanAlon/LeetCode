package me.start.Day03;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * 95. ��ͬ�Ķ��������� II
 * ����һ������ n ���������ɲ����������� n ���ڵ����
 * �ҽڵ�ֵ�� 1 �� n ������ͬ�Ĳ�ͬ ���������� �����԰� ����˳�� ���ش𰸡�
 * ʾ�� 1:
 * ���룺n = 3
 * �����[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 */
public class LC30300095 {
    // ����Ĺؼ������Ǹ������������������� < ���ڵ� < ������
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

        // ö�ٿ��и��ڵ�
        for (int i = start; i <= end; i++) {
            // ������п��е�����������
            List<TreeNode> lTrees = generateTrees(start, i - 1);
            // ������п��е�����������
            List<TreeNode> rTrees = generateTrees(i + 1, end);
            // ��������������ѡ��һ������������������������ѡ��һ����������ƴ�ӵ����ڵ���
            // ��ͬһ�ڵ��£�����������Ԫ����ȷ���ģ����Բ�����ֳ�ͻ
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
