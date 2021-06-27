package com.hang.juc.single;

import java.lang.reflect.Constructor;

//懒汉式单例
public class LazyReflect {
    private String str;
    private int a ;

    // 私有构造器
    private LazyReflect(){
        synchronized (LazyReflect.class){
            System.out.println("该实例已被创建");
            if (this.lazy!=null){
                throw new RuntimeException("不要试图使用反射破坏单例");
            }
        }
        System.out.println(Thread.currentThread().getName());

        this.str="nihao";
        this.a = 20;
    }

    private volatile static LazyReflect lazy;

    //双重检测锁模式的double check lock    懒汉式单例     DCL懒汉式
    public static LazyReflect getInstance(){
        //双重检测锁模式的double check lock    懒汉式单例     DCL懒汉式
        if (lazy == null){
            //同步方法块
            synchronized (LazyReflect.class){
                if (lazy==null){
                    lazy = new LazyReflect();   // 不是原子性操作
                    /*
                    * 1.分配内存空间
                    * 2.执行构造方法，初始化对象
                    * 3.把这个对象指向这个空间
                    *
                    *  123  我们理解的顺序
                    *  但也有可能  132  线程A
                    *   也就是第三步在第二步之前执行了
                    *   线程B去读数据的时候可能还没完成构造初始化，导致数据丢失
                    *        这里还要补充一个知识点，就是java中某个线程在访问堆中的线程共享变量时，
                    *        为了加快访问速度，提升效率，会把该变量临时拷贝一份到自己的VM Stack中，
                    *        并保持和堆中数据的同步。由此导致线程B可能会读到堆中的数据并没被线程A操作完成，
                    *        假设对象中有一个String变量和int变量，可能线程A在进行初始化时，只对str进行赋值，
                    *        还没来得及对a进行赋值，假如jvm将未完成赋值操作的值拷贝回堆中，这个时候线程B就可能读到
                    *       的对象值不是null了，直接进行取对象的操作，导致数据丢失。线程B获取的a的值是0，不是20。
                    *
                    * 通过添加volatile到对象上  不允许指令重排
                    * 对volatile字段的写操作happen-before后续的对同一个字段的读操作.
                    * */
                }
            }
        }

        return lazy;
    }

    // 单线程下可以  只有一个对象被创建
    // 多线程并发下，由于存在内存指令重排导致不安全，导致单例被破坏
    //  通过加锁可以避免多个线程同时操作 对象锁
    //  使用volatile关键子可以避免指令重排
    public static void main(String[] args) throws Exception {
        //LazyReflect ins = LazyReflect.getInstance();
        //LazyReflect ins2 = LazyReflect.getInstance();
        //System.out.println(ins==ins2);
        Constructor<LazyReflect> declaredConstructor = LazyReflect.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyReflect ins3 = declaredConstructor.newInstance();
        LazyReflect ins4 = declaredConstructor.newInstance();
        //System.out.println(ins==ins3);
        //System.out.println(ins);
        //System.out.println(ins2);
        System.out.println(ins3);
        System.out.println(ins4);
        // 1.   如果没有在构造器中对反射创建单例对象进行限制就会破坏单例
        // 2.   如果在构造器中对反射创建对象进行了限制，还可以直接使用两个反射来创建两个对象，破坏单例
        // 3.   避免直接通过反射的手段创建两个对象，可以在类中添加一个成员变量作为标志位，在构造方法中进行判断。
        // 4.   在第一个通过反射创建对象后，还是可以使用反射来修改标志位，进而通过反射再创建多一个对象。

    }

    /*
    * java中某个线程在访问堆中的线程共享变量时，为了加快访问速度，提升效率，会把该变量临时拷贝一份到自己的VM Stack中，并保持和堆中数据的同步。
    *
    * */
}
