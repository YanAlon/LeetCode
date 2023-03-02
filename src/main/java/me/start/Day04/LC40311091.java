package me.start.Day04;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 1091. �����ƾ����е����·��
 * ����һ�� n x n �Ķ����ƾ��� grid �У����ؾ�������� ��ͨ·�� �ĳ��ȡ�
 * ���������������·�������� -1 ��
 * �����ƾ����е� ��ͨ·�� ��һ��
 * �� ���Ͻ� ��Ԫ�񣨼���(0, 0)����
 * ���½� ��Ԫ�񣨼���(n - 1, n - 1)����·������·��ͬʱ��������Ҫ��
 * ·��;�������е�Ԫ�񶼵�ֵ���� 0 ��
 * ·�����������ڵĵ�Ԫ��Ӧ���� 8 ������֮һ ����ͨ
 * ��������������Ԫ֮��˴˲�ͬ�ҹ���һ���߻���һ���ǣ���
 * ��ͨ·���ĳ��� �Ǹ�·��;���ĵ�Ԫ��������
 * ʾ�� 1��
 * ���룺grid = [[0,1],[1,0]]
 * �����2
 */
public class LC40311091 {
    // ʹ�ýṹ���ʾ״̬
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
    // ��ʾ8�����򣬲����һ�û������
    // �����ˣ�������������ϵ��
    static int[] dx = {0, 0, -1, 1,-1, 1,-1, 1};
    static int[] dy = {-1, 1, 0, 0, -1,-1, 1, 1};

    public static int shortestPathBinaryMatrix(int[][] grid) {
        // step�ǵ�Ԫ����������Ϊʲô��2��ʼ
        // �����ˣ�1������ʼ��Ԫ��1��������ҵ��յ�û��+1��ֱ��return
        Node node = new Node(0, 0, 2);
        Deque<Node> queue = new ArrayDeque<>(); // ˫�˶���
        queue.addLast(node);

        int n =grid.length;
        // ���ϽǺ����½�Ϊ0����-1
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        } else if (n <= 2) {
            return n;
        }
        while (!queue.isEmpty()) {
            Node cur = queue.removeFirst(); // ���׳���
            int x = cur.x;
            int y = cur.y;
            int step = cur.step;
            // ������ǰ����8������
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (0 <= newX && newX < n && 0 <= newY && newY < n && grid[newX][newY] == 0) {
                    if (newX == n - 1 && newY == n - 1) {// �ҵ��յ�
                        return step;
                    }
                    queue.addLast(new Node(newX, newY, step + 1));
                    grid[newX][newY] = 1; // ����ѱ������������ظ�
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






