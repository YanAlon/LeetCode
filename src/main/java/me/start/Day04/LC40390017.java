package me.start.Day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. �绰�������ĸ���
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
 * �𰸿��԰� ����˳�� ���ء�
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 * �и�ͼ������9�����֣����ף�
 * ʾ�� 1��
 * ���룺digits = "23"
 * �����["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LC40390017 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        // ֱ�ӿ�ʼ����
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character,
            String> phoneMap, String digits, int index, StringBuffer combination) {
        // ������=���ĳ��ȣ���ô�ݹ����
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index); // �ӵ�һ��Ԫ�ؿ�ʼ
            String letters = phoneMap.get(digit); // ��hashMap���õ�������Ӧ����ĸ
            int lettersCount = letters.length(); // ��ĸ���ȣ����������ѭ��
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i)); // ���ű���
                // index + 1���Ƶ�2��������ĸ
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
