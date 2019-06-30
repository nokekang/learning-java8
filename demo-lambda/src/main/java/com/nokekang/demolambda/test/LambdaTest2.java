package com.nokekang.demolambda.test;

import com.nokekang.demolambda.utils.DomainUntil;
import com.nokekang.demolambda.model.MyUser;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: learning-java8
 * @description: aaa
 * @author: sunjiankang
 * @create: 2019-06-30 15:13
 **/
public class LambdaTest2 {
    public static void main(String[] args) {
        List<String> sList = Arrays.asList(new String[]{"a", "b", "A", "B"});
//        test1(sList);
        tets2();
        test3();
    }

    private static void test3() {
        new File(".").listFiles(File::isHidden);
    }

    private static void tets2() {
        List<MyUser> myUserList = DomainUntil.myUserList;
        myUserList.sort(Comparator.comparing(MyUser::getAge));
    }

    private static void test1(List<String> sList) {

        sList.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        sList.forEach(System.out::println);
        sList.sort((String s1, String  s2) -> s1.compareToIgnoreCase(s2));
        sList.sort(String::compareToIgnoreCase);
    }
    


}
