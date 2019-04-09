package com.design.method.strategy;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class RepTempRuleThree extends RepTempRule {
    @Override
    public String replace() throws Exception {
        newString = oldString.replaceAll("aaa","xxx");
        System.out.println("this is replace three");
        return newString;
    }
}
