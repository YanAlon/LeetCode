package me.start.Day04;

import java.util.Arrays;

/**
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充.
 * 示例 1：
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，
 * 换句话说，任何边界上的'O'都不会被填充为'X'。
 * 任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class LC40370130 {
    // 从原来的遍历找O，变成遍历找靠边的O的问题，当靠边替换为#；
    // 碰到中间的，因为暂不确定，所以不替换。即便它是靠边的，
    // 我们最终也会再以靠边的点为根再遍历回来。
    // 最终剩下的则会变成3种元素”O“，”X“，”#“
    // 此时再从头遍历遇到#变O，遇到O变X
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        //这两个for循环是来遍历整张二维格上的所有区域
        //i 表示行，j表示列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == n - 1 || j == m - 1)) {
                    //替换所有边界上的'O'为'#'
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //陆地的格
                if (board[i][j] == 'O') {
                    //替换剩余的'O'为'X'
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int i, int j) {
        // 当超出边界（上下左右）的时候，就直接退出，特别要加上当遍历到X和#的时候也要退出。
        // 在DFS时，不需要控制是边界，因为只需要根节点是边界就可以了
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#')
            return;
        //将边界上的O改为#，作为下次遍历的标志，也防止本次重复遍历。
        board[i][j] = '#';
        //遍历上方元素，每遍历一次陆地就加一
        dfs(board, i + 1, j);
        //遍历下方元素
        dfs(board, i - 1, j);
        //遍历右边元素
        dfs(board, i, j + 1);
        //遍历左边元素
        dfs(board, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        solve(board);
    }
}
