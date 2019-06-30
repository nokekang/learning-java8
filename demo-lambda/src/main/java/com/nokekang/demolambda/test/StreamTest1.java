package com.nokekang.demolambda.test;

import com.nokekang.demolambda.model.MyUser;
import com.nokekang.demolambda.utils.DomainUntil;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: learning-java8
 * @description: 流测试
 * @author: sunjiankang
 * @create: 2019-06-30 19:32
 **/
public class StreamTest1 {
    public static void main(String[] args) {
//        test1();
//        test2();

        MyUser myUser = new MyUser("zhangsan", 18);
        MyUser myUser2 = new MyUser("zhangsan", 18);
        BiPredicate<MyUser, MyUser> p = (u1, u2) -> u1.equals(u2) ;
        System.out.println(p.test(myUser, myUser2));
    }

    private static void test2() {
        List<MyUser> myUserList = DomainUntil.myUserList;
        List<String> collect = myUserList.stream()
                .filter(u -> u.getAge() > 18)
                .distinct()
                .limit(4)
                .skip(2)
                .sorted(Comparator.comparing(MyUser::getAge).reversed())
                .map(MyUser::getUserName)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

    }

    private static void test1() {
        List<MyUser> muList = DomainUntil.myUserList;
        Stream<MyUser> stream = muList.stream();
        Iterator<MyUser> iterator = muList.iterator();
        while (iterator.hasNext()){
            MyUser next = iterator.next();
        }
        ListIterator<MyUser> myUserListIterator = muList.listIterator(1);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        Set<Object> objects = objectObjectHashMap.keySet();
        Set<Map.Entry<Object, Object>> entries = objectObjectHashMap.entrySet();
        HashSet<Object> objects1 = new HashSet<>();
    }
}
