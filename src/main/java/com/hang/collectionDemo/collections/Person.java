package com.hang.collectionDemo.collections;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends Object implements Comparable<Person>{
    private  int id;
    private String name;
    private boolean sex;

    @Override
    public int compareTo(Person o) {
        return o.getId()-this.id;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                sex == person.sex &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex);
    }*/
}
