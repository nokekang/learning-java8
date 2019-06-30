package com.nokekang.demolambda.utils;

import com.nokekang.demolambda.model.MyUser;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: learning-java8
 * @description: 工具类
 * @author: sunjiankang
 * @create: 2019-06-30 15:55
 **/
public class DomainUntil {
    public static List<MyUser> myUserList = new ArrayList<>();
    static {
        myUserList.add(new MyUser("张三", 18));
        myUserList.add(new MyUser("李四", 19));
        myUserList.add(new MyUser("王五", 20));
        myUserList.add(new MyUser("王五", 20));
        myUserList.add(new MyUser("赵六", 25));
        myUserList.add(new MyUser("马七", 29));
        myUserList.add(new MyUser("钱八", 24));
    }

}
