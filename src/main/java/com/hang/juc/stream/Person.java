package com.hang.juc.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: hangshuo
 * @date: 2021/06/11 14:06
 * @Description:
 */

@Data
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    private String gender;
}
