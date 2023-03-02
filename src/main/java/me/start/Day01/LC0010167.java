package me.start.Day01;

/**
 * 167.����֮�� II - ������������
 * ����һ���±�� 1 ��ʼ���������� numbers ���������Ѱ��ǵݼ�˳�����У�
 * ������������ҳ��������֮�͵���Ŀ����target ����������
 * ��������������ֱ��� numbers[index1] �� numbers[index2] ��
 * �� 1 <= index1 < index2 <= numbers.length ��
 * �Գ���Ϊ 2 ���������� [index1, index2] ����ʽ�����������������±� index1 �� index2��
 * ����Լ���ÿ������ ֻ��ӦΨһ�Ĵ� �������� ������ �ظ�ʹ����ͬ��Ԫ�ء�
 * ������ƵĽ����������ֻʹ�ó������Ķ���ռ䡣
 * ʾ�� 1��
 * ���룺numbers = [2,7,11,15], target = 9
 * �����[1,2]
 * ���ͣ�2 �� 7 ֮�͵���Ŀ���� 9 ����� index1 = 1, index2 = 2 ������ [1, 2] ��
 */

class LC1000167 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] < target - numbers[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return new int[]{0, 0};
    }
}


class LC100016702 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] == target - numbers[right]) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] < target - numbers[right]) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{0, 0};
    }
}
