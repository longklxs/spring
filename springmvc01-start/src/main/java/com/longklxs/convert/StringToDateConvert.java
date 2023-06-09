package com.longklxs.convert;



import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StringToDateConvert implements Converter<String, Date> {

    private String pattern;
    @Override
    public Date convert(String source) {
        if(source == null){
            throw new NullPointerException("空指针异常");
        }
        if(pattern == null){
            pattern = "yyyy-MM-dd";
        }
        try {
            DateFormat dateFormat = new SimpleDateFormat(pattern);
            Date date = dateFormat.parse(source);
            return date;
        } catch (ParseException e) {
            throw new IllegalArgumentException("非法参数异常");
        }
    }
}
