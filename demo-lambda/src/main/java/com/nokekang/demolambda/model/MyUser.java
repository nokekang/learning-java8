package com.nokekang.demolambda.model;

import lombok.Data;

/**
 * @program: learning-java8
 * @description: MyUser
 * @author: sunjiankang
 * @create: 2019-06-29 20:19
 **/
@Data
public class MyUser {
    private String userName;
    private Integer age;

    public MyUser(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public MyUser() {

    }

    @Override
    public String toString() {
        return "MyUser{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

}
