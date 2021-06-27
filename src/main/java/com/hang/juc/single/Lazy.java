package com.hang.juc.single;

public class Lazy {
    private String str;
    private int a;

    private Lazy(){
        System.out.println(Thread.currentThread().getName());

        this.str="nihao";
        this.a = 20;
    }

    private volatile static Lazy lazy = null;

    //双重检测锁模式的double check lock    懒汉式单例     DCL懒汉式
    public static Lazy getInstance(){
        if (lazy == null){
            synchronized (Lazy.class){
                if (lazy==null){
                    lazy = new Lazy(); // 不是原子性操作
                    /*
                    * 1.分配内存空间
                    * 2.执行构造方法，初始化对象  赋值操作
                    * 3.把这个对象指向这个空间
                    *
                    *  123  是我们理解的顺序
                    *  但也有可能  132  线程A  对象lazy已经在内存堆中存在
                    *  线程B去读数据的时候可能还没完成构造，导致数据丢失
                    *        这里还要补充一个知识点，就是java中某个线程在访问堆中的线程共享变量时，
                    *        为了加快访问速度，提升效率，会把该变量临时拷贝一份到自己的VM Stack中，
                    *        并保持和堆中数据的同步。由此导致线程B可能会读到堆中的数据并没被线程A操作完成，
                    *        假设对象中有一个String变量和int变量，可能线程A在进行初始化时，只对str进行赋值，
                    *        还没来得及对a进行赋值，假如jvm将未完成赋值操作的值拷贝回堆中，这个时候线程B就可能读到
                    *        的对象值就不是null，会读取对象内容，直接进行取对象的操作，导致数据丢失。线程B获取的a的值是0，不是20。
                    *
                    * 通过添加volatile到对象上  不允许指令重排
                    * 对volatile字段的写操作happen-before后续的对同一个字段的读操作.
                    * */
                }
            }
        }

        return lazy;
    }

    //单线程下可以  只有一个对象被创建
    //多线程并发下 不安全
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println((Lazy.getInstance().a + Lazy.getInstance().str));
            }).start();
        }
    }

    /*
    * java中某个线程在访问堆中的线程共享变量时，为了加快访问速度，提升效率，会把该变量临时拷贝一份到自己的VM Stack中，并保持和堆中数据的同步。
    *
    * */
}
