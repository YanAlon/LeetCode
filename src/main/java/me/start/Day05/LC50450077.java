package me.start.Day05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. ���
 * ������������ n �� k�����ط�Χ [1, n] �����п��ܵ� k ��������ϡ�
 * ����԰� �κ�˳�� ���ش𰸡�
 * ʾ�� 1��
 * ���룺n = 4, k = 2
 * �����
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
        // ʹ��һ����̬���鱣�����п��ܵ�ȫ����
        List<List<Integer>> res = new ArrayList<>();
        if (k < 0 || n < k) {
            return res;
        }
        // ʹ�� Deque �� Java �ٷ� Stack ��Ľ���
        Deque<Integer> path = new ArrayDeque<>();
        // �����������ȣ���ǰ��ȣ�·����״̬�����
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin,
                     Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
//            res.add(path); // ��������ĸ�ֵ�ǵ�ַ���ݣ��������ն���һ�����б�
            // ʵ����pathҲȷʵ���ӽ�ȥ�ˣ�
            // ��������Java�����ԣ��´εݹ��ʱ��ʵ�����������޸����path���Լ���Ӧ��res����
            // ʹ�����һ�εݹ鸴ԭ��ʱ�򣬰�path����Ķ���ȫ�³����ˡ�
            // ���Լ������մ𰸵�ʱ�����newһ���µĶ�������ţ�
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.addLast(i);

            dfs(n, k, i + 1, path, res);
            // ע�⣺���������д��뷢�� �����ݡ������ݷ����ڴ� ����� �ص� ǳ���� �Ĺ��̣�
            // ��������ʽ�Ϻ͵ݹ�֮ǰ�ǶԳƵ�
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
