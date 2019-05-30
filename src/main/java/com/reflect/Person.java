package com.reflect;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/5/30 11:18
 * @description
 */
public class Person {
    @Label("姓名")
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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