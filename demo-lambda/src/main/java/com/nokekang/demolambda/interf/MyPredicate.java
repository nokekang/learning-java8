package com.nokekang.demolambda.interf;

/**
 * @program: learning-java8
 * @description: lambda测试接口
 * @author: sunjiankang
 * @create: 2019-06-29 18:31
 **/
public interface MyPredicate<T> {
    boolean isGreen(T t);
//    Integer length(T t);
    String toString();
}

