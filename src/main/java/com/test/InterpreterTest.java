package com.test;

import com.design.method.interpreter.Context;
import com.design.method.interpreter.MinusExpression;
import com.design.method.interpreter.PlusExpression;

/**
 * Created by juebingliu on 2018/6/13.
 */
public class InterpreterTest {
    public static void main(String[] args) {
        Context context = new Context( "10" ) ;

        new MinusExpression().interpret(context) ;
        new PlusExpression().interpret(context) ;
        new MinusExpression().interpret(context) ;
        new PlusExpression().interpret(context) ;
        System.out.println( context.getOut() );
    }
}
