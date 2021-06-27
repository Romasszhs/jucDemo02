package com.hang.collectionDemo.collections;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
* 比较总结：
* *1.对于集合比较使用Collections.sort();
* *2.对于集合中的对象比较，需要指定比较逻辑，指定比较逻辑需要实现 Comparable接口并重写compareTo方法自定义逻辑。
* *3.对于需要临时改变比较规则，需要使用Collections.sort(List,Comparator),采用回调方式重写Comparator接口的compare方法自定义逻辑。
* */


public class Test03Comparator {

    //三、使用重载的Collections.sort(List,Comparator)方法
    //测试类：
    @Test
    public void testComparator() {
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(2,3));
        cells.add(new Cell(5,1));
        cells.add(new Cell(3,2));
        System.out.println(cells);//[Cell [x=2, y=3], Cell [x=5, y=1], Cell [x=3, y=2]]
        MyComparator com = new MyComparator();
        Collections.sort(cells,com);
        System.out.println(cells);//根据自定义排序后的结果：[Cell [x=5, y=1], Cell [x=3, y=2], Cell [x=2, y=3]]
    }

    @Test
    public void testComparator1() {
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(2,3));
        cells.add(new Cell(5,1));
        cells.add(new Cell(3,2));
        System.out.println(cells);//[Cell [x=2, y=3], Cell [x=5, y=1], Cell [x=3, y=2]]
        Collections.sort(cells,new Comparator<Cell>(){//此处创建了一个匿名内部类
            @Override
            public int compare(Cell o1,Cell o2){
                return o1.getY() - o2.getY();
            }

        });
        System.out.println(cells);//[Cell [x=5, y=1], Cell [x=3, y=2], Cell [x=2, y=3]]
    }




}
