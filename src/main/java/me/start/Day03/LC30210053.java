package me.start.Day03;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，
 * 请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class LC30210053 {
    // 从第一个正数开始，当和为负数，重新开始计算
    // 动态规划
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        // dp[i]表示以i结尾的最大和
        dp[0] = nums[0];
        // max表示所有子数组的最大和
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
