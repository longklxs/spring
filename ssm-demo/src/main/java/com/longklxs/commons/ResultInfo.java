package com.longklxs.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo implements Serializable {

    private int code;
    private String message;
    private Object data;
}
