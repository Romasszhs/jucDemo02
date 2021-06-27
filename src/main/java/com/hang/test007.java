package com.hang;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test007 {
    public static  int PI = 1;

    public static void main(String[] args) {
        String  str = "ajflkdjaabbbfioqjjiaoojadfq";
        Set<Character> set = new HashSet<>();
        Map map = new HashMap<>();
        int MaxTime = 0;

        System.out.println(str);
        char[] chars = str.toCharArray();
        PI = 4;
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        for (Character character : set) {
            System.out.print( character + " ");
        }
        System.out.println("");
        Object[] objects =set.toArray();

        for (Object object : objects) {
            Character c = (Character) object ;
            int times = getTimes(c, chars);
            if (times>MaxTime){
                MaxTime=times;
            }
            map.put(c,times);

        }
        for (Character character : set) {
            Object o = map.get(character);
            int i = Integer.parseInt(o.toString());
            if (MaxTime==i){
                System.out.println(character + "出现的次数为："+i);
            }
        }

        System.out.println(MaxTime);

    }

    // 统计每一个字符出现的次数
    public static int getTimes(char c,char[] srcChars){
        int times = 0 ;
        for (int i = 0; i < srcChars.length; i++) {
            if (c==srcChars[i]){
                times++;
            }
        }

        return times;
    }
}
