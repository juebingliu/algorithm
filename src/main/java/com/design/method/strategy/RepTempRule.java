package com.design.method.strategy;

/**
 * Created by juebingliu on 2018/6/12.
 */
public abstract class RepTempRule {

    //原始字符串
    protected String oldString = "aaadddaaa";

    public void setOldString(String oldString) {
        this.oldString = oldString;
    }

    protected String newString = "";

    public String getNewString() {
        return newString;
    }
    public abstract String replace() throws Exception;
}
