package me.start.Day04;

import java.util.*;

/**
 * 127. ���ʽ���
 * �ֵ� wordList �дӵ��� beginWord �� endWord �� ת������
 * ��һ������������γɵ����� beginWord -> s1 -> s2 -> ... -> sk��
 * ÿһ�����ڵĵ���ֻ��һ����ĸ��
 *  ���� 1 <= i <= k ʱ��ÿ�� si ���� wordList �С�
 *  ע�⣬ beginWord ����Ҫ�� wordList �С�
 * sk == endWord
 * ������������ beginWord �� endWord ��һ���ֵ� wordList ��
 * ���� �� beginWord �� endWord �� ���ת������ �е� ������Ŀ ��
 * ���������������ת�����У����� 0 ��
 * ʾ�� 1��
 * ���룺beginWord = "hit", endWord = "cog",
 *      wordList = ["hot","dot","dog","lot","log","cog"]
 * �����5
 * ���ͣ�һ�����ת��������"hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      �������ĳ��� 5��
 */
public class LC40330127 {
    // BFS����begin��ʼ����������ֻ��һ����ĸ�ģ��ټ����������ǹ��
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // �� 1 �����Ƚ� wordList �ŵ���ϣ��������ж�ĳ�������Ƿ��� wordList ��
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        // ���Ƴ����ڵ�beginWord
        wordSet.remove(beginWord); // ���beginWord����wordSet�ڣ����������

        // �� 2 ����ͼ�Ĺ�����ȱ���������ʹ�ö��кͱ�ʾ�Ƿ���ʹ��� visited ��ϣ��
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord); // ����Ԫ��
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // �� 3 ������ʼ������ȱ�����������㣬��˳�ʼ����ʱ����Ϊ 1
        int step = 1; // ���beginWord��������
        while (!queue.isEmpty()) {
            int currentSize = queue.size(); // �������ȣ�
            for (int i = 0; i < currentSize; i++) {
                // ���α��������еĵ���
                String currentWord = queue.poll(); // ���׳��У���һ����beginWord
                // ��� currentWord �ܹ��޸� 1 ���ַ��� endWord ��ͬ���򷵻� step + 1
                if (charWord(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * ���Զ� currentWord �޸�ÿһ���ַ��������ǲ������� endWord ƥ��
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
        char[] charArray = currentWord.toCharArray(); // ����ǰ����ת��Ϊ�ַ����飬�������
        for (int i = 0; i < endWord.length(); i++) {
            // ��ΪҪ���´ʣ������Ƚ�ԭ�ʵ���ĸ������
            char originChar = charArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == originChar) {
                    continue;
                }
                // ��ͣѭ�����´ʣ�ֱ����endWord��ͬ������ʹ���������Ϊһ�����
                charArray[i] = k;
                String nextWord = String.valueOf(charArray); // ��charArrayת��Ϊ�ַ���String����
                // ���жϹ�ϣ�����Ƿ���ڣ�������ֱ���ӹ�
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        // ��endWord��ͬ������
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        // ע�⣺��ӵ����к� �������ϱ���Ѿ����ʡ�
                        visited.add(nextWord);
                    }
                }
            }
            // �ָ�
            charArray[i] = originChar;
        }
        return false;
    }
}
