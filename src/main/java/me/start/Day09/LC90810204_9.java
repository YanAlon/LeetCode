package me.start.Day09;

import java.util.Arrays;

/**
 * 204. 计数质数
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * 示例 1：
 * 输入：n = 10
 * 输出：
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class LC90810204_9 {
    // 还可以运用比特表（Bitmap）算法对筛法进行内存优化，暂未实现
    public int countPrimes(int n) {
        // 设置变量标记是否为素数
        boolean[] isPrime = new boolean[n];
        // 将所有数预标记为true
        Arrays.fill(isPrime, true);
        // 开始进行判断，按照厄拉多塞筛法的思路进行
        int count = 0; // 计数
        // 索引就代表数本身，从1开始，不含0
        // 判定这里可以写为i * i < n，但是这样写，count的计数就需要单独算了
        for (int i = 2; i < n; i++) {
            System.out.println("数：" + i);
            // 从2开始，1不需要判断
            if (isPrime[i]) { // 因为从2开始，所以一开始标记为true不会出错
                count += 1; // 统计素数
                System.out.println("数：" + i + " , count: " + count);
                // 如果是素数，则将后续所有这个数的倍数标记为不是素数
                // 为什么是i * i开始，因为平方前的倍数已经被更小的数的倍数标记了
                // 当然，这里也可以改成i + i开始，只是计算会更久
                if (i * i >= n) {
                    continue;
                }
                // 不加long的话会越界，没搞懂
                for (int j = i; (long) i * j < n; j++) {
                    System.out.println("j数：" + j);
                    isPrime[i * j] = false;
                }
            }
        }
        // 计数剩下的数，全为素数
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        LC90810204_9 solution = new LC90810204_9();
        int res = solution.countPrimes(n);
        System.out.println(res);
    }
}
