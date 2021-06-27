package com.hang.collectionDemo.collections;

import java.util.HashSet;

public class demo02 {
    public static void main(String[] args) {

        HashSet<Person> lists2 = new HashSet<Person>();
        Person person1 = new Person();
        person1.setId(1);
        Person person2 = new Person();
        person2.setId(2);

        lists2.add(person1);
        lists2.add(person2);

        for (Person person : lists2) {
            System.out.println(person);
        }

    }
}
