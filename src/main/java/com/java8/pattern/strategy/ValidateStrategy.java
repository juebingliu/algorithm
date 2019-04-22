package com.java8.pattern.strategy;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/22 18:23
 * @description 校验策略
 */
public interface ValidateStrategy {
    boolean excute(String s);
}