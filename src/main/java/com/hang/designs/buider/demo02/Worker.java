package com.hang.designs.buider.demo02;

//具体的建造者
public class Worker extends Builder  {
    private Product product;

    public Worker(){
        //我们配置的产品套餐中每个位置A、B、C和D均有默认值
        //但是可以通过buildA等等方法进行自定义修改
        product = new Product();
    }


    @Override
    Builder buildA(String msg) {
        product.setBuildA(msg);
        return this;
    }

    @Override
    Builder buildB(String msg) {
        product.setBuildB(msg);
        return this;
    }

    @Override
    Builder buildC(String msg) {
        product.setBuildC(msg);
        return this;
    }

    @Override
    Builder buildD(String msg) {
        product.setBuildD(msg);
        return this;
    }

    @Override
    Product getProduct() {
        return product;
    }
}
