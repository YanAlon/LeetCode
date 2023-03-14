package me.start.Day09;

/**
 * 504. 七进制数
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * 示例 1:
 * 输入: num = 100
 * 输出: "202"
 */
public class LC90820504 {
    public String convertToBase7(int num) {
        // 如果num是负数，则需要处理为正数
        boolean isNegative = num < 0; // 先标记
        if (isNegative) { // 如果是负数
            num = -num;   // 则转换为正数
        }
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            sb.append(num);
        }
        // 如果改为do-while，则可以避免0的情况
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        // %得到的结果是从各位开始的，所以是反的
        String res =sb.reverse().toString();
        // 如果是负数，则将符号加回去
        return isNegative ? "-" + res : res;
    }
}
