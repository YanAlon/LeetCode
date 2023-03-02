package me.start.Day03;

/**
 * 744. Ѱ�ұ�Ŀ����ĸ�����С��ĸ
 * ����һ���ַ����� letters�������鰴�ǵݼ�˳������
 * �Լ�һ���ַ� target��letters ��������������ͬ���ַ���
 * ���� letters �д��� target ����С���ַ���
 * ����������������ַ����򷵻� letters �ĵ�һ���ַ���
 * ʾ�� 1��
 * ����: letters = ["c", "f", "j"]��target = "a"
 * ���: "c"
 * ���ͣ�letters ���ֵ��ϱ� 'a' �����С�ַ��� 'c'��
 */
public class LC30240744 {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] < target) {
            return letters[0];
        }
        int l = 0, r = letters.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (letters[mid] - target <= 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // rָ���λ���Ǳ�target����ַ�
        // l����ָ��һ������С�Ĵ���
        return letters[l];
    }
}
