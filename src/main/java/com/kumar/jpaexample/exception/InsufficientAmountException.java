package com.kumar.jpaexample.exception;

public class InsufficientAmountException extends  RuntimeException{
    public InsufficientAmountException(String msg) {
        super(msg);
    }
}
