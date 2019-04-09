package com.design.method.composite;

import java.util.List;

/**
 * Created by juebingliu on 2018/6/11.
 */

/**
 * Component
 */
public abstract class Employer {
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public abstract void add(Employer employer);

    public abstract void delete(Employer employer);

    public List<Employer> employers;

    public void printInfo() {
        System.out.println(name);
    }

    public List<Employer> getEmployers() {
        return this.employers;
    }
}
