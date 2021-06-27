package com.hang.lambda;

/**
 * @author: hangshuo
 * @date: 2021/05/10 15:54
 * @Description:
 */

public class MessageBuilderImpl implements MessageBuilder,MessageBuilder2{
    @Override
    public String buildMessage() {
        return null;
    }

    // 如果同时实现两个接口，接口中定义了一样的默认方法，则必须重写，不然会报错。
    @Override
    public void method() {

    }
}
