package me.start.Day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. ̫ƽ�������ˮ������
 * ��һ�� m �� n �ľ��ε��죬�� ̫ƽ�� �� ������ ���ڡ�
 * ��̫ƽ�� ���ڴ�½����߽���ϱ߽磬�� �������� ���ڴ�½���ұ߽���±߽硣
 * ��������ָ��һ�������ɷ��ε�Ԫ����ɵ�����
 * ����һ�� m x n ���������� heights �� heights[r][c] ��ʾ���� (r, c) �ϵ�Ԫ�� ���ں�ƽ��ĸ߶� ��
 * ������ˮ�϶࣬������ڵ�Ԫ��ĸ߶� С�ڻ���� ��ǰ��Ԫ��ĸ߶ȣ�
 * ��ˮ����ֱ���򱱡��ϡ��������������ڵ�Ԫ��ˮ���ԴӺ��󸽽����κε�Ԫ�����뺣��
 * ������������ result �� 2D �б�
 * ���� result[i] = [ri, ci] ��ʾ��ˮ�ӵ�Ԫ�� (ri, ci) ���� �ȿ�����̫ƽ��Ҳ����������� ��
 * ʾ�� 1��
 * ����: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * ���: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 */
public class LC40380417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] ao = new int[m][n];//̫ƽ��Ľڵ��¼����
        int[][] pa = new int[m][n];//������Ľڵ��¼����
        //1. �����±߽翪ʼ������Ļ����������䶯������
        for (int i = 0; i < n; i++) {
            dfs(heights, pa, 0, i);
            dfs(heights, ao, m - 1, i);
        }
        //2. �����ұ߽翪ʼ������Ļ����������䶯������
        for (int i = 0; i < m; i++) {
            dfs(heights, pa, i, 0);
            dfs(heights, ao, i, n - 1);
        }
        //3. �������������
        List<List<Integer>> cnt = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ao[i][j] == 1 && pa[i][j] == 1) {
                    cnt.add(Arrays.asList(i, j));
                }
            }
        }
        return cnt;
    }

    public static void dfs(int[][] heights, int[][] tmp, int cur_i, int cur_j) {
        //��ǿ��ԴӺ������ؾ����Ľڵ�
        tmp[cur_i][cur_j] = 1;
        //��ʼ�������������ǰ�����4������
        //1. ���ø��µ�����
        int[] di = new int[]{1, -1, 0, 0};//�����ƶ�
        int[] dj = new int[]{0, 0, 1, -1};//�����ƶ�
        int new_i = 0;
        int new_j = 0;
        //2. �������겢�ݹ�����
        for (int index = 0; index < 4; index++) {
            new_i = cur_i + di[index];
            new_j = cur_j + dj[index];
            //�ж��±��Ƿ�Խ��
            if (new_i < 0 || new_j < 0 || new_i >= heights.length || new_j >= heights[0].length) {
                continue;
            }
            if (heights[cur_i][cur_j] <= heights[new_i][new_j] && tmp[new_i][new_j] != 1) {
                dfs(heights, tmp, new_i, new_j);
            }
        }
    }
}
