package com.design.method.composite;

import java.util.ArrayList;

/**
 * Created by juebingliu on 2018/6/11.
 */

/**
 * composite
 */
public class ProjectManager extends Employer {

    public ProjectManager(String name) {
        setName(name);
        employers = new ArrayList<Employer>();
    }

    @Override
    public void add(Employer employer) {
        employers.add(employer);
    }

    @Override
    public void delete(Employer employer) {
        employers.remove(employer);
    }
}
