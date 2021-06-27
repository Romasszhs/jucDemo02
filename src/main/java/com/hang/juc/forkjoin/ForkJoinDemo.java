package com.hang.juc.forkjoin;


import java.util.concurrent.RecursiveTask;

/*
* 求和计算
* 3000 6000（ForkJoin）  9000（Stream并行流）
*
* */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private long start;
    private long end;

    //临界值
    private long temp = 200L;

    public ForkJoinDemo(long start,long end){
        this.start = start;
        this.end = end;
    }

    //计算的返回值就是答案
    @Override
    protected Long compute() {
        if ((end-start)<temp){
            //值的区间不超过一万，所以使用普通的方式计算
            System.out.println("开始计算：start:"+start+"\t"+"end:"+end);
            long sum = 0L;
            for (long i = start; i < end; i++) {
                sum +=i;
            }
            return sum;
        }else{
            //分支合并计算
            long middle = (start+end) / 2;
            System.out.println(String.format("split %d~%d ==> %d~%d,%d~%d",start,end,start,middle,middle+1,end));
            ForkJoinDemo task01 = new ForkJoinDemo(start, middle);
            task01.fork(); //拆分任务，把任务压入线程队列
            ForkJoinDemo task02 = new ForkJoinDemo(middle + 1, end);
            task02.fork(); //拆分任务，把任务压入线程队列

            return  task01.join() + task02.join();
        }
    }
}
