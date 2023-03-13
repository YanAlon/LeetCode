package me.start.Day06;

import java.util.*;

/**
 * 51. N �ʺ�
 * ���չ�������Ĺ��򣬻ʺ���Թ�����֮����ͬһ�л�ͬһ�л�ͬһб���ϵ����ӡ�
 * n �ʺ����� �о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 * ����һ������ n ���������в�ͬ�� n �ʺ����� �Ľ��������
 * ÿһ�ֽⷨ����һ����ͬ�� n �ʺ����� �����ӷ��÷������÷����� 'Q' �� '.' �ֱ�����˻ʺ�Ϳ�λ��
 * ʾ�� 1��
 * ���룺n = 4
 * �����[[".Q..","...Q","Q...","..Q."],
 *       ["..Q.","Q...","...Q",".Q.."]]
 * ���ͣ�����ͼ��ʾ��4 �ʺ��������������ͬ�Ľⷨ��
 */
public class LC60530051 {
    public List<List<String>> solveNQueens(int n) {
        // ���ü�¼�ѷ���λ�ã��ֱ����У��У���Խ��ߺ��ҶԽ���
        boolean[] row = new boolean[n], col = new boolean[n],
                diagonal1 = new boolean[n * 2 - 1], diagonal2 = new boolean[n * 2 - 1];
        // ������
        List<List<String>> res = new ArrayList<>();
        // ����һ�ֿ��ܣ�����Ҫ����res��ʹ��char���������
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
        System.out.println("num��:" + num);
        // ��num����n������
        if (num == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : nQueens) {
                list.add(new String(chars));
            }
            res.add(list); // ����һ�ֿ���
            System.out.println("list" + list);
            System.out.println("res: " + res);
            return;
        }
        // j��ʾ�У�����num��ʾ
        for (int j = 0; j < n; j++) {
            // ���ڱ��Ϊtrue������ֻҪ��һ�����ڣ��������1�������
            if (row[num] || col[j] || diagonal1[num + j] || diagonal2[num - j + (n - 1)]) {
                System.out.println("������" + j);
                continue; // ��������ѭ��
            }
            // ���������ڣ���path�д���ʺ�Q
            nQueens[num][j] = 'Q';
            System.out.println("nQueens1[" + num + "]: " + Arrays.toString(nQueens[num]));
            // ͬʱ��ǻʺ�����λ��Ϊtrue
            row[num] = col[j] = diagonal1[num + j] = diagonal2[num - j + (n - 1)] = true;
            // Ȼ������ݹ�Ѱ����һ���ʺ�
            dfs(n, num + 1, row, col, diagonal1, diagonal2, res, nQueens);
            // �ݹ�����󣬻��ݣ�����һ����
            System.out.println("���ݵ���num��" + num);
            row[num] = col[j] = diagonal1[num + j] = diagonal2[num - j + (n - 1)] = false;
            nQueens[num][j] = '.';
            System.out.println("����nQueens[" + num + "]: " + Arrays.toString(nQueens[num]));
        }
    }

    public static void main(String[] args) {
        int n = 4;
        LC60530051 solution = new LC60530051();
        List<List<String>> list = solution.solveNQueens(n);
        System.out.println(list);
    }
}























