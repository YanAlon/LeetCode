package me.start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 345.��ת�ַ����е�Ԫ����ĸ
 * ����һ���ַ��� s ������ת�ַ����е�����Ԫ����ĸ�������ؽ���ַ�����
 * Ԫ����ĸ���� 'a'��'e'��'i'��'o'��'u'���ҿ����Դ�Сд������ʽ���ֲ�ֹһ�Ρ�
 * ʾ�� 1��
 * ���룺s = "hello"
 * �����"holle"
 */
public class LC0030345 {
    // ��ȫ��Ԫ���ַ���ӵ����� HashSet ��, ����ʹ��ѭ��
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    );

    public String reverseVowels(String s) {
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()]; // �����µ��ַ����飬�洢���
        while (i <= j) {
            char ci = s.charAt(i); // ��������ȡ�ַ����ж�Ӧ���ַ�
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) { // ���ci����Ԫ��
                result[i++] = ci; // ����ԭ���򲻱䣬ֱ�Ӵ浽result
            } else if (!vowels.contains(cj)) {
                result[j--] = cj; // ����
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}
