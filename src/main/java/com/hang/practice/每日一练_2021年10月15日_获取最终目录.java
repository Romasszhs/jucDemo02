package com.hang.practice;

import java.util.Stack;

/**
 * @author: hangshuo
 * @date: 2021/10/15 0:48
 * @Description:
 */

public class 每日一练_2021年10月15日_获取最终目录 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/path/ceshimulu/../a/b/../../c"));
    }

    public static String simplifyPath(String path) {
        Stack<String>  stack=new Stack<String>();
        while(path.length()>0){
            int start=path.indexOf("/");
            path=path.substring(start+1); // 过滤掉 path中第一个 / 
            int end=path.indexOf("/"); // indexOf中找不内容时，会返回-1值
            if(end==-1)
                end=path.length();
            String part=path.substring(0,end); // end=0 的情况下 part为""
            path=path.substring(end); // 准备提取下一段内容的 path
            if(part.equals(".") || part.equals(""))
                continue;
            if(part.equals("..")){
                if(stack.isEmpty()==false)
                    stack.pop();
            }
            else stack.push("/"+part);
        }
        String result="";
        while(stack.isEmpty()==false){
            result=stack.pop()+result;
        }
        if(result.length()==0)
            result="/";
        return result;
    }
}
