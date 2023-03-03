package me.start.Day04;

import java.util.*;

/**
 * 127. 单词接龙
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列
 * 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 * 每一对相邻的单词只差一个字母。
 *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。
 *  注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，
 * 返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。
 * 如果不存在这样的转换序列，返回 0 。
 * 示例 1：
 * 输入：beginWord = "hit", endWord = "cog",
 *      wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是"hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 */
public class LC40330127 {
    // BFS，从begin开始，遍历所有只差一个字母的，再继续，所以是广度
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        // 先移除表内的beginWord
        wordSet.remove(beginWord); // 如果beginWord不在wordSet内，不会出错吗？

        // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord); // 加入元素
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1; // 起点beginWord包含在内
        while (!queue.isEmpty()) {
            int currentSize = queue.size(); // 遍历长度？
            for (int i = 0; i < currentSize; i++) {
                // 依次遍历队列中的单词
                String currentWord = queue.poll(); // 队首出列，第一个是beginWord
                // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 step + 1
                if (charWord(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 尝试对 currentWord 修改每一个字符，看看是不是能与 endWord 匹配
     *
     * @param currentWord
     * @param endWord
     * @param queue
     * @param visited
     * @param wordSet
     * @return
     */
    private boolean charWord(String currentWord, String endWord,
                             Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] charArray = currentWord.toCharArray(); // 将当前单词转换为字符数组，方便遍历
        for (int i = 0; i < endWord.length(); i++) {
            // 因为要造新词，所以先将原词的字母存起来
            char originChar = charArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == originChar) {
                    continue;
                }
                // 不停循环造新词，直到与endWord相同，否则就存起来，作为一个广度
                charArray[i] = k;
                String nextWord = String.valueOf(charArray); // 将charArray转换为字符串String类型
                // 先判断哈希表内是否存在，不存在直接掠过
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        // 与endWord相同，返回
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        // 注意：添加到队列后， 必须马上标记已经访问。
                        visited.add(nextWord);
                    }
                }
            }
            // 恢复
            charArray[i] = originChar;
        }
        return false;
    }
}
