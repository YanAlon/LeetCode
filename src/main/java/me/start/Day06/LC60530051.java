package me.start.Day06;

import java.util.*;

/**
 * 51. N 皇后
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 示例 1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],
 *       ["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 */
public class LC60530051 {
    public List<List<String>> solveNQueens(int n) {
        // 设置记录已放置位置，分别是行，列，左对角线和右对角线
        boolean[] row = new boolean[n], col = new boolean[n],
                diagonal1 = new boolean[n * 2 - 1], diagonal2 = new boolean[n * 2 - 1];
        // 保存结果
        List<List<String>> res = new ArrayList<>();
        // 保存一种可能，最终要存入res，使用char数组更方便
        char[][] nQueens = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        }
        dfs(n, 0, row, col,diagonal1, diagonal2, res, nQueens);
        return res;

    }

    public void dfs(int n, int num, boolean[] row, boolean[] col,
                    boolean[] diagonal1, boolean[] diagonal2,
                    List<List<String>> res, char[][] nQueens) {
        System.out.println("num行:" + num);
        // 当num到达n，结束
        if (num == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : nQueens) {
                list.add(new String(chars));
            }
            res.add(list); // 存入一种可能
            System.out.println("list" + list);
            System.out.println("res: " + res);
            return;
        }
        // j表示列，行由num表示
        for (int j = 0; j < n; j++) {
            // 存在标记为true，所以只要由一个存在，整体就是1，则进入
            if (row[num] || col[j] || diagonal1[num + j] || diagonal2[num - j + (n - 1)]) {
                System.out.println("跳过列" + j);
                continue; // 跳过本次循环
            }
            // 当都不存在，向path中存入皇后Q
            nQueens[num][j] = 'Q';
            System.out.println("nQueens1[" + num + "]: " + Arrays.toString(nQueens[num]));
            // 同时标记皇后所在位置为true
            row[num] = col[j] = diagonal1[num + j] = diagonal2[num - j + (n - 1)] = true;
            // 然后继续递归寻找下一个皇后
            dfs(n, num + 1, row, col, diagonal1, diagonal2, res, nQueens);
            // 递归结束后，回溯，找下一个点
            System.out.println("回溯到行num：" + num);
            row[num] = col[j] = diagonal1[num + j] = diagonal2[num - j + (n - 1)] = false;
            nQueens[num][j] = '.';
            System.out.println("回溯nQueens[" + num + "]: " + Arrays.toString(nQueens[num]));
        }
    }

    public static void main(String[] args) {
        int n = 4;
        LC60530051 solution = new LC60530051();
        List<List<String>> list = solution.solveNQueens(n);
        System.out.println(list);
    }
}























