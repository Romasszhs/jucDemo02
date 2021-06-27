package com.hang;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zi extends Fu {
    //  在 Java 中定义⼀个不做事且没有参数的构造⽅法的作⽤
    /*
    * 子类继承父类时，如果没有使用super()来调用父类特定的构造方法，则会调用父类中“没有参数的构造方法”。
    * 因此如果父类没有空参的构造方法，子类的编译时会报错。子类空参构造方法会调用父类空参构造方法
    * */
    int id;
    int age;

    public Zi(){
        //super();    // 调用父类构造方法（1）
    }

    public Zi(int id) {
        super(id);  // 调用父类具有相同形参的构造方法（2）
    }

    public Zi(int id,int age){
        this(id);   //调用自己的具有相同形参的构造方法 (3)
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public int getId(){
        return super.id;
    }

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new File("text.txt"))){
            while (scanner.hasNext()){
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String str ;
        // System.out.println(str);// 报错 Variable 'str' might not have been initialized
        str = null;
        System.out.println(str);// 局部变量不会自动赋值
    }
    // 父类中也存在该static同名的方法，但在子类中可以被再次声明
    public static void getFu(String str){

    }




}
