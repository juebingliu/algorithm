package com.design.method.command;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class Politician implements Command {
    @Override
    public void execute() {
        System.out.println("Politician");
    }
}
