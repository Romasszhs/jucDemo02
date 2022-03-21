package com.hang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author: hangshuo
 * @date: 2021/12/28 18:29
 * @Description:
 */

public class StringArrayToJson {

    public static void main(String[] args) throws JsonProcessingException {
        String[] strarray = new String[]{
                "abc","def","hij"
        };
        String[] strarray1 = new String[]{
                "opq","rst","uvw"
        };
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(strarray);
        System.out.println(strarray.toString());

        System.out.println(jsonStr);
    }
}
