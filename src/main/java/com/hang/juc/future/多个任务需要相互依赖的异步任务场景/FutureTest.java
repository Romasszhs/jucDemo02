package com.hang.juc.future.多个任务需要相互依赖的异步任务场景;

import java.util.concurrent.*;

/**
 * @author: hangshuo
 * @date: 2021/05/24 17:31
 * @Description:
 */

public class FutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CountDownLatch countDownLatch = new CountDownLatch(2);
        Future<String> orderAirplane = executorService.submit(() -> {
            System.out.println("执行预定机票的任务");
            countDownLatch.countDown();
            return "航班号信息";
        });
        Future<String> orderHotel = executorService.submit(()->{
            System.out.println("执行预定酒店的任务");
            countDownLatch.countDown();
            return "酒店信息";
        });
        countDownLatch.await();

        Future<String> orderCar = executorService.submit(() -> {
            System.out.println("结束机票和酒店预定后，执行预定租车业务的任务");
            return "租车信息";
        });

        System.out.println(String.format("%s,%s,%s",orderAirplane.get(),orderHotel.get(),orderCar.get()));
    }
}
