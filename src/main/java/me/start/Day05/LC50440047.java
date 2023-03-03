package me.start.Day05;

import java.util.*;

/**
 * 47. ȫ���� II
 * ����һ���ɰ����ظ����ֵ����� nums ��������˳�� �������в��ظ���ȫ���С�
 * ʾ�� 1��
 * ���룺nums = [1,1,2]
 * �����
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */
public class LC50440047 {
    // �޸�46����һ���ظ���֤������Ч�ʼ��ͣ����Բ����ã���Ϊ��46�����ϼ�֦
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        // ʹ��һ����̬���鱣�����п��ܵ�ȫ����
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // ����������߽��򶼿��ԣ��������Ǽ�֦��ǰ��
        Arrays.sort(nums);

        // ʹ��һ��boolean������״̬
        boolean[] used = new boolean[len];
        // ʹ�� Deque �� Java �ٷ� Stack ��Ľ���
        Deque<Integer> path = new ArrayDeque<>(len);
        // �����������ȣ���ǰ��ȣ�·����״̬�����
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
//            res.add(path); // ��������ĸ�ֵ�ǵ�ַ���ݣ��������ն���һ�����б�
            // ʵ����pathҲȷʵ���ӽ�ȥ�ˣ�
            // ��������Java�����ԣ��´εݹ��ʱ��ʵ�����������޸����path���Լ���Ӧ��res����
            // ʹ�����һ�εݹ鸴ԭ��ʱ�򣬰�path����Ķ���ȫ�³����ˡ�
            // ���Լ������մ𰸵�ʱ�����newһ���µĶ�������ţ�
//            if (!res.contains(path)) {
//                res.add(new ArrayList<>(path));
//                return;
//            }
            res.add(new ArrayList<>(path));
            return;
        }

        // �ڷ�Ҷ�ӽ�㴦��������ͬ�ķ�֧����һ�����������ǣ�
        // �ڻ�δѡ�����������ѡ��һ��Ԫ����Ϊ��һ��λ�õ�Ԫ�أ�����Ȼ��ͨ��һ��ѭ��ʵ�֡�
        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }
            // ��֦������i > 0 ��Ϊ�˱�֤ nums[i - 1] ������
            // д !used[i - 1] ����Ϊ nums[i - 1] ��������ȱ����Ĺ����иոձ�����ѡ��
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, path, used, res);
            // ע�⣺���������д��뷢�� �����ݡ������ݷ����ڴ� ����� �ص� ǳ���� �Ĺ��̣�
            // ��������ʽ�Ϻ͵ݹ�֮ǰ�ǶԳƵ�
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
