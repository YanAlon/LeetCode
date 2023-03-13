package me.start.Day07;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */
public class LC70630300 {
    // 1、github 以数字i为暂时结尾，遍历前面的所有数与之进行比较，再遍历i，形成不断递增数字的序列
    public int lengthOfLIS01(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // 1-n作为对比数字循环
        for (int i = 0; i < n; i++) {
            int max = 1;
            // 遍历前面的数字
            for (int j = 0; j < i; j++) {
                // 比j大，则i可以加在后面
                if (nums[j] < nums[i]) {
                    // 计算dp[j]时，已经计算过dp[i]了，所以此时dp[j]其实已经有了值
                    // 但在计算dp[j]时的+1并没有覆盖dp[j]，而是作为一个临时变量与max比较
                    max = Math.max(max, dp[j] + 1);
                    System.out.println(j + " j: " + max);
                }
            }
            dp[i] = max;
            System.out.println(i + " i: " + dp[i]);
        }
        // 将计算完成的所有以i为结尾的dp进行比较，找出max
//        return Arrays.stream(dp).max().orElse(0);
        //上式计算时间过长，可以用一个for循环替换
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 2、修改了最终结果的判定方式
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums  = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        LC70630300 solution = new LC70630300();
        int res1 = solution.lengthOfLIS01(nums);
        int res2 = solution.lengthOfLIS(nums);
        System.out.println(res1);
        System.out.println(res2);
    }
}
