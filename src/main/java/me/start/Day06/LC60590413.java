package me.start.Day06;

/**
 * 413. 等差数列划分
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 */
public class LC60590413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        // dp[i]只表示以nums[i]结尾的等差数组的个数
        int[] dp = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                // 例[1，2，3]有1种，再加上4，那相当于1，2，3，4和2，3，4
            }
        }
        int total = 0;
        for (int count : dp) {
            total += count;
        }
        return total;
    }
}
