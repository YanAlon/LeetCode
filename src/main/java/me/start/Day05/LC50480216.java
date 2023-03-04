package me.start.Day05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 216. ����ܺ� III
 * �ҳ��������֮��Ϊ n �� k ��������ϣ�����������������
 * ֻʹ������1��9
 * ÿ������ ���ʹ��һ��
 * ���� ���п��ܵ���Ч��ϵ��б� ��
 * ���б��ܰ�����ͬ��������Σ���Ͽ������κ�˳�򷵻ء�
 * ʾ�� 1:
 * ����: k = 3, n = 7
 * ���: [[1,2,4]]
 * ����:
 * 1 + 2 + 4 = 7
 * û���������ϵ�����ˡ�
 */
public class LC50480216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // ʹ��һ����̬���鱣�����п��ܵ�ȫ����
        List<List<Integer>> res = new ArrayList<>();
        if (k < 0 || n < k) {
            return res;
        }
        // ʹ�� Deque �� Java �ٷ� Stack ��Ľ���
        Deque<Integer> path = new ArrayDeque<>();
        // �����������ȣ���ǰ��ȣ�·����״̬�����
        dfs(n, k, 1, 0, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, int sum,
                     Deque<Integer> path, List<List<Integer>> res) {
        if (sum > n) {
            return;
        }
        if (path.size() == k && sum == n) {
//            res.add(path); // ��������ĸ�ֵ�ǵ�ַ���ݣ��������ն���һ�����б�
            // ʵ����pathҲȷʵ���ӽ�ȥ�ˣ�
            // ��������Java�����ԣ��´εݹ��ʱ��ʵ�����������޸����path���Լ���Ӧ��res����
            // ʹ�����һ�εݹ鸴ԭ��ʱ�򣬰�path����Ķ���ȫ�³����ˡ�
            // ���Լ������մ𰸵�ʱ�����newһ���µĶ�������ţ�
            res.add(new ArrayList<>(path));
            return;
        }

        // ÿ�����ӵ�i���������Ҫ�Ļ�����ֱ�Ӽ�֦
        // ���磺k=3����ô����i�Ͳ���>6����Ϊ��������СҲ��1+2
        for (int i = begin; i <= 9 && i <= n - sum - (Sum(k - path.size() - 1)); i++) {
            path.addLast(i);
            sum += i;
            dfs(n, k, i + 1, sum, path, res);
            // ע�⣺���������д��뷢�� �����ݡ������ݷ����ڴ� ����� �ص� ǳ���� �Ĺ��̣�
            // ��������ʽ�Ϻ͵ݹ�֮ǰ�ǶԳƵ�
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
