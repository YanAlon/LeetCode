package me.start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 345.反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 * 示例 1：
 * 输入：s = "hello"
 * 输出："holle"
 */
public class LC0030345 {
    // 将全部元音字符添加到集合 HashSet 中, 避免使用循环
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    );

    public String reverseVowels(String s) {
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()]; // 创建新的字符数组，存储结果
        while (i <= j) {
            char ci = s.charAt(i); // 按索引获取字符串中对应的字符
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) { // 如果ci不是元音
                result[i++] = ci; // 不是原因则不变，直接存到result
            } else if (!vowels.contains(cj)) {
                result[j--] = cj; // 后置
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}
