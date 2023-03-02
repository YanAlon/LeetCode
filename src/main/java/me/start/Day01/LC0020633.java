package me.start.Day01;

/**
 * 633.ƽ����֮��
 * ����һ���Ǹ�����c����Ҫ�ж��Ƿ������������ a �� b��ʹ��a^2 + b^2 = c
 * ʾ�� 1��
 * ���룺c = 5
 * �����true
 * ���ͣ�1 * 1 + 2 * 2 = 5
 */
public class LC0020633 {
    /*
    ���� a �� b �ķ�Χ��Ϊ [0, ����c]��
    ������ǿ���ʹ�á�˫ָ�롹��[0,����c]��Χ����ɨ��
     */
    public boolean judgeSquareSum(int c) {
        long a = 0, b = (long) Math.sqrt(c);
        while (a <= b) {
            long cur = a * a + b * b;
            if (cur == c) {
                return true;
            } else if (cur > c) {
                b--;
            } else {
                a++;
            }
        }
        return false;
    }
}
