package me.start.Day04;

/**
 * 547. 省份数量 (好友关系的连通分量数目)
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。
 * 如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，
 * 那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，
 * 其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 * 而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 * 示例 1：
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 */
public class LC40360547 {
//    public static int findCircleNum(int[][] isConnected) {
//        if (isConnected == null || isConnected.length <= 1) {
//            return 0;
//        }
//        int sum = 0; // 定义省份的数量
//        // 设置两个循环，遍历所有城市
//        for (int i = 0; i < isConnected.length; i++) {
//            for (int j = 0; j < isConnected.length; j++) {
////                if (i == j) continue; // 单个城市也叫省份
//                if (isConnected[i][j] == 1) {
//                    sum++; // 只要有1就表示城市间相连，那就意味着是省份
//                    dfs(isConnected, j);
//                }
//            }
//        }
//        return sum;
//    }
//
//    public static void dfs(int[][] isConnected, int j) {
//        if (j < 0 ||j >= isConnected[0].length)
//            return;
//        //将城市间相连改为不相连，防止重复城市重复遍历。
//        isConnected[i][j] = 0;
//        //遍历相连城市
//        dfs(isConnected, i + 1, j);
//    }
//
//    public static void main(String[] args) {
//        int[][] grid = new int[][]{
//                {1, 1, 0},{1, 1, 0},{0, 0, 1}};
//        int b = findCircleNum(grid);
//        System.out.println(b);
//    }

    // 官方解答
    public int findCircleNum02(int[][] isConnected) {
        // int[][] isConnected 是无向图的邻接矩阵，n 为无向图的顶点数量
        int n = isConnected.length;
        // 定义 boolean 数组标识顶点是否被访问
        boolean[] visited = new boolean[n];
        // 定义 cnt 来累计遍历过的连通域的数量
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            // 若当前顶点 i 未被访问，说明又是一个新的连通域，则遍历新的连通域且cnt+=1.
            if (!visited[i]) {
                cnt++;
                dfs(i, isConnected, visited);
            }
        }
        return cnt;
    }

    private void dfs(int i, int[][] isConnected, boolean[] visited) {
        // 对当前顶点 i 进行访问标记
        visited[i] = true;

        // 继续遍历与顶点 i 相邻的顶点（使用 visited 数组防止重复访问）
        for (int j = 0; j < isConnected.length; j++) {
            // 为什么没有设置当i==j时，跳过。// 单个城市也叫省份
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited);
            }
        }
    }
}
