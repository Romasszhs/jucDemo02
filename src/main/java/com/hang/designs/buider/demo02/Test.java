package com.hang.designs.buider.demo02;

public class Test {
    public static void main(String[] args) {
        //服务员
        Worker worker = new Worker();
        Product product = worker.getProduct();


        System.out.println(product.toString());

        System.out.println("=============================================");
        //我们配置的产品套餐中每个位置A、B、C和D均有默认值
        //但是可以通过buildA等等方法进行自定义修改
        //链式编程
        Worker worker1 = new Worker();
        Product product1 = worker1.buildA("麦乐鸡").getProduct();
        System.out.println(product1.toString());

    }
}
