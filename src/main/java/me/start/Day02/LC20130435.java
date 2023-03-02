package me.start.Day02;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. ���ص�����
 * ����һ������ļ���intervals������ intervals[i] = [starti, endi]��
 * ���� ��Ҫ�Ƴ��������С������ʹʣ�����以���ص���
 * ʾ�� 1:
 * ����: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * ���: 1
 * ����: �Ƴ� [1,3] ��ʣ�µ�����û���ص���
 */
public class LC20130435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
//        ʹ��lambda���ʽ�ᴴ��Comparator�����㷨����ʱ�����
//        ���ע������ʱ�䣬�����޸�Ϊ��ͨ����Comparator���
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
                // ʵ�� compare() ����ʱ����ʹ�� return o1[1] - o2[1]; ���ּ�����������ֹ���
            }
        });
        int count = 1; // ��������
        int end = intervals[0][1]; // ѡ���һ������������
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue; // �ӵڶ������俪ʼ������������������С����ô�������Ͳ���������
            }
            end = intervals[i][1]; // ��û��continue��˵��������䱻���ɣ��������ӦΪ��������������
            count++; // ��������+1
        }
        return intervals.length - count; // �ܵ� - �����ɵ� = ʣ�µ�
    }
}
