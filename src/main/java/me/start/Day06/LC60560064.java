package me.start.Day06;

/**
 * 64. ��С·����
 * ����һ�������Ǹ������� m x n ���� grid ��
 * ���ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
 * ˵����ÿ��ֻ�����»��������ƶ�һ����
 * ʾ�� 1��
 * ���룺grid = [[1,3,1],[1,5,1],[4,2,1]]
 * �����7
 * ���ͣ���Ϊ·�� 1��3��1��1��1 ���ܺ���С��
 */
public class LC60560064 {
    // 1.����ֱ��ʹ��grid����new��
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

    // 2.����newһ���洢��Сֵ
    public int minPathSum02(int[][] grid) {
        // ����ֱ��ʹ��grid����new��
        int count = sum02(grid);
        return count;
    }

    public int sum02(int[][] grid) {
        // ֻ��Ҫ�����ռ���У���̬�滮��һ��ʱֱ�Ӹ��ǵ���һ�е�ֵ�Ϳ�����
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
