package com.hang.fanxin;

/**
 * @author: hangshuo
 * @date: 2021/05/07 17:18
 * @Description:
 */
// 泛型类
public class Generic<T> {
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
}
