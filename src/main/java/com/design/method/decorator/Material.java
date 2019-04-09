package com.design.method.decorator;

/**
 * Created by juebingliu on 2018/6/11.
 */
public abstract class Material extends Noodle{
    Noodle noodle;

    public Material(Noodle noodle){
        this.noodle = noodle;
    }

    public abstract String  getDescriptin();

}
