package com.java8.pattern.strategy;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/22 18:24
 * @description 策略校验器
 */
public class ValidateUtil {
    private final ValidateStrategy validateStrategy;

    public ValidateUtil(ValidateStrategy validateStrategy) {
        this.validateStrategy = validateStrategy;
    }

    public ValidateStrategy getValidateStrategy() {
        return validateStrategy;
    }

    public boolean validate(String s) {
        return validateStrategy.excute(s);
    }

    public static void main(String[] args) {
        ValidateUtil v1 = new ValidateUtil((String s) -> s.matches("[a-z]+"));
        ValidateUtil v2 = new ValidateUtil((String s) -> s.matches("\\d+"));
        System.out.println(v1.validate("123"));
        System.out.println(v2.validate("abc"));
    }
}