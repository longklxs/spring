package com.longklxs.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class Users implements Serializable {

    //主键ID
    private Long id;
    //用户名
    private String name;
    //昵称
    private String nickName;
    //密码
    private String password;
    //创建时间
    private Date createTime;

}
