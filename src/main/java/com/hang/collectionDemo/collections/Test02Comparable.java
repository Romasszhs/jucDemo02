package com.hang.collectionDemo.collections;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test02Comparable {
    //二、对于集合中的对象比较（自定义排序）
    @Test
    public void testComparable(){
        /*
         * Cell实现了Comparable接口，compareTo方法逻辑为按照x值大小进行排序
         */
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(2,3));
        cells.add(new Cell(5,1));
        cells.add(new Cell(3,2));
        System.out.println(cells);//[Cell [x=2, y=3], Cell [x=5, y=1], Cell [x=3, y=2]]
        Collections.sort(cells);
        System.out.println(cells);//[Cell [x=2, y=3], Cell [x=3, y=2], Cell [x=5, y=1]]

        /*我们想使用sort方法排序集合，但是该方法要求我们的集合元素必须实现Comparable接口并且定义比较规则，
        这种我们想使用某个功能，而它要求我们修改程序的现象称为“侵入性”。修改的代码越多，侵入性比较强，越不利于程序的扩展。
        所以不建议使用这个构造方法。*/
    }
}
