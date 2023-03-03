package me.start.Day04;

/**
 * 200. 岛屿数量 （矩阵中的连通分量数目）
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，
 * 请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1：
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 */
public class LC40350200 {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //定义一个表示岛屿的面积
        int sum = 0;
        //这两个for循环是来遍历整张二维格上的所有陆地的。
        //i 表示行，j表示列
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //陆地的格
                if (grid[i][j] == '1') {
                    sum++;
                    //取出最大的面积
                    dfs(grid, i, j);
                }
            }
        }
        //返回最大的陆地面积
        return sum;
    }

    public static void dfs(char[][] grid, int i, int j) {
        //当超出岛屿边界（上下左右）的时候，就直接退出，特别要加上当遍历到海洋的时候也要退出，
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        //定义一个变量表示岛屿的面积，就是包含几个陆地
        //将陆地改为海洋，防止重复陆地重复遍历。
        grid[i][j] = '0';
        //遍历上方元素，每遍历一次陆地就加一
        dfs(grid, i + 1, j);
        //遍历下方元素
        dfs(grid, i - 1, j);
        //遍历右边元素
        dfs(grid, i, j + 1);
        //遍历左边元素
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int b = numIslands(grid);
        System.out.println(b);
    }

    // 官方解答
    void dfs02(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands02(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
}
