package me.start.Day09;

import java.util.Arrays;

/**
 * 204. ��������
 * �������� n ������ ����С�ڷǸ����� n ������������ ��
 * ʾ�� 1��
 * ���룺n = 10
 * �����
 * ���ͣ�С�� 10 ������һ���� 4 ��, ������ 2, 3, 5, 7 ��
 */
public class LC90810204_9 {
    // ���������ñ��ر�Bitmap���㷨��ɸ�������ڴ��Ż�����δʵ��
    public int countPrimes(int n) {
        // ���ñ�������Ƿ�Ϊ����
        boolean[] isPrime = new boolean[n];
        // ��������Ԥ���Ϊtrue
        Arrays.fill(isPrime, true);
        // ��ʼ�����жϣ����ն�������ɸ����˼·����
        int count = 0; // ����
        // �����ʹ�����������1��ʼ������0
        // �ж��������дΪi * i < n����������д��count�ļ�������Ҫ��������
        for (int i = 2; i < n; i++) {
            System.out.println("����" + i);
            // ��2��ʼ��1����Ҫ�ж�
            if (isPrime[i]) { // ��Ϊ��2��ʼ������һ��ʼ���Ϊtrue�������
                count += 1; // ͳ������
                System.out.println("����" + i + " , count: " + count);
                // ������������򽫺�������������ı������Ϊ��������
                // Ϊʲô��i * i��ʼ����Ϊƽ��ǰ�ı����Ѿ�����С�����ı��������
                // ��Ȼ������Ҳ���Ըĳ�i + i��ʼ��ֻ�Ǽ�������
                if (i * i >= n) {
                    continue;
                }
                // ����long�Ļ���Խ�磬û�㶮
                for (int j = i; (long) i * j < n; j++) {
                    System.out.println("j����" + j);
                    isPrime[i * j] = false;
                }
            }
        }
        // ����ʣ�µ�����ȫΪ����
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        LC90810204_9 solution = new LC90810204_9();
        int res = solution.countPrimes(n);
        System.out.println(res);
    }
}
