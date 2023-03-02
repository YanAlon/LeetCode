package me.start.Day03;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * 给你一个字符串 s 。
 * 我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 */
public class LC30220763 {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        //数组模拟hash表记录每个字母的最远出现位置
        int[] map = new int[26];
        //转为char数组，加快查找速度
        char[] arr = s.toCharArray();
        //找出每个单词的最远出现位置下标
        for (int i = 0; i < arr.length; i++) {
            map[arr[i] - 'a'] = i; // a-z对应0-25，所以i可以和其字母对应上
        }
        for (int i = 0; i < arr.length; i++) {
            int mIdx = map[arr[i] - 'a'];//最远位置
            for (int j = i + 1; j < mIdx; j++) {
                int curIdx = map[arr[j] - 'a'];//当前最远位置
                if(curIdx <= mIdx){
                    continue;
                }else {//当[i,mIdx]区间内有字母的最远出现位置超出mIdx时，更新mIdx
                    mIdx = curIdx;
                }
            }
            res.add(mIdx - i + 1);//计算当前区间长度
            i = mIdx;//后移指针到当前区间尾部(循环结束还有一次i++操作，保证i指向下个区间起始位置)
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> b = partitionLabels(s);
        System.out.println(b);
    }
}
