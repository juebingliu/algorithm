package com.test;

import com.design.method.strategy.RepTempRuleOne;
import com.design.method.strategy.RepTempRuleSolve;
import com.design.method.strategy.RepTempRuleThree;
import com.design.method.strategy.RepTempRuleTwo;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class StrategyTest {

    public static void main(String[] args) throws Exception {

        RepTempRuleSolve solve = new RepTempRuleSolve(new RepTempRuleOne());
        System.out.println(solve.getNewContext());

        solve.changeAlgorithm(new RepTempRuleTwo());
        System.out.println(solve.getNewContext());

        solve.changeAlgorithm(new RepTempRuleThree());
        System.out.println(solve.getNewContext());
    }

}
