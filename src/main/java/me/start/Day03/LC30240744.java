package me.start.Day03;

/**
 * 744. 寻找比目标字母大的最小字母
 * 给你一个字符数组 letters，该数组按非递减顺序排序，
 * 以及一个字符 target。letters 里至少有两个不同的字符。
 * 返回 letters 中大于 target 的最小的字符。
 * 如果不存在这样的字符，则返回 letters 的第一个字符。
 * 示例 1：
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 * 解释：letters 中字典上比 'a' 大的最小字符是 'c'。
 */
public class LC30240744 {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] < target) {
            return letters[0];
        }
        int l = 0, r = letters.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (letters[mid] - target <= 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // r指向的位置是比target大的字符
        // l最后的指向一定是最小的大数
        return letters[l];
    }
}
