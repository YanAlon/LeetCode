package me.start.Day09;

/**
 * 415. �ַ������
 * ���������ַ�����ʽ�ķǸ����� num1 ��num2 ���������ǵĺͲ�ͬ�����ַ�����ʽ���ء�
 * �㲻��ʹ���κ΃Ƚ������ڴ���������Ŀ⣨���� BigInteger����
 * Ҳ����ֱ�ӽ�������ַ���ת��Ϊ������ʽ��
 * ʾ�� 1��
 * ���룺num1 = "11", num2 = "123"
 * �����"134"
 */
public class LC90860415 {
    // ˫ָ��ģ����ʽ�ӷ�����
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int add = 0; // ���ڽ�λ
        StringBuilder sb = new StringBuilder();
        // ֻҪ�н�λ�������
        while (add != 0 || i >= 0 || j >= 0) {
            // i, j < 0ʱ����0���൱�ڽ����˲������
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int res = x + y + add;
            sb.append(res % 10);
            add = res / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
