package me.start.Day02;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。
 * 返回 需要移除区间的最小数量，使剩余区间互不重叠。
 * 示例 1:
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 */
public class LC20130435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
//        使用lambda表达式会创建Comparator导致算法运行时间过长
//        如果注重运行时间，可以修改为普通创建Comparator语句
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
                // 实现 compare() 函数时避免使用 return o1[1] - o2[1]; 这种减法操作，防止溢出
            }
        });
        int count = 1; // 计数作用
        int end = intervals[0][1]; // 选择第一个的最右区间
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue; // 从第二个区间开始，如果左区间比右区间小，那么这个区间就不计算在内
            }
            end = intervals[i][1]; // 当没有continue，说明这个区间被采纳，则结束点应为这个区间的右区间
            count++; // 采纳区间+1
        }
        return intervals.length - count; // 总的 - 被采纳的 = 剩下的
    }
}
