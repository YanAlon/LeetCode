package me.start.Day03;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. ������ĸ����
 * ����һ���ַ��� s ��
 * ����Ҫ������ַ�������Ϊ�����ܶ��Ƭ�Σ�ͬһ��ĸ��������һ��Ƭ���С�
 * ע�⣬���ֽ����Ҫ���㣺�����л��ֽ����˳�����ӣ��õ����ַ�����Ȼ�� s ��
 * ����һ����ʾÿ���ַ���Ƭ�εĳ��ȵ��б�
 * ʾ�� 1��
 * ���룺s = "ababcbacadefegdehijhklij"
 * �����[9,7,8]
 * ���ͣ�
 * ���ֽ��Ϊ "ababcbaca"��"defegde"��"hijhklij" ��
 * ÿ����ĸ��������һ��Ƭ���С�
 * �� "ababcbacadefegde", "hijhklij" �����Ļ����Ǵ���ģ���Ϊ���ֵ�Ƭ�������١�
 */
public class LC30220763 {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        //����ģ��hash���¼ÿ����ĸ����Զ����λ��
        int[] map = new int[26];
        //תΪchar���飬�ӿ�����ٶ�
        char[] arr = s.toCharArray();
        //�ҳ�ÿ�����ʵ���Զ����λ���±�
        for (int i = 0; i < arr.length; i++) {
            map[arr[i] - 'a'] = i; // a-z��Ӧ0-25������i���Ժ�����ĸ��Ӧ��
        }
        for (int i = 0; i < arr.length; i++) {
            int mIdx = map[arr[i] - 'a'];//��Զλ��
            for (int j = i + 1; j < mIdx; j++) {
                int curIdx = map[arr[j] - 'a'];//��ǰ��Զλ��
                if(curIdx <= mIdx){
                    continue;
                }else {//��[i,mIdx]����������ĸ����Զ����λ�ó���mIdxʱ������mIdx
                    mIdx = curIdx;
                }
            }
            res.add(mIdx - i + 1);//���㵱ǰ���䳤��
            i = mIdx;//����ָ�뵽��ǰ����β��(ѭ����������һ��i++��������֤iָ���¸�������ʼλ��)
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> b = partitionLabels(s);
        System.out.println(b);
    }
}
