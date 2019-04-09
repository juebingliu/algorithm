package com.design.method.decorator;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class NiuRou extends Material{
    public NiuRou(Noodle noodle){
        super(noodle);
    }

    @Override
    public String getDescriptin() {
        return noodle.getDescriptin()+" + 牛肉";
    }

    @Override
    public double cost() {
        return noodle.cost()+2.0;
    }
}
