package com.design.method.strategy;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class RepTempRuleTwo extends RepTempRule {
    @Override
    public String replace() throws Exception {
        newString = oldString.replaceFirst("aaa","ccc");
        System.out.println("this is replace two");
        return newString;
    }
}
