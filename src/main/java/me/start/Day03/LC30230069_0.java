package me.start.Day03;

/**
 * 69. x ��ƽ����
 * ����һ���Ǹ����� x �����㲢���� x �� ����ƽ���� ��
 * ���ڷ������������������ֻ���� �������� ��С�����ֽ��� ��ȥ ��
 * ע�⣺������ʹ���κ�����ָ����������������� pow(x, 0.5) ���� x ** 0.5 ��
 * ʾ�� 1��
 * ���룺x = 4
 * �����2
 */
public class LC30230069_0 {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
