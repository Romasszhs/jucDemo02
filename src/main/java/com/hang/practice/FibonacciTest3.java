package com.hang.practice;

/**
 * @author: hangshuo
 * @date: 2021/05/11 15:31
 * @Description:
 */

public class FibonacciTest3 {
    public static void main(String[] args) {
        fib(5);
    }

    public static int fib(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = (p + q) % MOD;
            System.out.println(r);
        }
        return r;
    }

}
