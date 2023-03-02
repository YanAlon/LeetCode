package me.start.Day02;

/**
 * 665. �ǵݼ�����
 * ����һ������Ϊ n ���������� nums ��
 * �����ж��� ��� �ı� 1 ��Ԫ�ص�����£��������ܷ���һ���ǵݼ����С�
 * ��������������һ���ǵݼ����еģ�
 * ��������������� i (0 <= i <= n-2)�������� nums[i] <= nums[i + 1]��
 * ʾ�� 1:
 * ����: nums = [4,2,3]
 * ���: true
 * ����: �����ͨ���ѵ�һ�� 4 ��� 1 ��ʹ������Ϊһ���ǵݼ����С�
 */
public class LC20200665 {
    // �ƺ�ֻҪ���ֵڶ������޸ĺ��ǰһ������С���������޷�ʵ��
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            cnt++;
            // �ؼ��ǻ�Ҫ���Ǿ����޸��ĸ���
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
