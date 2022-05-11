package com.hang.Serialization;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: hangshuo
 * @date: 2022/05/12 1:26
 * @Description:
 */

public class JSONObjectTest01 {
    public static void main(String[] args) {
        HashMap<Object, Object> map = Maps.newHashMap();
        ArrayList<Object> list = Lists.newArrayList();
        list.addAll(Arrays.asList("1","2","3"));
        map.put("rows", list);



        JSONObject obj = new JSONObject();
        obj.put("key1",map);

        HashMap key1 = (HashMap) obj.get("key1");
        List<String> rows = (List<String>) key1.get("rows");
        rows.forEach(System.out::print);

    }
}
