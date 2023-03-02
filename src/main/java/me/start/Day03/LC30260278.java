package me.start.Day03;

/**
 * 278. ��һ������İ汾
 * ���ǲ�Ʒ����Ŀǰ���ڴ���һ���Ŷӿ����µĲ�Ʒ��
 * ���ҵ��ǣ���Ĳ�Ʒ�����°汾û��ͨ��������⡣
 * ����ÿ���汾���ǻ���֮ǰ�İ汾�����ģ����Դ���İ汾֮������а汾���Ǵ�ġ�
 * �������� n ���汾 [1, 2, ..., n]��
 * �����ҳ�����֮�����а汾����ĵ�һ������İ汾��
 * �����ͨ������ bool isBadVersion(version) �ӿ�
 * ���жϰ汾�� version �Ƿ��ڵ�Ԫ�����г���
 * ʵ��һ�����������ҵ�һ������İ汾��
 * ��Ӧ�þ������ٶԵ��� API �Ĵ�����
 * ʾ�� 1:
 * ���룺n = 5, bad = 4
 * �����4
 * ���ͣ�
 * ���� isBadVersion(3) -> false
 * ���� isBadVersion(5) -> true
 * ���� isBadVersion(4) -> true
 * ���ԣ�4 �ǵ�һ������İ汾��
 */
public class LC30260278 {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2; // ��ֹ���
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }
}
