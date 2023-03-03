package me.start.Day05;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. ȫ����
 * ����һ�������ظ����ֵ����� nums �������� ���п��ܵ�ȫ���� ��
 * ����� ������˳�� ���ش𰸡�
 * ʾ�� 1��
 * ���룺nums = [1,2,3]
 * �����[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class LC50430046 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // ʹ��һ����̬���鱣�����п��ܵ�ȫ����
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // ʹ��һ��boolean������״̬
        boolean[] used = new boolean[len];
        // ʹ�ö�̬���鱣��·��
        List<Integer> path = new ArrayList<>();
        // �����������ȣ���ǰ��ȣ�·����״̬�����
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
//            res.add(path); // ��������ĸ�ֵ�ǵ�ַ���ݣ��������ն���һ�����б�
            // ʵ����pathҲȷʵ���ӽ�ȥ�ˣ�
            // ��������Java�����ԣ��´εݹ��ʱ��ʵ�����������޸����path���Լ���Ӧ��res����
            // ʹ�����һ�εݹ鸴ԭ��ʱ�򣬰�path����Ķ���ȫ�³����ˡ�
            // ���Լ������մ𰸵�ʱ�����newһ���µĶ�������ţ�
            res.add(new ArrayList<>(path));
            return;
        }

        // �ڷ�Ҷ�ӽ�㴦��������ͬ�ķ�֧����һ�����������ǣ�
        // �ڻ�δѡ�����������ѡ��һ��Ԫ����Ϊ��һ��λ�õ�Ԫ�أ�����Ȼ��ͨ��һ��ѭ��ʵ�֡�
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // ע�⣺���������д��뷢�� �����ݡ������ݷ����ڴ� ����� �ص� ǳ���� �Ĺ��̣�
                // ��������ʽ�Ϻ͵ݹ�֮ǰ�ǶԳƵ�
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
