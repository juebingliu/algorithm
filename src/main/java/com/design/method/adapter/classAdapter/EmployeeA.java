package com.design.method.adapter.classAdapter;

import com.design.method.adapter.MyEmployee;

/**
 * Created by juebingliu on 2018/6/8.
 */
public class EmployeeA implements MyEmployee {
    private String name;
    private String position;
    private String address;
    private String age;

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getPosition() {
        return position;
    }
    @Override
    public void setPosition(String position) {
        this.position = position;
    }
    @Override
    public String getAddress() {
        return address;
    }
    @Override
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String getAge() {
        return age;
    }
    @Override
    public void setAge(String age) {
        this.age = age;
    }
}
