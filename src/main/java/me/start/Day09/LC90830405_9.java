package me.start.Day09;

/**
 * 405. 数字转换为十六进制数
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。
 * 对于负整数，我们通常使用 补码运算 方法。
 * 注意:
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，
 * 那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 示例 1：
 * 输入:
 * 26
 * 输出:
 * "1a"
 */
public class LC90830405_9 {
    // 本题还可以使用 位运算+分组换算 解决，暂未进行
    public String toHex(int num) {
        if (num == 0) return "0";
        long n = num;
        // 本题的负数要求使用补码形式
        if (n < 0) {
            n = (long)(Math.pow(2, 32) + n);
        }
        // 关于这里为什么加2^32次方的一点思考：
        // `先枚举几个负数的补码值： -1对应0xFFFFFFFF,（看作0xFFFFFFFF+1-1）；
        // -2对应0xFFFFFFFE,（看作0xFFFFFFFF+1-2）。
        // 我们可以发现，对于一个给定的负数，只需要将其加上0xFFFFFFFF+1,
        // 再减去该负数的绝对值即可得到该负数对应的补码值。
        // 怎么样，是不是就是代码里体现的：
        // if(n < 0) n = (long)(Math.pow(2, 32) + n);
        //注：0xFFFFFFFF+1化成十进制为Math.pow(2, 32)。
        StringBuilder sb = new StringBuilder();
        long remainder = 0; // 余数
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
