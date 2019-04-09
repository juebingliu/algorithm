package com.design.method.decorator;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class NiuRouNoodle extends Noodle {
    public NiuRouNoodle(){
        description = "牛肉面";
    }

    @Override
    public double cost() {
        return 7.5;
    }
}
