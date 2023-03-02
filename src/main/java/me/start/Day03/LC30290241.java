package me.start.Day03;

import java.util.ArrayList;
import java.util.List;

/*
 * 241. 为运算表达式设计优先级
 * 给你一个由数字和运算符组成的字符串 expression ，
 * 按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
 * 示例 1：
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 */


public class LC30290241 {
    // 1.分解：按运算符分成左右两部分，分别求解
    // 2.解决：实现一个递归函数，输入算式，返回算式解
    // 3.合并：根据运算符合并左右两部分的解，得出最终解
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
        int len = expression.length();
        int start = 0;
        for (start = 0; start < len; start++) {
            //找到一个运算符，控制递归
            if(Character.isDigit(expression.charAt(start))) continue;
            else break;
        }

        //没找到等于字符串里没有运算符，那直接返回对应数字结果
        if (start == len) list.add(Integer.parseInt(expression));

        for (int i = start; i < len; i++) {
            if (Character.isDigit(expression.charAt(i))) continue;
            char op = expression.charAt(i);
            //1.用该运算符分隔成 左边的字符串 和 右边的字符串
            //2.左边的字符串再递归继续求得 数字结果集
            List<Integer> left = diffWaysToCompute(expression.substring(0, i));
            //2.右边的字符串再递归继续求得 数字结果集
            List<Integer> right = diffWaysToCompute(expression.substring(i + 1, len));

            //3.从左右两个求得数字结果集里拿出数字，基于当前运算符运算完 ，添加进最终list，得到最终数字结果集
            for (int j : left) {
                for (int k : right) {
                    if (op == '+') list.add(j + k);
                    else if (op == '-') list.add(j - k);
                    else if (op == '*') list.add(j * k);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "2-1-1";
        List<Integer> b = diffWaysToCompute(s);
        System.out.println(b);
    }
}
