package me.start;

/**
 * 680. 验证回文串 II
 * 给你一个字符串s，最多 可以从中删除一个字符。
 * 请你判断 s 是否能成为回文字符串：
 * 如果能，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：s = "aba"
 * 输出：true
 * 示例 2：
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 */
public class LC0040680 {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                // 因为只能删除一个字符，
                // 所以只要在第一次不相等时判断中间的字符串是否符合就可以了，
                // 并不需要一个变量计数删除字符数量
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1,j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
