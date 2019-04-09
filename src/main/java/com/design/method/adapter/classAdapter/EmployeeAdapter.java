package com.design.method.adapter.classAdapter;

import com.design.method.adapter.MyEmployee;

import java.util.Map;

/**
 * Created by juebingliu on 2018/6/8.
 */
public class EmployeeAdapter extends EmployeeB implements MyEmployee {
    @Override
    public String getName() {
        return getBasicInfo().get("name");
    }

    @Override
    public void setName(String name) {
        Map<String,String> dic = getBasicInfo();
        String key = "name";
        dic.remove( key);
        dic.put( key , name );
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
