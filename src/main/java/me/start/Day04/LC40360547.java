package me.start.Day04;

/**
 * 547. ʡ������ (���ѹ�ϵ����ͨ������Ŀ)
 * �� n �����У�����һЩ�˴���������һЩû��������
 * ������� a ����� b ֱ���������ҳ��� b ����� c ֱ��������
 * ��ô���� a ����� c ���������
 * ʡ�� ��һ��ֱ�ӻ��������ĳ��У����ڲ�������û�������ĳ��С�
 * ����һ�� n x n �ľ��� isConnected ��
 * ���� isConnected[i][j] = 1 ��ʾ�� i �����к͵� j ������ֱ��������
 * �� isConnected[i][j] = 0 ��ʾ���߲�ֱ��������
 * ���ؾ����� ʡ�� ��������
 * ʾ�� 1��
 * ���룺isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * �����2
 */
public class LC40360547 {
//    public static int findCircleNum(int[][] isConnected) {
//        if (isConnected == null || isConnected.length <= 1) {
//            return 0;
//        }
//        int sum = 0; // ����ʡ�ݵ�����
//        // ��������ѭ�����������г���
//        for (int i = 0; i < isConnected.length; i++) {
//            for (int j = 0; j < isConnected.length; j++) {
////                if (i == j) continue; // ��������Ҳ��ʡ��
//                if (isConnected[i][j] == 1) {
//                    sum++; // ֻҪ��1�ͱ�ʾ���м��������Ǿ���ζ����ʡ��
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
//        //�����м�������Ϊ����������ֹ�ظ������ظ�������
//        isConnected[i][j] = 0;
//        //������������
//        dfs(isConnected, i + 1, j);
//    }
//
//    public static void main(String[] args) {
//        int[][] grid = new int[][]{
//                {1, 1, 0},{1, 1, 0},{0, 0, 1}};
//        int b = findCircleNum(grid);
//        System.out.println(b);
//    }

    // �ٷ����
    public int findCircleNum02(int[][] isConnected) {
        // int[][] isConnected ������ͼ���ڽӾ���n Ϊ����ͼ�Ķ�������
        int n = isConnected.length;
        // ���� boolean �����ʶ�����Ƿ񱻷���
        boolean[] visited = new boolean[n];
        // ���� cnt ���ۼƱ���������ͨ�������
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            // ����ǰ���� i δ�����ʣ�˵������һ���µ���ͨ��������µ���ͨ����cnt+=1.
            if (!visited[i]) {
                cnt++;
                dfs(i, isConnected, visited);
            }
        }
        return cnt;
    }

    private void dfs(int i, int[][] isConnected, boolean[] visited) {
        // �Ե�ǰ���� i ���з��ʱ��
        visited[i] = true;

        // ���������붥�� i ���ڵĶ��㣨ʹ�� visited �����ֹ�ظ����ʣ�
        for (int j = 0; j < isConnected.length; j++) {
            // Ϊʲôû�����õ�i==jʱ��������// ��������Ҳ��ʡ��
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited);
            }
        }
    }
}
