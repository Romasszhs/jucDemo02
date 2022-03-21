package com.hang.practice;

import java.util.Scanner;

public class practice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            char a =scanner.next().charAt(0);
            if (a=='a'|| a=='o'|| a=='e'||a=='i'||a=='u'){
                System.out.println("你输入的字母是元音:"+a);
            }else{
                System.out.println("你输入的字母是辅音："+a);
            }
        } while (true);
    }
}
