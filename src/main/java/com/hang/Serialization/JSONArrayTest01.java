package com.hang.Serialization;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: hangshuo
 * @date: 2022/05/12 1:40
 * @Description:
 */

public class JSONArrayTest01 {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList();
        list.addAll(Arrays.asList("abc","123","efg","456"));
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(list);

        System.out.println(jsonArray.get(0));
        System.out.println(jsonArray.get(3));
    }
}
