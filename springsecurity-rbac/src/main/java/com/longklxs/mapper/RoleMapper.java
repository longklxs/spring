package com.longklxs.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.longklxs.pojo.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @company：千锋教育
 * @author：zhy
 * @date：2023/6/26
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select * from sys_role where id in (select role_id from sys_user_role where user_id = #{userId})")
    List<Role> findByUserId(Long userId);
}
