package com.hang.practice;

/**
 * @author: hangshuo
 * @date: 2021/05/09 17:25
 * @Description:
 */

public class TypeTest {
    public static void main(String[] args) {
        int i = 10;
        long l = 10L;
        long l1 = i + l;
        // 隐形转换 向空间大的基本数据类型转换
        // ==符号运算中，其中一方的类型为基本数据类型时，进行的比较也是基本类型的值比较
        // 当基本类型封装类遇到运算时，需要拆箱转换来进行基本数据类型计算，如果是在==表达式的一边，则不会自动装箱回去。
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
        System.out.println(g.equals(a+h));
        //true
        //false
        //true
        //true
        //true
        //false
        //true

        // 当 "=="运算符的两个操作数都是 包装器类型的引用，则是比较指向的是否是同一个对象，
        // 而如果其中有一个操作数是表达式（即包含算术运算）则比较的是数值（即会触发自动拆箱的过程）。
        // 另外，对于包装器类型，equals方法并不会进行类型转换。
        // 第一个和第二个输出结果没有什么疑问。第三句由于  a+b包含了算术运算，因此会触发自动拆箱过程（会调用intValue方法），
        // 因此它们比较的是数值是否相等。而对于c.equals(a+b)会先触发自动拆箱过程，再触发自动装箱过程，也就是说a+b，
        // 会先各自调用intValue方法，得到了加法运算后的数值之后，便调用Integer.valueOf方法，再进行equals比较。
        // 同理对于后面的也是这样，不过要注意倒数第二个和最后一个输出的结果（如果数值是int类型的，
        // 装箱过程调用的是Integer.valueOf；如果是long类型的，装箱调用的Long.valueOf方法）。
    }
}
