package me.start.Day06;

/**
 * 303. ����ͼ��� - ���鲻�ɱ�
 * ����һ����������  nums�������������͵Ķ����ѯ:
 * �������� left �� right ������ left �� right��֮��� nums Ԫ�ص� �� ������ left <= right��
 * ʵ�� NumArray �ࣺ
 * NumArray(int[] nums) ʹ������ nums ��ʼ������
 * int sumRange(int i, int j) �������� nums ������ left �� right ֮���Ԫ�ص� �ܺ� ��
 * ���� left �� right ���㣨Ҳ���� nums[left] + nums[left + 1] + ... + nums[right]��
 * ʾ�� 1��
 * ���룺
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * �����
 * [null, 1, -1, -3]
 * ���ͣ�
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 */
public class LC60580303 {
    private int[] sums;

    public LC60580303(int[] nums) { // ���캯��
        // +1����Ϊleft����Ҫ�������ڣ������+1����leftΪ0ʱ��
        // ��û�취ȡ��sums[left - 1]�����ԾͲ������������һλ��������
        // ������sums[nums.length]��Ӧ����ʵ�͸պ���nums[nums.length - 1]����ֵ
        sums = new int[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left]; // ��Ϊǰ���ԭ����������Ҫ+1
    }
}
