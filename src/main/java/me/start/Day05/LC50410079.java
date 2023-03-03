package me.start.Day05;

/**
 * 79. ��������
 * ����һ�� m x n ��ά�ַ����� board ��һ���ַ������� word ��
 * ��� word �����������У����� true �����򣬷��� false ��
 * ���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ�
 * ���С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��
 * ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�
 * ʾ�� 1��
 * ���룺board = [["A","B","C","E"],
 *               ["S","F","C","S"],
 *               ["A","D","E","E"]],
 *      word = "ABCCED"
 * �����true
 */
public class LC50410079 {
    // �������귽��
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int rows; // ��
    private int cols; // ��
    private int len; // word�ĳ���
    private boolean[][] visited; // ����ѷ���
    private char[] charArray; // ��wordת�����ַ�����
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        rows = board.length; // �еĳ�����board��һά���鳤��
        if (rows == 0) {
            return false;
        }
        cols = board[0].length; // �еĳ�����board�Ķ�ά���鳤��
        visited = new boolean[rows][cols]; // ����һ��ͬ����С�ı�Ƿ�������
        // ��ȫ�ֱ�����ֵ
        this.len = word.length();
        this.charArray = word.toCharArray();
        this.board = board;
        // ����ѭ�����Ʊ�������Ԫ��
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) { // �ݹ�
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int begin) {
        if (begin == len - 1) { // ��ƥ��word�����һ����ĸ���Ϳ����жϺ�ֱ�ӷ�����
            return board[x][y] == charArray[begin];
        }
        if (board[x][y] == charArray[begin]) {
            visited[x][y] = true; // ��������
            for (int[] direction : DIRECTIONS) {
                // �������꣬����DIRECTIONS�е�˳��
                int newX = x + direction[0];
                int newY = y + direction[1];
                // �ж��µ�ַ�Ƿ�Խ������Ƿ��ѷ���
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(newX, newY, begin + 1)) { // �ݹ�
                        return true;
                    }
                }
            }
            visited[x][y] = false; // ���ݣ��ػص���һ�����ʽڵ㣬�����Ƿ��к��ʵ�����
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
