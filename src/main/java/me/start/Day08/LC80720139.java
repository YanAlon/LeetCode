package me.start.Day08;

import javax.xml.soap.SAAJResult;
import java.util.List;

/**
 * 139. ���ʲ��
 * ����һ���ַ��� s ��һ���ַ����б� wordDict ��Ϊ�ֵ䡣
 * �����ж��Ƿ���������ֵ��г��ֵĵ���ƴ�ӳ� s ��
 * ע�⣺��Ҫ���ֵ��г��ֵĵ���ȫ����ʹ�ã������ֵ��еĵ��ʿ����ظ�ʹ�á�
 * ʾ�� 1��
 * ����: s = "leetcode", wordDict = ["leet", "code"]
 * ���: true
 * ����: ���� true ��Ϊ "leetcode" ������ "leet" �� "code" ƴ�ӳɡ�
 */
public class LC80720139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true; // ���ַ�������ҪwordDict����ƥ��ɹ�
        for (int i = 0; i <= len; i++) {
            if (!dp[i]) { // dpֻ����ÿһ��word���ȵĽ���Ϊtrue���м�ľ�ֱ�������ͺ�
                continue;
            }
            for (String word : wordDict) {
                if (s.startsWith(word, i)) { // ���s�ַ����Ƿ�����word�ӵ�iλ��ʼ
                    dp[i + word.length()] = true;
                }
            }
            if (dp[len] == true) {
                break;
            }
        }
        return dp[len];
    }
}
