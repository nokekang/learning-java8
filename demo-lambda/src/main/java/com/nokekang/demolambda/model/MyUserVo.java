package com.nokekang.demolambda.model;

import lombok.Data;

/**
 * @program: learning-java8
 * @description: MyUserVo
 * @author: sunjiankang
 * @create: 2019-06-29 20:20
 **/
@Data
public class MyUserVo {
    private String voUserName;
    private Integer voAge;

    public MyUserVo() {
    }

    public MyUserVo(String voUserName, Integer voAge) {
        this.voUserName = voUserName;
        this.voAge = voAge;
    }

    @Override
    public String toString() {
        return "MyUserVo{" +
                "voUserName='" + voUserName + '\'' +
                ", voAge=" + voAge +
                '}';
    }
}
