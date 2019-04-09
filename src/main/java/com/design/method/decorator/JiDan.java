package com.design.method.decorator;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class JiDan extends Material{
    public JiDan(Noodle noodle){
        super(noodle);
    }

    @Override
    public String getDescriptin() {
        return noodle.getDescriptin()+" + 鸡蛋";

    }

    @Override
    public double cost() {
        return noodle.cost()+1.5;
    }
}
