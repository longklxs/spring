package com.longklxs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableField("id")
    @TableId(type= IdType.ASSIGN_ID)
    private Long id;
    private String name;

    private String password;

    private Integer age;
    private String tel;
    private Integer isDelete;
}
