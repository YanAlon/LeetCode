package me.start.Day05;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 示例 1：
 * 输入：board = [["A","B","C","E"],
 *               ["S","F","C","S"],
 *               ["A","D","E","E"]],
 *      word = "ABCCED"
 * 输出：true
 */
public class LC50410079 {
    // 设置坐标方向
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int rows; // 行
    private int cols; // 列
    private int len; // word的长度
    private boolean[][] visited; // 标记已访问
    private char[] charArray; // 将word转换成字符数组
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        rows = board.length; // 行的长度是board的一维数组长度
        if (rows == 0) {
            return false;
        }
        cols = board[0].length; // 列的长度是board的二维数组长度
        visited = new boolean[rows][cols]; // 创建一个同样大小的标记访问数组
        // 给全局变量赋值
        this.len = word.length();
        this.charArray = word.toCharArray();
        this.board = board;
        // 二层循环控制遍历所有元素
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) { // 递归
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int begin) {
        if (begin == len - 1) { // 当匹配word的最后一个字母，就可以判断后直接返回了
            return board[x][y] == charArray[begin];
        }
        if (board[x][y] == charArray[begin]) {
            visited[x][y] = true; // 遍历后标记
            for (int[] direction : DIRECTIONS) {
                // 更新坐标，按照DIRECTIONS中的顺序
                int newX = x + direction[0];
                int newY = y + direction[1];
                // 判断新地址是否越界或者是否已访问
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(newX, newY, begin + 1)) { // 递归
                        return true;
                    }
                }
            }
            visited[x][y] = false; // 回溯，重回到上一个访问节点，遍历是否有合适的坐标
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
