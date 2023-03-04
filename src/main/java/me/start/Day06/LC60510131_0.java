package me.start.Day06;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。
 * 返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 */
public class LC60510131_0 {
    // 1、回溯优化+动态规划的（没看懂
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 将字符串转换为字符char数组，方便操作
        char[] charArray = s.toCharArray();
        // 预处理
        // 设置状态，
        boolean[][] dp = new boolean[len][len];
        // 状态转移方程
        // 在s[i] == s[j]时，dp[i][j]参考dp[i+1][j-1]
        for (int right = 0; right < len; right++) {
            // 注意：left <= right中取了=等号，因为只有1个字符的时候也要判断
            for (int left = 0; left <= right; left++) {
                System.out.println(left + " : " + right);
                System.out.println(charArray[left] + " : " + charArray[right]);
                if (charArray[left] == charArray[right] &&
                        (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        Deque<String> stack = new ArrayDeque<>();
        dfs(s, 0, len, dp, stack, res);
        return res;
    }

    private void dfs(String s, int index, int len, boolean[][] dp,
                     Deque<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            if (dp[index][i]) { // 如果是回文，继续截取；不是则下一个
                path.addLast(s.substring(index, i + 1));
                dfs(s, i + 1, len, dp, path, res);
                path.removeLast();
            }
        }
    }

    // 方法Ⅱ：使用中心拓展做预处理
    public List<List<String>> partition02(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        // 使用动态规划记录回文
        boolean[][] dp = new boolean[len][len];
        // 预处理
        for(int i = 0; i < len; i++){
            prePro(s, i, i, dp);
            prePro(s, i, i + 1, dp);
        }
        // 结果， 路径， 字符串，索引，路径规划（是否是回文）
        helper(res, new ArrayList<>(), s, 0, dp);
        return res;
    }

    //进行预处理，利用中心扩展 将所有回文子串的位置存储到 dp 中
    private void prePro(String s, int left , int right, boolean[][] dp){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            dp[left][right] = true;
            // 中心扩展，往两边遍历
            left--;
            right++;
        }
    }

    private void helper(List<List<String>> res, List<String> list, String s,
                        int index, boolean[][] dp){
        if(index == s.length()){
            System.out.println("add");
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < s.length(); i++){
            System.out.println("for i : " + i);
            System.out.println("index : " + index);
            //利用预处理结果就不用再去判断该字符串是否是回文串
            if(!dp[index][i]){
                System.out.println("false");
                continue;
            }
            list.add(s.substring(index, i + 1));
            helper(res, list, s, i + 1, dp);
            System.out.println("dfs i : " + i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        LC60510131_0 solution = new LC60510131_0();
        List<List<String>> res = solution.partition02(s);
        System.out.println(res);
    }
}










