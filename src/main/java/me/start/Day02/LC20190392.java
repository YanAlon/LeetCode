package me.start.Day02;

/**
 * 392. �ж�������
 * �����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�
 * �ַ�����һ����������ԭʼ�ַ���ɾ��һЩ��Ҳ���Բ�ɾ����
 * �ַ������ı�ʣ���ַ����λ���γɵ����ַ����������磬"ace"��"abcde"��һ�������У���"aec"���ǣ���
 * ���ף�
 * ����д�������� S������ S1, S2, ... , Sk ���� k >= 10�ڣ�
 * ����Ҫ���μ�������Ƿ�Ϊ T �������С�����������£���������ı���룿
 * ʾ�� 1��
 * ���룺s = "abc", t = "ahbgdc"
 * �����true
 */
public class LC20190392 {
    public static boolean isSubsequence(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        // �е㳶���յľ�Ȼ��������
        if (sc.length == 0) return true;
        int j = 0;
        for (int i = 0; i < tc.length; i++) {
            if (tc[i] == sc[j]) {
                j++;
            }
            if (j == sc.length) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean b = isSubsequence(s, t);
        System.out.println(b);
    }
}
