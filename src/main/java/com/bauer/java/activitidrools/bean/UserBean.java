package com.bauer.java.activitidrools.bean;

import java.io.Serializable;

/**
 * @Author ：rui.wei
 * @Date ：Created in 16:43 2018/8/27
 * @Description：
 */
public class UserBean implements Serializable {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
