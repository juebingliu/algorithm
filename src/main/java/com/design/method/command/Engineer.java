package com.design.method.command;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class Engineer implements Command {
    @Override
    public void execute() {
        //do Engineer's command
        System.out.println("Engineer");
    }
}
