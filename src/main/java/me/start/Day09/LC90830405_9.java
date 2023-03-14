package me.start.Day09;

/**
 * 405. ����ת��Ϊʮ��������
 * ����һ����������дһ���㷨�������ת��Ϊʮ����������
 * ���ڸ�����������ͨ��ʹ�� �������� ������
 * ע��:
 * ʮ��������������ĸ(a-f)��������Сд��
 * ʮ�������ַ����в��ܰ��������ǰ���㡣���Ҫת������Ϊ0��
 * ��ô�Ե����ַ�'0'����ʾ���������������ʮ�������ַ����еĵ�һ���ַ���������0�ַ���
 * ��������ȷ����32λ�з���������Χ�ڡ�
 * ����ʹ���κ��ɿ��ṩ�Ľ�����ֱ��ת�����ʽ��Ϊʮ�����Ƶķ�����
 * ʾ�� 1��
 * ����:
 * 26
 * ���:
 * "1a"
 */
public class LC90830405_9 {
    // ���⻹����ʹ�� λ����+���黻�� �������δ����
    public String toHex(int num) {
        if (num == 0) return "0";
        long n = num;
        // ����ĸ���Ҫ��ʹ�ò�����ʽ
        if (n < 0) {
            n = (long)(Math.pow(2, 32) + n);
        }
        // ��������Ϊʲô��2^32�η���һ��˼����
        // `��ö�ټ��������Ĳ���ֵ�� -1��Ӧ0xFFFFFFFF,������0xFFFFFFFF+1-1����
        // -2��Ӧ0xFFFFFFFE,������0xFFFFFFFF+1-2����
        // ���ǿ��Է��֣�����һ�������ĸ�����ֻ��Ҫ�������0xFFFFFFFF+1,
        // �ټ�ȥ�ø����ľ���ֵ���ɵõ��ø�����Ӧ�Ĳ���ֵ��
        // ��ô�����ǲ��Ǿ��Ǵ��������ֵģ�
        // if(n < 0) n = (long)(Math.pow(2, 32) + n);
        //ע��0xFFFFFFFF+1����ʮ����ΪMath.pow(2, 32)��
        StringBuilder sb = new StringBuilder();
        long remainder = 0; // ����
        do {
            remainder = n % 16;
            if (remainder < 10) {
                sb.append(remainder);
            } else {
                sb.append((char)(remainder - 10 + 'a'));
            }
            n /= 16;
        } while (n != 0);
        String res = sb.reverse().toString();
        return res;
    }

    public static void main(String[] args) {
        int num = 16;
        LC90830405_9 solution = new LC90830405_9();
        String res = solution.toHex(num);
        System.out.println(res);
    }
}
