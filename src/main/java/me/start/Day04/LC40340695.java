package me.start.Day04;

/**
 * 695. 岛屿的最大面积 （查找最大的连通面积）
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，
 * 这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * 示例 1：
 * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 */
public class LC40340695 {
    public int maxAreaOfIsland(int[][] grid) {
        //定义一个表示岛屿的面积
        int max = 0;
        //这两个for循环是来遍历整张二维格上的所有陆地的。
        //i 表示行，j表示列
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //陆地的格
                if (grid[i][j] == 1) {
                    //取出最大的面积
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        //返回最大的陆地面积
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        //当超出岛屿边界（上下左右）的时候，就直接退出，特别要加上当遍历到海洋的时候也要退出，
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return 0;
        //定义一个变量表示岛屿的面积，就是包含几个陆地
        int sum = 1; // 这个函数是找到陆地才进来递归的，所以1表示第一块陆地
        //将陆地改为海洋，防止重复陆地重复遍历。
        grid[i][j] = 0;
        //遍历上方元素，每遍历一次陆地就加一
        sum += dfs(grid, i + 1, j);
        //遍历下方元素
        sum += dfs(grid, i - 1, j);
        //遍历右边元素
        sum += dfs(grid, i, j + 1);
        //遍历左边元素
        sum += dfs(grid, i, j - 1);
        return sum;
    }
}
