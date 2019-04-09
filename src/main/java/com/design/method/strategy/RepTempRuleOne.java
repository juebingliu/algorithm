package com.design.method.strategy;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class RepTempRuleOne extends RepTempRule {
    @Override
    public String replace() throws Exception {
        newString = oldString.replaceFirst("aaa","bbb");
        System.out.println("this is replace one");
        return newString;
    }
}
