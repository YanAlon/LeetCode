package me.start.Day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。
 * “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * 这个岛被分割成一个由若干方形单元格组成的网格。
 * 给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，
 * 雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 * 返回网格坐标 result 的 2D 列表，
 * 其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。
 * 示例 1：
 * 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 */
public class LC40380417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] ao = new int[m][n];//太平洋的节点记录矩阵
        int[][] pa = new int[m][n];//大西洋的节点记录矩阵
        //1. 从上下边界开始两大洋的回流搜索，变动的是列
        for (int i = 0; i < n; i++) {
            dfs(heights, pa, 0, i);
            dfs(heights, ao, m - 1, i);
        }
        //2. 从左右边界开始两大洋的回流搜索，变动的是行
        for (int i = 0; i < m; i++) {
            dfs(heights, pa, i, 0);
            dfs(heights, ao, i, n - 1);
        }
        //3. 输出交叠的坐标
        List<List<Integer>> cnt = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ao[i][j] == 1 && pa[i][j] == 1) {
                    cnt.add(Arrays.asList(i, j));
                }
            }
        }
        return cnt;
    }

    public static void dfs(int[][] heights, int[][] tmp, int cur_i, int cur_j) {
        //标记可以从海洋流回经过的节点
        tmp[cur_i][cur_j] = 1;
        //开始深度优先搜索当前坐标的4个方向
        //1. 设置更新的坐标
        int[] di = new int[]{1, -1, 0, 0};//上下移动
        int[] dj = new int[]{0, 0, 1, -1};//左右移动
        int new_i = 0;
        int new_j = 0;
        //2. 更新坐标并递归搜索
        for (int index = 0; index < 4; index++) {
            new_i = cur_i + di[index];
            new_j = cur_j + dj[index];
            //判断下标是否越界
            if (new_i < 0 || new_j < 0 || new_i >= heights.length || new_j >= heights[0].length) {
                continue;
            }
            if (heights[cur_i][cur_j] <= heights[new_i][new_j] && tmp[new_i][new_j] != 1) {
                dfs(heights, tmp, new_i, new_j);
            }
        }
    }
}
