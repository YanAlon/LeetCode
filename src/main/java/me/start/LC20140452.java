package me.start;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。
 * 墙面上的气球记录在整数数组points，
 * 其中points[i] = [xstart, xend]表示水平直径在xstart和xend之间的气球。
 * 你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。
 * 在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足 xstart ≤ x ≤ xend，则该气球会被 引爆。可以射出的弓箭的数量 没有限制 。
 * 弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数。
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 */
public class LC20140452 {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
//        使用lambda表达式会创建Comparator导致算法运行时间过长
//        如果注重运行时间，可以修改为普通创建Comparator语句
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
                // 实现 compare() 函数时避免使用 return o1[1] - o2[1]; 这种减法操作，防止溢出
            }
        });
//        System.out.println("points的数值：");
//        for(int i=0; i<4; ++i) {
//            for(int j=0; j<2; ++j)
//                System.out.print(points[i][j]);
//            System.out.print("\n");//显示成数组的表现形式
//        }
        int count = 1; // 计数箭
        int end = points[0][1]; // 选择第一个的最右区间
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
                // 从第二个区间开始，如果左区间比右区间小，那么就继续，暂不计算箭的数量
            }
            end = points[i][1];
            // 当没有continue，说明这个区间不重叠了，则结束点应为这个区间的右区间
            count++;
            // 箭数+1， 准备射击下一组，因为如果可以进行到这，证明后面还有气球
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int count = findMinArrowShots(points);
        System.out.println(count);
    }
}
