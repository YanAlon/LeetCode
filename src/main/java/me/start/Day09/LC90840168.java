package me.start.Day09;

/**
 * 168. Excel表列名称(本质是一个26进制转换问题)
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * 例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1：
 * 输入：columnNumber = 1
 * 输出："A"
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
