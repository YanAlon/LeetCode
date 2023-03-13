package me.start.Day06;

/**
 * 213. ��ҽ��� II
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݣ�ÿ�䷿�ڶ�����һ�����ֽ�
 * ����ط����еķ��ݶ� Χ��һȦ ������ζ�ŵ�һ�����ݺ����һ�������ǽ����ŵġ�
 * ͬʱ�����ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ����� ��
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬
 * ������ �ڲ���������װ�õ������ �������ܹ�͵�Ե�����߽�
 * ʾ�� 1��
 * ���룺nums = [2,3,2]
 * �����3
 * ���ͣ��㲻����͵�� 1 �ŷ��ݣ���� = 2����
 *      Ȼ��͵�� 3 �ŷ��ݣ���� = 2��, ��Ϊ���������ڵġ�
 */
public class LC60550213 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        // ������[1, n]�����������[1, n),(1,n]
        return Math.max(splitRob(nums, 0), splitRob(nums, 1));
    }

    public int splitRob(int[] nums, int start) {
        int p = 0;  // n-1������ʱ��Ϊԭ���ĵ�ǰ��Ҳ����n
        int cur = nums[start]; // n������ʱ��Ϊ��һ��n+1
        int t = 0; // �ݴ��������ֹ����
        for (int i = start + 1; i < nums.length + (start - 1); i++) {
            // ת�Ʒ��̣�n+1 = max(n, n-1 + nums[i])
            t = p;
            p = cur; // n-1��ǰһ���������ԭ���ĵ�ǰn����cur��ʾ
            cur = Math.max(p, t + nums[i]);
            // ���������ԣ���Ϊcur�а��������1�����Ի�������ֻ�ܼ�������
//            cur2 = Math.max(cur, p + nums[i + 1]);
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 2};
        LC60550213 solution = new LC60550213();
        int res = solution.rob(input);
        System.out.println(res);
    }
}
