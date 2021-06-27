package com.hang.juc.future.异常处理;

import java.util.concurrent.CompletableFuture;

/**
 * @author: hangshuo
 * @date: 2021/05/27 18:07
 * @Description:
 */

/*
* CompletionStage 提供几个方法，可以优雅处理异常。
* */
public class CompletableFutureException2 {
    public static void main(String[] args) {
        /*
        * exceptionally 使用方式类似于 try..catch 中 catch代码块中异常处理。
        * */
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            return "结果";
        }).exceptionally((ex) -> {
            return "异常为：" + ex.getMessage();
        });

        System.out.println(cf.join());// 输出： 结果

        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
            return 10 / 0;
        });


        /*
        * whenComplete 与 handle 方法就类似于 try..catch..finanlly 中 finally 代码块。
        * 无论是否发生异常，都将会执行的。这两个方法区别在于 handle 支持返回结果。
        * */
        CompletableFuture<Integer> cf3 = cf2.handle((integer, throwable) -> {
            if (throwable != null) {
                throwable.printStackTrace();
                return 0;
            } else {
                return integer;
            }
        });

        System.out.println(cf3.join());
    }
}
