package me.start.Day03;

import java.util.ArrayList;
import java.util.List;

/*
 * 241. Ϊ������ʽ������ȼ�
 * ����һ�������ֺ��������ɵ��ַ��� expression ��
 * ����ͬ���ȼ�������ֺ�����������㲢�������п�����ϵĽ��������� ������˳�� ���ش𰸡�
 * ���ɵĲ��������������Ӧ���ֵ���� 32 λ������Χ����ͬ��������������� 104 ��
 * ʾ�� 1��
 * ���룺expression = "2-1-1"
 * �����[0,2]
 * ���ͣ�
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 */


public class LC30290241 {
    // 1.�ֽ⣺��������ֳ����������֣��ֱ����
    // 2.�����ʵ��һ���ݹ麯����������ʽ��������ʽ��
    // 3.�ϲ�������������ϲ����������ֵĽ⣬�ó����ս�
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
        int len = expression.length();
        int start = 0;
        for (start = 0; start < len; start++) {
            //�ҵ�һ������������Ƶݹ�
            if(Character.isDigit(expression.charAt(start))) continue;
            else break;
        }

        //û�ҵ������ַ�����û�����������ֱ�ӷ��ض�Ӧ���ֽ��
        if (start == len) list.add(Integer.parseInt(expression));

        for (int i = start; i < len; i++) {
            if (Character.isDigit(expression.charAt(i))) continue;
            char op = expression.charAt(i);
            //1.�ø�������ָ��� ��ߵ��ַ��� �� �ұߵ��ַ���
            //2.��ߵ��ַ����ٵݹ������� ���ֽ����
            List<Integer> left = diffWaysToCompute(expression.substring(0, i));
            //2.�ұߵ��ַ����ٵݹ������� ���ֽ����
            List<Integer> right = diffWaysToCompute(expression.substring(i + 1, len));

            //3.����������������ֽ�������ó����֣����ڵ�ǰ����������� ����ӽ�����list���õ��������ֽ����
            for (int j : left) {
                for (int k : right) {
                    if (op == '+') list.add(j + k);
                    else if (op == '-') list.add(j - k);
                    else if (op == '*') list.add(j * k);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "2-1-1";
        List<Integer> b = diffWaysToCompute(s);
        System.out.println(b);
    }
}
