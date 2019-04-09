package com.design.method.command;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class Programmer implements Command {
    @Override
    public void execute() {
        //do programmer's command
        System.out.println("Programmer");
    }
}
