package com.hang.lombok;

/**
 * @author: hangshuo
 * @date: 2021/05/19 15:24
 * @Description:
 */

public class Test {
    public static void main(String[] args) {
        StudentBean studentBean = StudentBean.of("ly",23);

        System.out.println(studentBean.getAge());

        System.out.println(studentBean.getName());

        //System.out.println(StudentBean.builder().name("ly").age(22).build());
        int i = (int) 10.5;

        System.out.println(i);// 10
    }
}
