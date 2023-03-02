package me.start.Day01;

/**
 * 633.平方数之和
 * 给定一个非负整数c，你要判断是否存在两个整数 a 和 b，使得a^2 + b^2 = c
 * 示例 1：
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 */
public class LC0020633 {
    /*
    由于 a 和 b 的范围均为 [0, 根号c]，
    因此我们可以使用「双指针」在[0,根号c]范围进行扫描
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
