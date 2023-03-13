package me.start.Day06;

/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），
 *      然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 */
public class LC60550213 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        // 将环形[1, n]变成两个单列[1, n),(1,n]
        return Math.max(splitRob(nums, 0), splitRob(nums, 1));
    }

    public int splitRob(int[] nums, int start) {
        int p = 0;  // n-1，计算时变为原来的当前，也就是n
        int cur = nums[start]; // n，计算时变为下一个n+1
        int t = 0; // 暂存变量，防止覆盖
        for (int i = start + 1; i < nums.length + (start - 1); i++) {
            // 转移方程：n+1 = max(n, n-1 + nums[i])
            t = p;
            p = cur; // n-1往前一步，变成了原来的当前n，用cur表示
            cur = Math.max(p, t + nums[i]);
            // 这样不可以，因为cur中包含了序号1，所以会出错，因此只能计算两遍
//            cur2 = Math.max(cur, p + nums[i + 1]);
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 2};
        LC60550213 solution = new LC60550213();
        int res = solution.rob(input);
        System.out.println(res);
    }
}
