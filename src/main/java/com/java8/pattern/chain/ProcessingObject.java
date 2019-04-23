package com.java8.pattern.chain;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/23 10:45
 * @description
 */
public abstract class ProcessingObject<T> {
    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T r = handleWork(input);
        if(successor != null) {
            return successor.handle(r);
        }
        return r;
    }

    abstract protected T handleWork(T input);
}