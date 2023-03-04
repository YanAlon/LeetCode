package me.start.Day06;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 131. �ָ���Ĵ�
 * ����һ���ַ��� s�����㽫 s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����� ���Ĵ� ��
 * ���� s ���п��ܵķָ����
 * ���Ĵ� �����Ŷ��ͷ��Ŷ���һ�����ַ�����
 * ʾ�� 1��
 * ���룺s = "aab"
 * �����[["a","a","b"],["aa","b"]]
 */
public class LC60510131_0 {
    // 1�������Ż�+��̬�滮�ģ�û����
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // ���ַ���ת��Ϊ�ַ�char���飬�������
        char[] charArray = s.toCharArray();
        // Ԥ����
        // ����״̬��
        boolean[][] dp = new boolean[len][len];
        // ״̬ת�Ʒ���
        // ��s[i] == s[j]ʱ��dp[i][j]�ο�dp[i+1][j-1]
        for (int right = 0; right < len; right++) {
            // ע�⣺left <= right��ȡ��=�Ⱥţ���Ϊֻ��1���ַ���ʱ��ҲҪ�ж�
            for (int left = 0; left <= right; left++) {
                System.out.println(left + " : " + right);
                System.out.println(charArray[left] + " : " + charArray[right]);
                if (charArray[left] == charArray[right] &&
                        (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        Deque<String> stack = new ArrayDeque<>();
        dfs(s, 0, len, dp, stack, res);
        return res;
    }

    private void dfs(String s, int index, int len, boolean[][] dp,
                     Deque<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            if (dp[index][i]) { // ����ǻ��ģ�������ȡ����������һ��
                path.addLast(s.substring(index, i + 1));
                dfs(s, i + 1, len, dp, path, res);
                path.removeLast();
            }
        }
    }

    // ������ʹ��������չ��Ԥ����
    public List<List<String>> partition02(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        // ʹ�ö�̬�滮��¼����
        boolean[][] dp = new boolean[len][len];
        // Ԥ����
        for(int i = 0; i < len; i++){
            prePro(s, i, i, dp);
            prePro(s, i, i + 1, dp);
        }
        // ����� ·���� �ַ�����������·���滮���Ƿ��ǻ��ģ�
        helper(res, new ArrayList<>(), s, 0, dp);
        return res;
    }

    //����Ԥ��������������չ �����л����Ӵ���λ�ô洢�� dp ��
    private void prePro(String s, int left , int right, boolean[][] dp){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            dp[left][right] = true;
            // ������չ�������߱���
            left--;
            right++;
        }
    }

    private void helper(List<List<String>> res, List<String> list, String s,
                        int index, boolean[][] dp){
        if(index == s.length()){
            System.out.println("add");
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < s.length(); i++){
            System.out.println("for i : " + i);
            System.out.println("index : " + index);
            //����Ԥ�������Ͳ�����ȥ�жϸ��ַ����Ƿ��ǻ��Ĵ�
            if(!dp[index][i]){
                System.out.println("false");
                continue;
            }
            list.add(s.substring(index, i + 1));
            helper(res, list, s, i + 1, dp);
            System.out.println("dfs i : " + i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        LC60510131_0 solution = new LC60510131_0();
        List<List<String>> res = solution.partition02(s);
        System.out.println(res);
    }
}










