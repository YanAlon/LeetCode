package me.start.Day04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 93. ��ԭ IP ��ַ
 * ��Ч IP ��ַ �������ĸ�������ÿ������λ�� 0 �� 255 ֮����ɣ��Ҳ��ܺ���ǰ�� 0����
 * ����֮���� '.' �ָ���
 * ���磺"0.1.2.201" �� "192.168.1.1" �� ��Ч IP ��ַ��
 * ���� "0.011.255.245"��"192.168.1.312" �� "192.168@1.1" �� ��Ч IP ��ַ��
 * ����һ��ֻ�������ֵ��ַ��� s �����Ա�ʾһ�� IP ��ַ��
 * �������п��ܵ���Ч IP ��ַ����Щ��ַ����ͨ���� s �в��� '.' ���γɡ�
 * �㲻�� ���������ɾ�� s �е��κ����֡�
 * ����԰� �κ� ˳�򷵻ش𰸡�
 * ʾ�� 1��
 * ���룺s = "25525511135"
 * �����["255.255.11.135","255.255.111.35"]
 */
public class LC40400093 {
    //��ͼ���
    public List<String> restoreIpAddresses(String s) {
        //�����ʾһ���ַ����ȵı���
        int len = s.length();
        //����һ�����ؽ���ļ���
        List<String> res = new ArrayList<>();
        //�����ǰ�ַ����ȴ���12����С��4��������
        if (len > 12 || len < 4) {
            return res;
        }
        //����һ������·���ϵı���
        Deque<String> path = new ArrayDeque<>();
        //�����������������Ϊ�����������ַ��������ȣ�0�ǿ�ʼ������4��ʣ��δ�����IP�Σ�·�������
        dfs(s, len, 0, 4, path, res);
        //���ؽ��
        return res;
    }

    public void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        //����ַ����Ѿ�����������ˣ������Ѿ��з�Ϊ4���ˣ�
        //�Ͱѵ�ǰ·���ϵ�Ԫ�ؼ��뵽���صĽ������
        if (begin == len) { // ��һ������begin�ӹ�1������=len��
            if (residue == 0) { //  IP���������ɹ���·�����뵽����У��ٷ���
                res.add(String.join(".", path));
            } // ����ֱ�ӽ���
            return;
        }
        //begin��ʾ�����ַ��������￪ʼ
        for (int i = begin; i < begin + 3; i++) {
            //��������ַ����ĳ��ȣ���ֱ���˳�
            //begin��ÿ��ѡ���Ǵ�֮ǰѡ���Ԫ�ص���һ��Ԫ�ؿ�ʼ��
            if (i >= len) {
                break;
            }
            //���ʣ��Ԫ�ش���ip��������ɵĸ������ͼ�֦��
            if (len - i > residue * 3) {
                continue;
            }
            //�жϵ�ǰ��ȡ�ַ��Ƿ���С��0���ߴ���255
            //�����begin��i��������ǣ���ʱ���ȡ�˼����ַ�
            //begin�����￪ʼ��i�����������forѭ��3�Σ�������������˽�ȡ1��2��3����
            if (judgeIpSegment(s, begin, i)) {
                // ����������������ǰ��ȡ�ַ�����Χ��[begin, end)������Ҫ+1
                String currentIpSegment = s.substring(begin, i + 1);
                // ����ǰ·���ϵ�Ԫ�ؼ��뵽·��������
                path.addLast(currentIpSegment);
                // �ݹ���һ��
                dfs(s, len, i + 1, residue - 1, path, res);
                // ���ݣ�add��һ������������remove
                path.removeLast();
            }
        }
    }
    // �ж��Ƿ��������
    private boolean judgeIpSegment(String s, int left, int right) {
        //����һ����ʾ�����ַ��ĳ���
        int len = right - left + 1;
        //�����ȡ�Ĵ��ڵ���2���ַ��Ŀ�ͷΪ0����ֱ��false
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }
        //���巵�ؽ���ļ���
        int res = 0; // ����ͬһ�����ؽ��
        //ƴ���ַ�
        while (left <= right) {
            //res*10 ��Ϊ�˽��ȼӵ��ַ�Ĭ�ϱȺ�����ַ���10����Ҳ����λ���Ǵ�С����
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }

    public static void main(String[] args) {
        String s = "1111";
        LC40400093 solution = new LC40400093();
        List<String> res = solution.restoreIpAddresses(s);
        System.out.println(res);
    }
}
