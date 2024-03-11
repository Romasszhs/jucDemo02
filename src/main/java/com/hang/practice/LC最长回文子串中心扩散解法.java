package com.hang.practice;

import sun.security.util.Length;

/**
 * 只有 s[i+1:j−1]s[i+1:j-1]s[i+1:j−1] 是回文串，并且 sss 的第 iii 和 jjj 个字母相同时，s[i:j]s[i:j]s[i:j] 才会是回文串。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring/solutions/255195/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author: hangshuo
 * @date: 2023/12/29 15:04
 * @Description:
 */

public class LC最长回文子串中心扩散解法 {
    public static void main(String[] args) {
        LC最长回文子串中心扩散解法 solution = new LC最长回文子串中心扩散解法();
        String str = solution.longiestSubString("fffababaccc");
        System.out.println(str);
    }

    public String longiestSubString(String s){
        int length = s.length();
        if (s==null || length<1){
            return "";
        }
        int start = 0;
        int end = 0;
        int maxLen =1;
        int begin = 0;

        for (int i = 0; i < length; i++) {
            // 回文长度为奇数的情况
            int len1 = expandAroundCenter(s,i,i);
            // 回文串长度为偶数的情况
            int len2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(len1, len2);
            if (len> end - start){
                // 计算起始点 和 终点
                start = i - (len -1 )/2;
                end = i + len/2;
            }

        }


        return s.substring(start,end +1);
    }

    public int expandAroundCenter(String s,int left ,int right){
        // 要求 左右都不超出边界情况
        while(left>=0 && right< s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        // 目前的left和right是大了一圈的 回文
        // L = j-i+1 由于大了一圈  需要 -2

        return right - left-1;
    }
}
