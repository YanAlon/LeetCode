package me.start.Day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 279. ��ȫƽ����
 * ����һ������ n ������ ��Ϊ n ����ȫƽ�������������� ��
 * ��ȫƽ���� ��һ����������ֵ������һ��������ƽ����
 * ���仰˵����ֵ����һ�������Գ˵Ļ������磬1��4��9 �� 16 ������ȫƽ�������� 3 �� 11 ���ǡ�
 * ʾ�� 1��
 * ���룺n = 12
 * �����3
 * ���ͣ�12 = 4 + 4 + 4
 */
public class LC70610279 {
    // 1����1��ʼ��������
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // ������������Ӧ
        for (int i = 1; i <= n; i++) { // ��2��ʼ����ȫƽ�����ۼ����ֵ
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) { //
                // �����õķ����Ǵ�1��ʼ�����ۼӼ�������ȫƽ�����͵����ֵ��һֱ�㵽Ŀ����
                // dp[i - j * j] + 1 ���Ƽ�ȥ�µ���ȫƽ��������������������ȫƽ��������
                // �͵��ڼ�ȥ��ʣ������dp�ټ��������ȫƽ��������+1
                // ����7����ѭ����7-2*2��Ҳ����dp[7]=dp[7-2*2]+1,���1����2*2��4������
                // ���ԣ����7����ȫƽ��������7=4+dp[3]�ģ�Ҳ����7=4+1+1+1��
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                System.out.println("i:" + i + "dp[i]:" + dp[i]);
            }
        }
        return dp[n];
    }

    // 2��github Ԥ�������ƽ����
    public int numSquares02(int n) {
        // ����ƽ�����б�
        List<Integer> squareList = generateSquareList(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // ������������ѭ����
            for (int square : squareList) {
                if (square > i) {
                    break;
                }
                min = Math.min(min, dp[i - square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    private List<Integer> generateSquareList(int n) {
        List<Integer> squareList = new ArrayList<>();
        int diff = 3;
        int square = 1;
        while (square <= n) {
            squareList.add(square);
            square += diff;
            diff += 2;
        }
        return squareList;
    }

    // 3����ѧ������ƽ���Ͷ���

    /**
     * ��ƽ���Ͷ���֤��������һ�������������Ա���ʾΪ�����ĸ���������ƽ���͡�������˱���Ĵ𰸵��Ͻ硣
     * ͬʱ��ƽ���Ͷ��������һ����ǿ�Ľ��ۣ����ҽ��� n �� 4^k * (8m + 7) ʱ��
     * n ���Ա���ʾΪ����������������ƽ���͡���ˣ��� n = 4^k * (8m + 7) ʱ��
     * n ֻ�ܱ���ʾΪ�ĸ���������ƽ���͡���ʱ���ǿ���ֱ�ӷ���4��
     * �� n �� 4^k * (8m + 7) ʱ��������Ҫ�жϵ��׶��ٸ���ȫƽ�����ܹ���ʾ n��
     * ����֪����ֻ���� 1��2��3 �е�һ����
     * ��Ϊ 1 ʱ������� n Ϊ��ȫƽ��������ܺ��жϣ�
     * ��Ϊ 2 ʱ������ n = a^2 + b^2������ֻ��Ҫö�����е� a (1 <= a <= sqrt(a))��
     * �ж� n - a^2 �Ƿ�Ϊ��ȫƽ�������ɣ�
     * ��Ϊ 3 ʱ�����Ǻ�����һ�������ʱ�临�Ӷ��ڽ������
     * ������ֻ��Ҫ����Ϊ 1 �� 2 ��������������������ų���ȷ���𰸡�
     * @param n
     * @return
     */

    public int numSquares03(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // �ж��Ƿ�Ϊ��ȫƽ����
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // �ж��Ƿ��ܱ�ʾΪ 4^k*(8m+7)
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }

    public static void main(String[] args) {
        int n = 12;
        LC70610279 solution = new LC70610279();
        int res = solution.numSquares(n);
        int res02 = solution.numSquares02(n);
        int res03 = solution.numSquares03(n);
        System.out.println(res);
        System.out.println(res02);
        System.out.println(res03);
    }
}
