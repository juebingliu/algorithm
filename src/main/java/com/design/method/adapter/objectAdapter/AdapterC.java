package com.design.method.adapter.objectAdapter;

import com.design.method.adapter.MyEmployee;

/**
 * Created by juebingliu on 2018/6/8.
 */
public class AdapterC implements MyEmployee{

    private CName cname;
    private CAddress address;

    public AdapterC() {
        cname = new CName();
        address = new CAddress();
    }

    @Override
    public String getName() {
        return cname.getName();
    }

    @Override
    public void setName(String name) {
        cname.setName(name);
    }

    @Override
    public String getPosition() {
        return null;
    }

    @Override
    public void setPosition(String position) {

    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public void setAddress(String address) {

    }

    @Override
    public String getAge() {
        return null;
    }

    @Override
    public void setAge(String age) {

    }
}
