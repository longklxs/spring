package com.longklxs.handler;


import com.longklxs.commons.CustomerException;
import com.longklxs.commons.ResultInfo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloBalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResultInfo handleException(Exception ex){
        return new ResultInfo(500,ex.getMessage(),null);
    }

    public ResultInfo handleCustomerException(CustomerException ex){
        return new ResultInfo(501,ex.getMessage(),null);
    }
}
