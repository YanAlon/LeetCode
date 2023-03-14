package me.start.Day09;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），
 * 也不能直接将输入的字符串转换为整数形式。
 * 示例 1：
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 */
public class LC90860415 {
    // 双指针模拟竖式加法运算
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int add = 0; // 用于进位
        StringBuilder sb = new StringBuilder();
        // 只要有进位，则继续
        while (add != 0 || i >= 0 || j >= 0) {
            // i, j < 0时返回0，相当于进行了补零操作
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int res = x + y + add;
            sb.append(res % 10);
            add = res / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
