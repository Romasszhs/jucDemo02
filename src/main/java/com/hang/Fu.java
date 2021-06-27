package com.hang;

public class Fu extends Object {
    int id;

    // 无参构造器
    public Fu() {
    }

    // 有参构造器
    /*public Fu(int id) {
        this(id);   //报错内容-Recursive constructor invocation
    }*/

    // 有参构造器
    public Fu(int id) {
        this.id = id;
    }

    private int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {

    }

    public static void getFu(){

    }
}
