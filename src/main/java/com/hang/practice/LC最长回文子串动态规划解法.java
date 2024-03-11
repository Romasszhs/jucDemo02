package com.hang.practice;

/**
 * @author: hangshuo
 * @date: 2023/12/29 14:23
 * @Description:
 */

public class LC最长回文子串动态规划解法 {
    public static void main(String[] args) {
        LC最长回文子串动态规划解法 solution = new LC最长回文子串动态规划解法();
        String str = solution.logiestSubString("fffababaccc");
        System.out.println(str);
    }

    public String logiestSubString(String s){
        int length = s.length();
        if (length<2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        // 新建一个二维数组来记录 ，从i点到j点的长度字符串是否是回文字符串
        boolean[][] dp = new boolean[length][length];

        // 只有自己的字符必定是回文
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        // 假设回文长度从2开始往多的值找
        char[] chars = s.toCharArray();

        for (int L = 2; L <= length; L++) {
            // 从左边界开始定位找该长度下的子字符是否为回文
            for (int i = 0; i < length; i++) {
                // 从确定的长度和确定的起始左边界可以确定右边界的值具体为多少
                // j-i +1 = L
                int j = L+i-1;
                if (j >length-1){
                    break;
                }
                if (chars[i] == chars[j]){
                    // 判断长度是否大于2   可以确定为长度小于3
                    if (j-i+1 < 3){
                        dp[i][j] = true;
                    }else {
                        // 否则取决于小一环的值是否为true，既小一环的是否是回文
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else {
                    dp[i][j] = false;
                }
                // 判断是否该i到j距离的字符是否回文，并且符合大于maxLen，目前已知最大的回文串长度
                if (dp[i][j] && j-i+1> maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }

        return s.substring(begin,begin+maxLen);
    }
}
