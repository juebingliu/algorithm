package com.test;

import com.design.method.builder.Person;

/**
 * Created by juebingliu on 2018/6/8.
 */
public class BuilderTest {
    public static void main(String[] args) {
        Person person = new Person.Builder().name("StephenHe").age(20).sex(true).build();
        System.out.println(person.getName() + "\n" + person.getAge() + "\n" + person.isSex());
    }
}
