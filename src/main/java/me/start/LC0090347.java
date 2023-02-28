package me.start;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class LC0090347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 1.计算出每个值出现的频率
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
            // 1.getOrDefault(num, 0):如果存在num则返回对应value，否则返回0
            // 2.put(key, value):向map中添加元素。将元素num对应的key的value+1
            // 其中，可以是具体的数，而value存储出现次数
        }
        // 2.完成由值对应频率 -> 频率对应值的转换
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        // 声明了一个List类型的数组，数组大小为nums.length + 1
        // 将所有频率存储在桶中
        // 这个数组完成的是由值对应频率 -> 频率对应值的转换，它们的大小是不同的
        for (int key : frequencyForNum.keySet()) { // 在keySet返回的视图中访问每一个 key
            int frequency = frequencyForNum.get(key); // 获取频率
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>(); // 每一个桶创建一个数组
            }
            buckets[frequency].add(key); // 将对应频率的值存入数组中
        }

        // 3.获取前k高频的元素
        List<Integer> topK = new ArrayList<>(); // 声明了一个List
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            // 当获得了k个元素，循环结束，前提是i>=0
            if (buckets[i] == null) { // 从后往前便利，因为频率就是索引，所以高频的元素在后面
                // 因为数组大小是超出频率数的，所以最后几位可能是null
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) { // 如果当前频率包含元素<=还缺少的元素
                topK.addAll(buckets[i]); // 则将当前频率的所有元素获取
            } else { // 否则只获取还缺少的数量的元素
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        // 4.将得到的k个元素按顺序存入数组，并返回
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topK.get(i);
        }
        return res;
    }
}
