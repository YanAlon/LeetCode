package me.start.Day06;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，
 * 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例 1：
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 */
public class LC60560064 {
    // 1.尝试直接使用grid，不new了
    public int minPathSum(int[][] grid) {
        int count = sum(grid);
        return count;
    }

    public int sum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0 && i == 0) {
                    grid[i][j] = 0 + grid[i][j]; // 0,0
                    System.out.println("i:" + i + ", j: " + j);
                    System.out.println(grid[i][j]);
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                    System.out.println("i:" + i + ", 0j: " + j);
                    System.out.println(grid[i][j]);
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                    System.out.println("0i:" + i + ", j: " + j);
                    System.out.println(grid[i][j]);
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j] + grid[i][j], grid[i][j - 1] + grid[i][j]);
                    System.out.println("i:" + i + ", j: " + j);
                    System.out.println(grid[i][j]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    // 2.改用new一个存储最小值
    public int minPathSum02(int[][] grid) {
        // 尝试直接使用grid，不new了
        int count = sum02(grid);
        return count;
    }

    public int sum02(int[][] grid) {
        // 只需要列数空间就行，动态规划下一行时直接覆盖掉上一行的值就可以了
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                    System.out.println("i:" + i + ", 0j: " + j);
                    System.out.println(dp[j]);
                } else if (i == 0) {
                    dp[j] = dp[j - 1] + grid[i][j];
                    System.out.println("0i:" + i + ", j: " + j);
                    System.out.println(dp[j]);
                } else {
                    dp[j] = Math.min(dp[j] + grid[i][j], dp[j - 1] + grid[i][j]);
                    System.out.println("i:" + i + ", j: " + j);
                    System.out.println(dp[j]);
                }
            }
        }
        return dp[grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        LC60560064 solution = new LC60560064();
//        int res = solution.minPathSum(input);
        int res = solution.minPathSum02(input);
        System.out.println(res);
    }
}
