package com.esrx.student.ExceptionHandling;

public class InValidIdException extends RuntimeException{
    String msg;
    public InValidIdException(String msg){
        super(msg);
    }
}
