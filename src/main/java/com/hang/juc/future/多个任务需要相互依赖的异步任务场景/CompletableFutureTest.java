package com.hang.juc.future.多个任务需要相互依赖的异步任务场景;

import sun.plugin2.ipc.Event;

import java.util.concurrent.*;

/**
 * @author: hangshuo
 * @date: 2021/05/24 18:01
 * @Description:
 */

public class CompletableFutureTest {


    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 100, TimeUnit.SECONDS, new SynchronousQueue<>());


        // 任务一
        CompletableFuture<String> orderAirplane = CompletableFuture.supplyAsync(()->{
            System.out.println("查询航班");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("订购航班");
            return "航班信息";
        }, Executors.newFixedThreadPool(10));
        //任务二
        CompletableFuture<String> orderHotel = CompletableFuture.supplyAsync(() -> {
            System.out.println("查询酒店");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("酒店订购");
            return "酒店信息";
        },threadPoolExecutor);

        //任务三需要在任务一和任务二结束后执行
        CompletableFuture<String> orderCar = orderHotel.thenCombine(orderAirplane,(hotel,airplane)->{
            System.out.println(airplane+"---------"+hotel);

            System.out.println("根据航班信息和酒店信息订购租车服务");
            sleep(3,TimeUnit.SECONDS);
            return "租车信息";

        });

        //boolean b = orderCar.completeExceptionally(new Exception());
        //System.out.println(b);
        CompletableFuture<String> handle = orderCar.handle((carxinxi, e) -> {
            if (e != null) {
                System.out.println("抛出异常" + e.getMessage());
            }

            System.out.println("任务执行的结果:" + carxinxi);
            return carxinxi;
        });
        System.out.println(handle.get());



        //System.out.println(orderCar.join());
        //System.out.println(orderCar.get());
    }

    static void sleep(int time,TimeUnit timeUnit){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
