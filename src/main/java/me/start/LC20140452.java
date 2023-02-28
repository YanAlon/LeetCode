package me.start;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. �����������ļ���������
 * ��һЩ������������һ���� XY ƽ���ʾ��ǽ���ϡ�
 * ǽ���ϵ������¼����������points��
 * ����points[i] = [xstart, xend]��ʾˮƽֱ����xstart��xend֮�������
 * �㲻֪�������ȷ�� y ���ꡣ
 * һ֧������������ x ��Ӳ�ͬ�� ��ȫ��ֱ �������
 * ������ x �����һ֧��������һ�������ֱ���Ŀ�ʼ�ͽ�������Ϊ xstart��xend��
 * ������ xstart �� x �� xend���������ᱻ ��������������Ĺ��������� û������ ��
 * ����һ�������֮�󣬿������޵�ǰ����
 * ����һ������ points ����������������������������� ��С ��������
 * ʾ�� 1��
 * ���룺points = [[10,16],[2,8],[1,6],[7,12]]
 * �����2
 * ���ͣ����������2֧��������:
 * -��x = 6�����������������[2,8]��[1,6]��
 * -��x = 11�����������������[10,16]��[7,12]��
 */
public class LC20140452 {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
//        ʹ��lambda���ʽ�ᴴ��Comparator�����㷨����ʱ�����
//        ���ע������ʱ�䣬�����޸�Ϊ��ͨ����Comparator���
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
                // ʵ�� compare() ����ʱ����ʹ�� return o1[1] - o2[1]; ���ּ�����������ֹ���
            }
        });
//        System.out.println("points����ֵ��");
//        for(int i=0; i<4; ++i) {
//            for(int j=0; j<2; ++j)
//                System.out.print(points[i][j]);
//            System.out.print("\n");//��ʾ������ı�����ʽ
//        }
        int count = 1; // ������
        int end = points[0][1]; // ѡ���һ������������
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
                // �ӵڶ������俪ʼ������������������С����ô�ͼ������ݲ������������
            }
            end = points[i][1];
            // ��û��continue��˵��������䲻�ص��ˣ��������ӦΪ��������������
            count++;
            // ����+1�� ׼�������һ�飬��Ϊ������Խ��е��⣬֤�����滹������
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int count = findMinArrowShots(points);
        System.out.println(count);
    }
}
