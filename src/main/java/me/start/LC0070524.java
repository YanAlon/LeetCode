package me.start;

import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * 给你一个字符串 s 和一个字符串数组 dictionary ，
 * 找出并返回dictionary 中最长的字符串，
 * 该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字母序最小的字符串。
 * 如果答案不存在，则返回空字符串。
 * 示例 1：
 * 输入：s = "abpcplea", dictionary =
 * ["ale","apple","monkey","plea"]
 * 输出："apple"
 */
public class LC0070524 {
    // 两个问题：
    // 如何判断dictionary中的字符串 t 是否可以通过删除 s 中的某些字符得到；    //
    // 如何找到长度最长且字典序最小的字符串。
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String t : dictionary) {
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
            if (i == t.length()) {
                if (t.length() > res.length() ||
                        (t.length() == res.length() && t.compareTo(res) < 0)) {
                    // 如果字符串长度相等，则比较t和res的序号，选择小的
                    res = t;
                }
            }
        }
        return res;
    }
}
