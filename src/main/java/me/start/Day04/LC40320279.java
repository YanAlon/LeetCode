package me.start.Day04;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 279. ��ȫƽ����
 * ����һ������ n ������ ��Ϊ n ����ȫƽ��������������
 * ��ȫƽ���� ��һ����������ֵ������һ��������ƽ����
 * ���仰˵����ֵ����һ�������Գ˵Ļ���
 * ���磬1��4��9 �� 16 ������ȫƽ�������� 3 �� 11 ���ǡ�
 * ʾ�� 1��
 * ���룺n = 12
 * �����3
 * ���ͣ�12 = 4 + 4 + 4
 */
public class LC40320279 {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>(); // ����
        HashSet<Integer> visited = new HashSet<>(); // ��ϣ��
        queue.offer(n); // ��ָ��Ԫ�ؼ���ö��е�β������ʱ��add������
        visited.add(n); // ����ѷ���
        int level = 0; // ��ע��ȫƽ��������Ŀ

        // ʲôԭ��
        // �ƺ������ˣ����ǲ�ͣ�Ĵ�1��ʼ���¼�������һ�μ���0�������������̵ģ����������Ҫ��level
        // ����12������ѭ���Ĺ�����12->8->4->0�����м���������Ǳ���̭�İ���
        while (!queue.isEmpty()) {
            level++;
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int cur = queue.poll(); // ��ȡ����ͷ����Ԫ�أ���ɾ����Ԫ��

                for (int j = 1; j * j <= cur; j++) { // ��1��ʼ
                    int tmp = cur - j * j;
                    if (tmp == 0)
                        return level;
                    if (!visited.contains(tmp))
                        queue.offer(tmp);
                    visited.add(tmp);
                }
            }
        }
        return level;
    }
}
