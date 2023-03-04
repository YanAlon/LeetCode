package me.start.Day04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），
 * 整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，
 * 返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你不能 重新排序或删除 s 中的任何数字。
 * 你可以按 任何 顺序返回答案。
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 */
public class LC40400093 {
    //画图理解
    public List<String> restoreIpAddresses(String s) {
        //定义表示一个字符长度的变量
        int len = s.length();
        //定义一个返回结果的集合
        List<String> res = new ArrayList<>();
        //如果当前字符长度大于12或者小于4都不满足
        if (len > 12 || len < 4) {
            return res;
        }
        //定义一个保存路径上的变量
        Deque<String> path = new ArrayDeque<>();
        //深度优先搜索，参数为：输入数的字符串，长度，0是开始索引，4是剩余未分配的IP段，路径，结果
        dfs(s, len, 0, 4, path, res);
        //返回结果
        return res;
    }

    public void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        //如果字符串已经遍历到最后了，并且已经切分为4段了，
        //就把当前路径上的元素加入到返回的结果集中
        if (begin == len) { // 上一回溯中begin加过1，所以=len了
            if (residue == 0) { //  IP分配完代表成功，路径加入到结果中，再返回
                res.add(String.join(".", path));
            } // 否则直接结束
            return;
        }
        //begin表示遍历字符串从哪里开始
        for (int i = begin; i < begin + 3; i++) {
            //如果超出字符串的长度，就直接退出
            //begin，每次选择都是从之前选择的元素的下一个元素开始，
            if (i >= len) {
                break;
            }
            //如果剩余元素大于ip最多能容纳的个数，就剪枝。
            if (len - i > residue * 3) {
                continue;
            }
            //判断当前截取字符是否是小于0或者大于255
            //这里的begin和i，代表的是，这时候截取了几个字符
            //begin从哪里开始，i到哪里结束，for循环3次，所以这里代表了截取1，2，3个数
            if (judgeIpSegment(s, begin, i)) {
                // 符合条件，保留当前截取字符，范围是[begin, end)，所以要+1
                String currentIpSegment = s.substring(begin, i + 1);
                // 将当前路径上的元素加入到路径队列中
                path.addLast(currentIpSegment);
                // 递归下一层
                dfs(s, len, i + 1, residue - 1, path, res);
                // 回溯，add了一个，结束后将其remove
                path.removeLast();
            }
        }
    }
    // 判断是否符合条件
    private boolean judgeIpSegment(String s, int left, int right) {
        //定义一个表示整个字符的长度
        int len = right - left + 1;
        //如果截取的大于等于2的字符的开头为0，就直接false
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }
        //定义返回结果的集合
        int res = 0; // 不是同一个返回结果
        //拼接字符
        while (left <= right) {
            //res*10 是为了将先加的字符默认比后面的字符大10倍，也就是位数是从小到大
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }

    public static void main(String[] args) {
        String s = "1111";
        LC40400093 solution = new LC40400093();
        List<String> res = solution.restoreIpAddresses(s);
        System.out.println(res);
    }
}
