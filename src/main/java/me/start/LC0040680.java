package me.start;

/**
 * 680. ��֤���Ĵ� II
 * ����һ���ַ���s����� ���Դ���ɾ��һ���ַ���
 * �����ж� s �Ƿ��ܳ�Ϊ�����ַ�����
 * ����ܣ����� true �����򣬷��� false ��
 * ʾ�� 1��
 * ���룺s = "aba"
 * �����true
 * ʾ�� 2��
 * ���룺s = "abca"
 * �����true
 * ���ͣ������ɾ���ַ� 'c' ��
 */
public class LC0040680 {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                // ��Ϊֻ��ɾ��һ���ַ���
                // ����ֻҪ�ڵ�һ�β����ʱ�ж��м���ַ����Ƿ���ϾͿ����ˣ�
                // ������Ҫһ����������ɾ���ַ�����
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1,j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
