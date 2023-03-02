package me.start.Day04;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量
 * 完全平方数 是一个整数，其值等于另一个整数的平方；
 * 换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 */
public class LC40320279 {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>(); // 队列
        HashSet<Integer> visited = new HashSet<>(); // 哈希表
        queue.offer(n); // 将指定元素加入该队列的尾部，有时比add更好用
        visited.add(n); // 标记已访问
        int level = 0; // 标注完全平方数的数目

        // 什么原理？
        // 似乎明白了，就是不停的从1开始往下减，当第一次减到0，则代表这是最短的，那这就是想要的level
        // 比如12，下面循环的过程是12->8->4->0，而中间的数，都是被淘汰的罢了
        while (!queue.isEmpty()) {
            level++;
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int cur = queue.poll(); // 获取队列头部的元素，并删除该元素

                for (int j = 1; j * j <= cur; j++) { // 从1开始
                    int tmp = cur - j * j;
                    if (tmp == 0)
                        return level;
                    if (!visited.contains(tmp))
                        queue.offer(tmp);
                    visited.add(tmp);
                }
            }
        }
        return level;
    }
}
