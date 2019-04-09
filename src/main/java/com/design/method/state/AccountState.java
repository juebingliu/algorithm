package com.design.method.state;

/**
 * Created by juebingliu on 2018/6/13.
 */
public abstract class AccountState {
    protected Account acc;
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void computeInterest();
    public abstract void stateCheck();
}
