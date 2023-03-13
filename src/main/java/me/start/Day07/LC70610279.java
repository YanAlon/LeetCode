package me.start.Day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；
 * 换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 */
public class LC70610279 {
    // 1、从1开始逐数计算
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 让数和索引对应
        for (int i = 1; i <= n; i++) { // 从2开始算完全平方数累加最大值
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) { //
                // 它采用的方法是从1开始不断累加计算拆分完全平方数和的最大值，一直算到目标数
                // dp[i - j * j] + 1 控制减去新的完全平方数，那组成这个数的完全平方数个数
                // 就等于减去后剩下数的dp再加上这个完全平方数，即+1
                // 例如7可以循环到7-2*2，也就是dp[7]=dp[7-2*2]+1,这个1就是2*2的4带来的
                // 所以，组成7的完全平方数就是7=4+dp[3]的，也就是7=4+1+1+1；
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                System.out.println("i:" + i + "dp[i]:" + dp[i]);
            }
        }
        return dp[n];
    }

    // 2、github 预处理算出平方数
    public int numSquares02(int n) {
        // 生成平方数列表
        List<Integer> squareList = generateSquareList(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // 区别就在下面的循环中
            for (int square : squareList) {
                if (square > i) {
                    break;
                }
                min = Math.min(min, dp[i - square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    private List<Integer> generateSquareList(int n) {
        List<Integer> squareList = new ArrayList<>();
        int diff = 3;
        int square = 1;
        while (square <= n) {
            squareList.add(square);
            square += diff;
            diff += 2;
        }
        return squareList;
    }

    // 3、数学法：四平方和定理

    /**
     * 四平方和定理证明了任意一个正整数都可以被表示为至多四个正整数的平方和。这给出了本题的答案的上界。
     * 同时四平方和定理包含了一个更强的结论：当且仅当 n ≠ 4^k * (8m + 7) 时，
     * n 可以被表示为至多三个正整数的平方和。因此，当 n = 4^k * (8m + 7) 时，
     * n 只能被表示为四个正整数的平方和。此时我们可以直接返回4。
     * 当 n ≠ 4^k * (8m + 7) 时，我们需要判断到底多少个完全平方数能够表示 n，
     * 我们知道答案只会是 1，2，3 中的一个：
     * 答案为 1 时，则必有 n 为完全平方数，这很好判断；
     * 答案为 2 时，则有 n = a^2 + b^2，我们只需要枚举所有的 a (1 <= a <= sqrt(a))，
     * 判断 n - a^2 是否为完全平方数即可；
     * 答案为 3 时，我们很难在一个优秀的时间复杂度内解决它，
     * 但我们只需要检查答案为 1 或 2 的两种情况，即可利用排除法确定答案。
     * @param n
     * @return
     */

    public int numSquares03(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }

    public static void main(String[] args) {
        int n = 12;
        LC70610279 solution = new LC70610279();
        int res = solution.numSquares(n);
        int res02 = solution.numSquares02(n);
        int res03 = solution.numSquares03(n);
        System.out.println(res);
        System.out.println(res02);
        System.out.println(res03);
    }
}
