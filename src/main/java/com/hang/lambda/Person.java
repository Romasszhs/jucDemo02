package com.hang.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: hangshuo
 * @date: 2021/04/16 21:13
 * @Description:
 */

@Data
@AllArgsConstructor
@Setter
@Getter
public class Person {
    private String name;

    private Integer age;

    public Person(String name) {
        this.name = name;
    }
}
