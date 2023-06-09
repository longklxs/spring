package com.longklxs.commons;

public class CustomerException extends RuntimeException{
    private String message;
    public CustomerException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
