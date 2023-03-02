package me.start.Day03;

/**
 * 540. ���������еĵ�һԪ��
 * ����һ������������ɵ��������飬
 * ����ÿ��Ԫ�ض���������Σ�Ψ��һ����ֻ�����һ�Ρ�
 * �����ҳ�������ֻ����һ�ε��Ǹ�����
 * ����ƵĽ�������������� O(log n) ʱ�临�ӶȺ� O(1) �ռ临�Ӷȡ�
 * ʾ�� 1
 * ����: nums = [1,1,2,3,3,4,4,8,8]
 * ���: 2
 */
public class LC30250540 {
    // ����ʱ������
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (mid % 2 == 1) { // ���������ﳬʱ
                mid--; // ���ǳɶԳ��ֵģ���֤midʼ��Ϊż����������λ��Ϊ����λ
                     // ��ˣ���ʱ��mid���������ֻҪ��ȣ������target�ں��棬����֮��
            }
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }
        return nums[l]; // lÿ��+2����һ����ȵ�����r�ĺ���Ҳȫ����ȷ��
                        // �������һ��lͣ��λ��>=r����target����
    }

    public int singleNonDuplicate02(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == nums[mid ^ 1]) { // �������
                low = mid + 1; // low��Զ�ڳɶ����ĺ�һ��
            } else {
                high = mid; //
            }
        }
        return nums[low];
    }
}
