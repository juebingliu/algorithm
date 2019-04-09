package com.design.method.strategy;

/**
 * Created by juebingliu on 2018/6/12.
 */

/**
 * 算法决策
 */
public class RepTempRuleSolve {

    private RepTempRule strategy;

    public RepTempRuleSolve(RepTempRule rule) {
        this.strategy = rule;
    }

    public String getNewContext() throws Exception {
        return strategy.replace();
    }

    public void changeAlgorithm(RepTempRule newAlgorithm) {
        strategy = newAlgorithm;
    }
}
