package me.start.Day07;

import java.util.Arrays;

/**
 * 376. 摆动序列
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。
 * 第一个差（如果存在的话）可能是正数或负数。
 * 仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，
 * 因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，
 * 第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，
 * 剩下的元素保持其原始顺序。
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度。
 * 示例 1：
 * 输入：nums = [1,7,4,9,2,5]
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
 */
public class LC70650376 {
    // 1、暴力动态规划
    // 循环与之前的数比较，i可能是升序位，也可能是降序位
    // 所以用2个位的dp保存，即dp[i][0]和dp[i][1]
    // dp保存的是序列长度
    public int wiggleMaxLength01(int[] nums) {
        int len = nums.length;

        //创建dp数组
        int[][] dp = new int[len][2];   //0表示升序，1表示降序
        //预处理，默认为自身，即为1
        dp[0][0] = 1;
        dp[0][1] = 1;
        int max = 1;
        for (int i=1;i<len;i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = i-1;j>=0;j--) {//比较该节点前所有节点是否可以与该节点组合成一个更大的摆动序列
                if (nums[i] - nums[j] > 0) { // 当升序，就将之前的降序位+1，再比较
                    dp[i][0] = Math.max(1 + dp[j][1],dp[i][0]);
                    max = Math.max(dp[i][0],max); //不停向前遍历，选出最大的值
                }
                if (nums[i] - nums[j] < 0) { // 当降序，就将之前的升序位+1，再比较
                    dp[i][1] = Math.max(1 + dp[j][0],dp[i][1]);
                    max = Math.max(dp[i][1],max);
                }
            }
        }


        return max;
    }

    public int wiggleMaxLength02(int[] nums) {
        int len = nums.length;

        //创建dp数组
        int[][] dp = new int[len][2];   //0表示升序，1表示降序
        //预处理
        dp[0][0] = 1;
        dp[0][1] = 1;
        int max = 1;
        for (int i=1;i<len;i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            if (nums[i] > nums[i-1]) {  //当前节点大于上一个节点
                //如果当前应为升序，那么就应该将升序位在降序基础上+1，
                dp[i][0] = dp[i-1][1] + 1;
                //如果当前应为降序，那么就直接继承上一个的升序位，继而寻找下一个降序位
                dp[i][1] = dp[i-1][1];
            } else if (nums[i] < nums[i-1]) {  //上一个节点大于当前节点
                //如果当前应为升序，那么就直接继承上一个的降序位，继而寻找下一个升序位
                dp[i][0] =  dp[i-1][0];
                //如果当前应为降序,那么就应该将降序位在升序基础上+1，
                dp[i][1] = dp[i-1][0] + 1;
            } else {  //当前节点和上一个节点相同，直接继承上个节点的dp数组
                dp[i][1] = dp[i-1][1];
                dp[i][0] = dp[i-1][0];
            }
        }


        return Math.max(dp[len-1][0],dp[len-1][1]);   //比较dp数组最后位置的降序，升序长度，选择长的返回
    }

    // 3、使用变量赋值代替dp
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
