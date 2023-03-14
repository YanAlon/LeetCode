package me.start.Day09;

/**
 * 367. ��Ч����ȫƽ����
 * ����һ�������� num ��
 * ��� num ��һ����ȫƽ�������򷵻� true �����򷵻� false ��
 * ��ȫƽ���� ��һ������д��ĳ��������ƽ����������
 * ���仰˵��������д��ĳ������������ĳ˻���
 * ����ʹ���κ����õĿ⺯������  sqrt ��
 * ʾ�� 1��
 * ���룺num = 16
 * �����true
 * ���ͣ����� true ����Ϊ 4 * 4 = 16 �� 4 ��һ��������
 */
public class LC90890367_9 {
    // 1��������(��ʱ��Ҳ��֪���Բ���)
    public boolean isPerfectSquare00(int num) {
        if (num == 1) {
            return true;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    // 1 4=1+3 9=1+3+5 16=1+3+5+7
    // �Դ����ƣ�ģ��������ʹ��һ��whileѭ�������ϼ�ȥһ����1��ʼ���������������
    // �����ռ�����0��˵������ȫƽ���������򣬲��ǡ�
    // n^2 = 1 + 3 + 5 + ���� + (2n-1)
    public boolean isPerfectSquare(int num) {
        int l = 0, r = num, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long) mid * mid <= num) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans * ans == num;
    }


}
