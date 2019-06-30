package com.nokekang.demolambda.test;

import com.nokekang.demolambda.interf.MyPredicate;
import com.nokekang.demolambda.model.MyUser;
import com.nokekang.demolambda.model.MyUserVo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @program: learning-java8
 * @description: lambdaTest1
 * @author: sunjiankang
 * @create: 2019-06-29 18:01
 **/
public class LambdaTest1 {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test4() {
        Function<String, Integer> stringIntegerIntegerBiFunction = Integer::parseInt;
        Integer apply = stringIntegerIntegerBiFunction.apply("100");
        System.out.println(apply);
        Integer apply1 = stringIntegerIntegerBiFunction.apply("1000");
        System.out.println(apply1);
    }

    private static void test3() {
        // 将一个list转成另外一个list
        List<MyUser> userList = new ArrayList();
        userList.forEach((MyUser mu) -> {
            mu.getAge();
        });
        userList.add(new MyUser("张三", 18));
        userList.add(new MyUser("李四", 19));
        userList.add(new MyUser("王五", 20));

        // 行为参数化的方式看似比下面的传统方法要麻烦一点,但是主要作用是拓展性,定义了一个map方法,所有的list都能用
        List<MyUserVo> map = map(userList, (MyUser u) -> {
            MyUserVo myUserVo = new MyUserVo();
            myUserVo.setVoUserName(u.getUserName());
            myUserVo.setVoAge(u.getAge());
            try {
                // 异常不能抛,只能trycatch处理
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return myUserVo;
        });

        /*List<MyUserVo> myUserVos = new ArrayList<>();
        for (MyUser myUser : userList) {
            MyUserVo myUserVo = new MyUserVo();
            myUserVo.setVoUserName(myUser.getUserName());
            myUserVo.setVoAge(myUser.getAge());
            myUserVos.add(myUserVo);
        }*/

        for (MyUserVo myUserVo : map) {
            System.out.println(myUserVo);
        }

    }
    private static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }


    private static void test2() {
        Comparator<String> comparator = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };

        Comparator<String> comparator2 = (String s1, String s2) -> s1.compareTo(s2);

        MyPredicate<String> p1 = (String ps1) -> ps1.equals("green");
    }

    private static void test1() {
        new Thread(() -> System.out.println("thread1")).run();
        try {
            String s = new FutureTask<>(() -> "thread2").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
