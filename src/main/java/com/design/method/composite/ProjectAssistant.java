package com.design.method.composite;

/**
 * Created by juebingliu on 2018/6/11.
 */

/**
 * leaf
 */
public class ProjectAssistant extends Employer {

    public ProjectAssistant(String name) {
        setName(name);
        employers = null;//项目助理, 表示没有下属了
    }

    @Override
    public void add(Employer employer) {

    }

    @Override
    public void delete(Employer employer) {

    }
}
