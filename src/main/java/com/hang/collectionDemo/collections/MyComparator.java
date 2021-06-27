package com.hang.collectionDemo.collections;


//测试代码：
//自定义的比较器：
import java.util.Comparator;

public class MyComparator implements Comparator<Cell>{
    @Override
    public int compare(Cell o1, Cell o2) {
        return o1.getY()-o2.getY();//根据传入的cell的y坐标由小到大进行排序
    }
}


