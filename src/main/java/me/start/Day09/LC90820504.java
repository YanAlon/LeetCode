package me.start.Day09;

/**
 * 504. �߽�����
 * ����һ������ num������ת��Ϊ 7 ���ƣ������ַ�����ʽ�����
 * ʾ�� 1:
 * ����: num = 100
 * ���: "202"
 */
public class LC90820504 {
    public String convertToBase7(int num) {
        // ���num�Ǹ���������Ҫ����Ϊ����
        boolean isNegative = num < 0; // �ȱ��
        if (isNegative) { // ����Ǹ���
            num = -num;   // ��ת��Ϊ����
        }
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            sb.append(num);
        }
        // �����Ϊdo-while������Ա���0�����
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        // %�õ��Ľ���ǴӸ�λ��ʼ�ģ������Ƿ���
        String res =sb.reverse().toString();
        // ����Ǹ������򽫷��żӻ�ȥ
        return isNegative ? "-" + res : res;
    }
}
