package me.start.Day08;

import javax.xml.soap.SAAJResult;
import java.util.List;

/**
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * 请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 */
public class LC80720139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true; // 空字符串不需要wordDict就能匹配成功
        for (int i = 0; i <= len; i++) {
            if (!dp[i]) { // dp只会在每一个word长度的结点改为true，中间的就直接跳过就好
                continue;
            }
            for (String word : wordDict) {
                if (s.startsWith(word, i)) { // 检测s字符串是否是以word从第i位开始
                    dp[i + word.length()] = true;
                }
            }
            if (dp[len] == true) {
                break;
            }
        }
        return dp[len];
    }
}
