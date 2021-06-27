package com.hang.juc.function;

import java.util.function.Supplier;

// Supplier 供给型接口
public class Demo04 {
    public static void main(String[] args) {
        Supplier<Integer> supplier = ()->{
            System.out.println("get");
            return 1024;
        };

        System.out.println(supplier.get());
    }
}
