package com.hang.practice;

import java.util.*;

/**
 * @author: hangshuo
 * @date: 2024/01/02 11:58
 * @Description:
 */

public class HJ3明明的随机数 {
    public static void main(String[] args) {
        HJ3明明的随机数 random = new HJ3明明的随机数();
        List<Integer> mingming = random.mingming();
        mingming.forEach(System.out::println);
    }

    public List<Integer> mingming( ){
        int[] result = new int[]{};
        Scanner in = new Scanner(System.in);
        HashSet<Integer> sets = new HashSet<Integer>();

        // 注意 hasNext 和 hasNextLine 的区别
        int num = 0;
        boolean first = true;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            if (first){
                num = in.nextInt();
                break;
            }

        }
        int j = 0;
        if (num!=0) {
            for (int i = 0; i < num; i++) {
                int a = in.nextInt();
                boolean add = sets.add(a);
                j++;
                if (j == i){
                    break;
                }
            }

        }
        Iterator<Integer> iterator = sets.iterator();
        ArrayList<Integer> integers = new ArrayList<>();
        while (iterator.hasNext()){
            integers.add(iterator.next());
        }

        Collections.sort(integers);
        integers.forEach(System.out::println);

        return integers;
    }
}
