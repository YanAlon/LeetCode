package me.start.Day03;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
 * 请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class LC30280034 {
    public int[] searchRange(int[] nums, int target) {
        int lIdx = find(nums, target, true);
        // 查找第一个target
        int rIdx = find(nums, target, false) - 1;
        // 查找第一个大于target的数，则前一个数就是最后一个target
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
                // 判断是查找第一个target还是最后一个target
                // 第一个时，=target也是收缩右边界，最后一个时则false，进入else收缩右边界
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
