package me.start.Day05;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. ������������·��
 * ����һ�������� root ���� ����˳�� ��
 * �������дӸ��ڵ㵽Ҷ�ӽڵ��·����
 * Ҷ�ӽڵ� ��ָû���ӽڵ�Ľڵ㡣
 * ʾ�� 1��
 *      1
 *    /   \
 *   2      3
 *    \
 *     5
 * ���룺root = [1,2,3,null,5]
 * �����["1->2->5","1->3"]
 */
public class LC50420257 {
    // ����һ����
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
        List<String> res = new ArrayList<>(); // ������
        dfs(root, "", res); // ����������Ҫ����path������ֱ�Ӳ������ˣ�
        return res;
    }

    private void dfs(TreeNode root, String path, List<String> res) {
        // ���Ϊ�գ�ֱ�ӷ���
        if (root == null)
            return;
        // �����Ҷ�ӽڵ㣬˵���ҵ���һ��·�����������뵽res��
        // ����������������null��˵����Ҷ�ӽ��
        if (root.left == null && root.right == null) {
            // �˴���root.valΪ��ǰ�����ĸ���㣬����һ�����ܸ����
            res.add(path + root.val); // ��࣡
            return;
        }
        //�������Ҷ�ӽڵ㣬�ڷֱ�������������ӽڵ�
        dfs(root.left, path + root.val + "->", res);
        dfs(root.right, path + root.val + "->", res);
    }
}
