package me.start;

import java.util.List;

/**
 * 524. ͨ��ɾ����ĸƥ�䵽�ֵ��������
 * ����һ���ַ��� s ��һ���ַ������� dictionary ��
 * �ҳ�������dictionary ������ַ�����
 * ���ַ�������ͨ��ɾ�� s �е�ĳЩ�ַ��õ���
 * ����𰸲�ֹһ�������س��������ĸ����С���ַ�����
 * ����𰸲����ڣ��򷵻ؿ��ַ�����
 * ʾ�� 1��
 * ���룺s = "abpcplea", dictionary =
 * ["ale","apple","monkey","plea"]
 * �����"apple"
 */
public class LC0070524 {
    // �������⣺
    // ����ж�dictionary�е��ַ��� t �Ƿ����ͨ��ɾ�� s �е�ĳЩ�ַ��õ���    //
    // ����ҵ���������ֵ�����С���ַ�����
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String t : dictionary) {
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
            if (i == t.length()) {
                if (t.length() > res.length() ||
                        (t.length() == res.length() && t.compareTo(res) < 0)) {
                    // ����ַ���������ȣ���Ƚ�t��res����ţ�ѡ��С��
                    res = t;
                }
            }
        }
        return res;
    }
}
