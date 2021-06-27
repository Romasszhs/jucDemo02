package com.hang.collectionDemo.collections;

/*
* *  实际上，在使用Collection的sort排序的集合元素都必须是Comparable接口的实现类，该接口
     *  表示子类是可以比较的。
     *  因为实现接口必须重写抽象方法。
     *    - int compareTo(T t);
     *    该方法用于使当前对象与给定对象进行比较。
     *    返回值为一个int值，该值表示大小关系，它不关注具体的取值是多少，而关注的是取值范围。
     *    当返回值>0时：当前对象比参数对象大
     *    当返回值<0时：当前对象比参数对象小
    *    当返回值=0时：当前对象等于参数对象
    * */

//Cell类：
public class Cell implements Comparable<Cell>{//哪个类实现Comparable接口泛型就写哪个类
    private  int x;
    private  int y;
    public Cell(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }
    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return "Cell [x=" + x + ", y=" + y + "]";
    }
    @Override
    public int compareTo(Cell o) {//自定义排序逻辑
        // TODO Auto-generated method stub
        return this.x-o.x;//以传入的Cell的横坐标由小到大进行排序
    }

}

