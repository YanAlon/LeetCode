package me.start;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 451. �����ַ�����Ƶ������
 * ����һ���ַ��� s �������ַ����ֵ� Ƶ�� ������� �������� ��
 * һ���ַ����ֵ� Ƶ�� �����������ַ����еĴ�����
 * ���� ��������ַ���������ж���𰸣����������κ�һ����
 * ʾ�� 1:
 * ����: s = "tree"
 * ���: "eert"
 * ����: 'e'�������Σ�'r'��'t'��ֻ����һ�Ρ�
 * ���'e'���������'r'��'t'֮ǰ�����⣬"eetr"Ҳ��һ����Ч�Ĵ𰸡�
 */
public class LC0100451 {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyForNum = new HashMap<>();
        for (char c : s.toCharArray()) // ��s����Ϊ����
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);
            // 1.getOrDefault(num, 0):�������num�򷵻ض�Ӧvalue�����򷵻�0
            // 2.put(key, value):��map�����Ԫ�ء���Ԫ��num��Ӧ��key��value+1
            // ���У������Ǿ����������value�洢���ִ���

        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
        for (char c : frequencyForNum.keySet()) {
            int f = frequencyForNum.get(c);
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }
            frequencyBucket[f].add(c);
        }
        StringBuilder str = new StringBuilder();
        // �� String �಻ͬ���ǣ�
        // StringBuffer��StringBuilder��Ķ����ܹ�����ε��޸ģ�
        // ���Ҳ������µ�δʹ�ö���
        for (int i = frequencyBucket.length - 1; i >= 0; i--) {
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j++) {
                    str.append(c);
                }
            }
        }
        return str.toString();
    }
}
