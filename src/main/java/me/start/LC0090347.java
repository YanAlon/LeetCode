package me.start;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 347. ǰ K ����ƵԪ��
 * ����һ���������� nums ��һ������ k �����㷵�����г���Ƶ��ǰ k �ߵ�Ԫ�ء�����԰� ����˳�� ���ش𰸡�
 * ʾ�� 1:
 * ����: nums = [1,1,1,2,2,3], k = 2
 * ���: [1,2]
 */
public class LC0090347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 1.�����ÿ��ֵ���ֵ�Ƶ��
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
            // 1.getOrDefault(num, 0):�������num�򷵻ض�Ӧvalue�����򷵻�0
            // 2.put(key, value):��map�����Ԫ�ء���Ԫ��num��Ӧ��key��value+1
            // ���У������Ǿ����������value�洢���ִ���
        }
        // 2.�����ֵ��ӦƵ�� -> Ƶ�ʶ�Ӧֵ��ת��
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        // ������һ��List���͵����飬�����СΪnums.length + 1
        // ������Ƶ�ʴ洢��Ͱ��
        // ���������ɵ�����ֵ��ӦƵ�� -> Ƶ�ʶ�Ӧֵ��ת�������ǵĴ�С�ǲ�ͬ��
        for (int key : frequencyForNum.keySet()) { // ��keySet���ص���ͼ�з���ÿһ�� key
            int frequency = frequencyForNum.get(key); // ��ȡƵ��
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>(); // ÿһ��Ͱ����һ������
            }
            buckets[frequency].add(key); // ����ӦƵ�ʵ�ֵ����������
        }

        // 3.��ȡǰk��Ƶ��Ԫ��
        List<Integer> topK = new ArrayList<>(); // ������һ��List
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            // �������k��Ԫ�أ�ѭ��������ǰ����i>=0
            if (buckets[i] == null) { // �Ӻ���ǰ��������ΪƵ�ʾ������������Ը�Ƶ��Ԫ���ں���
                // ��Ϊ�����С�ǳ���Ƶ�����ģ��������λ������null
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) { // �����ǰƵ�ʰ���Ԫ��<=��ȱ�ٵ�Ԫ��
                topK.addAll(buckets[i]); // �򽫵�ǰƵ�ʵ�����Ԫ�ػ�ȡ
            } else { // ����ֻ��ȡ��ȱ�ٵ�������Ԫ��
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        // 4.���õ���k��Ԫ�ذ�˳��������飬������
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topK.get(i);
        }
        return res;
    }
}
