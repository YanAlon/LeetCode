package me.start.Day06;

/**
 * 198. 打家劫舍 (作为213的前置题）
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class LC60550198 {
    public int rob(int[] nums) {
        int p = 0;  // n-1，计算时变为原来的当前，也就是n
        int l = nums[0]; // n，计算时变为下一个n+1
        int t = 0; // 暂存变量，防止覆盖
        for (int i = 1; i < nums.length; i++) {
            // 转移方程：n+1 = max(n, n-1 + nums[i])
            t = p;
            p = l; // n-1往前一步，变成了原来的当前n，用l表示
            l = Math.max(p, t + nums[i]);
        }
        return l;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 1};
        LC60550198 solution = new LC60550198();
        int res = solution.rob(input);
        System.out.println(res);
    }
}
