package com.longklxs.commons;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultInfo implements Serializable {
    private Integer code;
    private String message;
    private Object data;

    public static ResultInfo success(Object data){
        return new ResultInfo(Constant.OK,"OK",data);
    }

    public static ResultInfo error(Object data){
        return new ResultInfo(Constant.ERROR,"OK",data);
    }

}
