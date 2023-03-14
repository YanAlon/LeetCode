package me.start.Day09;

/**
 * 367. 有效的完全平方数
 * 给你一个正整数 num 。
 * 如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 完全平方数 是一个可以写成某个整数的平方的整数。
 * 换句话说，它可以写成某个整数和自身的乘积。
 * 不能使用任何内置的库函数，如  sqrt 。
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 * 解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
 */
public class LC90890367_9 {
    // 1、暴力法(超时，也不知道对不对)
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
    // 以此类推，模仿它可以使用一个while循环，不断减去一个从1开始不断增大的奇数，
    // 若最终减成了0，说明是完全平方数，否则，不是。
    // n^2 = 1 + 3 + 5 + …… + (2n-1)
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
