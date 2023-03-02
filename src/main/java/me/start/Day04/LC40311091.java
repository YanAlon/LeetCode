package me.start.Day04;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 1091. 二进制矩阵中的最短路径
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。
 * 如果不存在这样的路径，返回 -1 。
 * 二进制矩阵中的 畅通路径 是一条
 * 从 左上角 单元格（即，(0, 0)）到
 * 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通
 * （即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 * 示例 1：
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 */
public class LC40311091 {
    // 使用结构体表示状态
    static class Node {
        int x;
        int y;
        int step;

        public  Node(int start, int end, int step) {
            this.x = start;
            this.y = end;
            this.step = step;
        }
    }
    // 表示8个方向，不过我还没搞明白
    // 明白了！！！看成坐标系！
    static int[] dx = {0, 0, -1, 1,-1, 1,-1, 1};
    static int[] dy = {-1, 1, 0, 0, -1,-1, 1, 1};

    public static int shortestPathBinaryMatrix(int[][] grid) {
        // step是单元格总数，但为什么是2开始
        // 明白了，1个是起始单元格，1个是最后找到终点没有+1，直接return
        Node node = new Node(0, 0, 2);
        Deque<Node> queue = new ArrayDeque<>(); // 双端队列
        queue.addLast(node);

        int n =grid.length;
        // 左上角和右下角为0，则-1
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        } else if (n <= 2) {
            return n;
        }
        while (!queue.isEmpty()) {
            Node cur = queue.removeFirst(); // 队首出列
            int x = cur.x;
            int y = cur.y;
            int step = cur.step;
            // 遍历当前结点的8个方向
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (0 <= newX && newX < n && 0 <= newY && newY < n && grid[newX][newY] == 0) {
                    if (newX == n - 1 && newY == n - 1) {// 找到终点
                        return step;
                    }
                    queue.addLast(new Node(newX, newY, step + 1));
                    grid[newX][newY] = 1; // 标记已遍历过，避免重复
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0},{1, 1, 0},{1, 1, 0}};
        int b = shortestPathBinaryMatrix(grid);
        System.out.println(b);
    }
}






