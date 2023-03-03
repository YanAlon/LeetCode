package me.start.Day04;

/**
 * 200. �������� �������е���ͨ������Ŀ��
 * ����һ���� '1'��½�أ��� '0'��ˮ����ɵĵĶ�ά����
 * ������������е����������
 * �������Ǳ�ˮ��Χ������ÿ������ֻ����ˮƽ�����/����ֱ���������ڵ�½�������γɡ�
 * ���⣬����Լ��������������߾���ˮ��Χ��
 * ʾ�� 1��
 * ���룺grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * �����1
 */
public class LC40350200 {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //����һ����ʾ��������
        int sum = 0;
        //������forѭ�������������Ŷ�ά���ϵ�����½�صġ�
        //i ��ʾ�У�j��ʾ��
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //½�صĸ�
                if (grid[i][j] == '1') {
                    sum++;
                    //ȡ���������
                    dfs(grid, i, j);
                }
            }
        }
        //��������½�����
        return sum;
    }

    public static void dfs(char[][] grid, int i, int j) {
        //����������߽磨�������ң���ʱ�򣬾�ֱ���˳����ر�Ҫ���ϵ������������ʱ��ҲҪ�˳���
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        //����һ��������ʾ�������������ǰ�������½��
        //��½�ظ�Ϊ���󣬷�ֹ�ظ�½���ظ�������
        grid[i][j] = '0';
        //�����Ϸ�Ԫ�أ�ÿ����һ��½�ؾͼ�һ
        dfs(grid, i + 1, j);
        //�����·�Ԫ��
        dfs(grid, i - 1, j);
        //�����ұ�Ԫ��
        dfs(grid, i, j + 1);
        //�������Ԫ��
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

    // �ٷ����
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
