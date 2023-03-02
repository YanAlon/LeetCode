package me.start.Day02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**\
 * 406. ��������ؽ�����
 * �����д���˳���һȺ��վ��һ�����У����� people ��ʾ������һЩ�˵����ԣ���һ����˳�򣩡�
 * ÿ�� people[i] = [hi, ki] ��ʾ�� i ���˵����Ϊ hi ��
 * ǰ�� ���� �� ki ����ߴ��ڻ���� hi ���ˡ�
 * �������¹��첢������������ people ����ʾ�Ķ��С�
 * ���صĶ���Ӧ�ø�ʽ��Ϊ���� queue ��
 * ���� queue[j] = [hj, kj] �Ƕ����е� j ���˵����ԣ�queue[0] �����ڶ���ǰ����ˣ���
 * ʾ�� 1��
 * ���룺people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * �����[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * ���ͣ�
 * ���Ϊ 0 �������Ϊ 5 ��û����߸��߻�����ͬ����������ǰ�档
 * ���Ϊ 1 �������Ϊ 7 ��û����߸��߻�����ͬ����������ǰ�档
 * ���Ϊ 2 �������Ϊ 5 ���� 2 ����߸��߻�����ͬ����������ǰ�棬�����Ϊ 0 �� 1 ���ˡ�
 * ���Ϊ 3 �������Ϊ 6 ���� 1 ����߸��߻�����ͬ����������ǰ�棬�����Ϊ 1 ���ˡ�
 * ���Ϊ 4 �������Ϊ 4 ���� 4 ����߸��߻�����ͬ����������ǰ�棬�����Ϊ 0��1��2��3 ���ˡ�
 * ���Ϊ 5 �������Ϊ 7 ���� 1 ����߸��߻�����ͬ����������ǰ�棬�����Ϊ 1 ���ˡ�
 * ��� [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] �����¹����Ķ��С�
 */
public class LC20150406 {
    public int[][] reconstructQueue(int[][] people) { // ����ֵΪ��ά���飬����public int[][]
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        //�������һ��Ԫ�ؽ��н��򣬰��ڶ���Ԫ�ؽ�������
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2){
                // ����ʹ����һ��ģ���������дif else
                if (person1[0] != person2[0]){
                    //��һ��Ԫ�ز����ʱ����һ��Ԫ�ؽ���
                    return person2[0] - person1[0];
                }else{
                    //��һ��Ԫ�����ʱ���ڶ���Ԫ������
                    return person1[1] - person2[1];
                }
            }
        });
        //�½�һ��list,���ڱ�������
        List<int[]> queue = new LinkedList<>();
        for (int[] p : people) {
            if (queue.size() <= p[1]) {
                queue.add(p);
            } else {
                queue.add(p[1], p);
            }
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
