package me.start.Day09;

/**
 * 168. Excel��������(������һ��26����ת������)
 * ����һ������ columnNumber ���������� Excel �������Ӧ�������ơ�
 * ���磺
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * ʾ�� 1��
 * ���룺columnNumber = 1
 * �����"A"
 */
public class LC90840168 {
    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0) return "";
        char[] map = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
                      'H', 'I', 'J', 'K', 'L', 'M', 'N',
                      'O', 'P', 'Q', 'R', 'S', 'T',
                      'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append(map[columnNumber % 26]);
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
