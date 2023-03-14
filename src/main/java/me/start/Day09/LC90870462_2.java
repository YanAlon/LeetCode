package me.start.Day09;

import java.util.Arrays;

/**
 * 462. 最小操作次数使数组元素相等 II
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最小操作数。
 * 在一次操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两次操作（每次操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class LC90870462_2 {
    // 求平均值，然后计算差值 ×
    // 不应该是平均值，而应该移动到中位数
    public int minMoves200(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += nums[i];
        }
        int ave = Math.round(count / len);
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = res + Math.abs(nums[i] - ave);
        }
        return res;
    }

    // 还是不对
    public int minMoves201(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int median = 0;
        if (len == 2) {
            median = (nums[0] + nums[1]) / 2;
        }
        if (len % 2 != 0) {
            median = nums[len / 2];
        } else {
            median = (nums[len / 2] + nums[len / 2 + 1]) / 2;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.abs(nums[i] - median);
        }
        return res;
    }

    public int minMoves2(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int median = nums[len / 2];
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - median);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 8, 6};
        LC90870462_2 solution = new LC90870462_2();
        int res = solution.minMoves2(nums);
        System.out.println(res);
    }
}
