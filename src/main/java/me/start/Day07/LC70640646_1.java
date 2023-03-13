package me.start.Day07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 646. 最长数对链
 * 给你一个由 n 个数对组成的数对数组 pairs ，
 * 其中 pairs[i] = [lefti, righti] 且 lefti < righti 。
 * 现在，我们定义一种 跟随 关系，当且仅当 b < c 时，数对 p2 = [c, d]
 * 才可以跟在 p1 = [a, b] 后面。我们用这种形式来构造 数对链 。
 * 找出并返回能够形成的 最长数对链的长度 。
 * 你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * 示例 1：
 * 输入：pairs = [[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4] 。
 */
public class LC70640646_1 {
    // 1、动态规划
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 2、贪心算法
    public int findLongestChain02(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);            //Lambda表达式,返回Comparator接口的实现方法
        //这里已经按照第二列的元素从小到大排好序,
        //在后续可加入的元素中，遍历到的第一个就是后续中第二列列有最小值的
        //每次加入的都是第二列最小值的，画个数轴表示一下应该就懂为什么这样做是最优解的道理了

        int cur=Integer.MIN_VALUE,ans=0;
        // int left=pairs[0][0],right=pairs[0][1];

        for(int[] pair:pairs){
            if(cur<pair[0]){
                cur=pair[1];                 //替换第二列的最大值,始终是链尾数对的第二个数值
                ans++;
            }
        }
        return ans;
    }
}
