package me.start.Day03;

/**
 * 34. �����������в���Ԫ�صĵ�һ�������һ��λ��
 * ����һ�����շǵݼ�˳�����е��������� nums����һ��Ŀ��ֵ target��
 * �����ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
 * ��������в�����Ŀ��ֵ target������ [-1, -1]��
 * �������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨��������⡣
 * ʾ�� 1��
 * ���룺nums = [5,7,7,8,8,10], target = 8
 * �����[3,4]
 */
public class LC30280034 {
    public int[] searchRange(int[] nums, int target) {
        int lIdx = find(nums, target, true);
        // ���ҵ�һ��target
        int rIdx = find(nums, target, false) - 1;
        // ���ҵ�һ������target��������ǰһ�����������һ��target
        if (lIdx <= rIdx && rIdx < nums.length && nums[lIdx] == target && nums[rIdx] == target) {
            return new int[]{lIdx, rIdx};
        }
        return new int[]{-1, -1};
    }

    public int find(int[] nums, int target, boolean lower) {
        int l = 0, r = nums.length - 1, ans = nums.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                // �ж��ǲ��ҵ�һ��target�������һ��target
                // ��һ��ʱ��=targetҲ�������ұ߽磬���һ��ʱ��false������else�����ұ߽�
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
