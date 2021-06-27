package com.hang.designs.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//通过反射 获取泛型的信息 泛型的类型
public class Test06 {

    @Deprecated
    public void test01(Map<String,User> map, List<User> list , int i){
        System.out.println("test01");
    }

    public Map<String,User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws Exception {
        Method method = Test06.class.getMethod("test01", Map.class, List.class,int.class);
        /*
        Annotation annotation = method.getAnnotation(Deprecated.class);
        System.out.println(annotation);
        */

        Type[] genericParameterTypes = method.getGenericParameterTypes();

        for (Type genericParameterType : genericParameterTypes) {
            System.out.println(genericParameterType);

            //只有带泛型的参数才是这种Type，所以得判断一下
            if (genericParameterType instanceof ParameterizedType){
                ParameterizedType parameterizedType = (ParameterizedType)genericParameterType;
                //获取参数的类型
                System.out.println(parameterizedType.getRawType());
                // System.out.println(parameterizedType.getOwnerType());


                //获取参数的泛型列表
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
            System.out.println("-----------------------");
        }
        //getGenericParameterTypes被用来获取参数的类型，包括泛型信息
        //getGenericReturnType被用来获取返回值的类型，包括泛型信息
        method = Test06.class.getMethod("test02");
        Type genericReturnType = method.getGenericReturnType();
        System.out.println(genericReturnType);

        //只有带泛型的参数才是这种Type，所以得判断一下
        if (genericReturnType instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
            System.out.println(parameterizedType.getRawType());
            // System.out.println(parameterizedType.getOwnerType());

            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
    }

}
