package com.hang.practice;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: hangshuo
 * @date: 2024/01/02 14:11
 * @Description:
 */

public class HJ10字符个数去重统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        HashSet<Character> sets = new HashSet<>();
        for (int i = 0; i < next.length(); i++) {
            sets.add(next.charAt(i));
        }
        System.out.println(sets.size());
    }
}
