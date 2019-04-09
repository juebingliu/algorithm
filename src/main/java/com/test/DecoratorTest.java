package com.test;

import com.design.method.decorator.JiDan;
import com.design.method.decorator.JiDanNoodle;
import com.design.method.decorator.NiuRou;
import com.design.method.decorator.Noodle;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Noodle noodle = new JiDanNoodle();
        System.out.println(noodle.getDescriptin() + ",价格 " + noodle.cost());

        noodle = new JiDan(noodle);// 加一个鸡蛋
        System.out.println(noodle.getDescriptin() + ",价格 " + noodle.cost());

        noodle = new NiuRou(noodle);

        System.out.println(noodle.getDescriptin() + ",价格 " + noodle.cost());
    }
}
