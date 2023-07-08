package com.longklxs.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.longklxs.pojo.Menu;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @company：千锋教育
 * @author：zhy
 * @date：2023/6/26
 */

@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    @Select("select * from sys_menu where id in (select menu_id from sys_role_menu where role_id in (select role_id from sys_user_role where user_id = #{userId}))")
    List<Menu> findByUserId(Long userId);
}
