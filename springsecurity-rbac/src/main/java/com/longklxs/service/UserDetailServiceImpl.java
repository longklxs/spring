package com.longklxs.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.longklxs.mapper.MenuMapper;
import com.longklxs.mapper.RoleMapper;
import com.longklxs.mapper.UserMapper;
import com.longklxs.pojo.Menu;
import com.longklxs.pojo.Role;
import com.longklxs.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(username)){
            throw new NullPointerException("用户名没提供");
        }
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",username);
        Users users = userMapper.selectOne(queryWrapper);
        if(users == null){
            throw new UsernameNotFoundException("用户名或密码错误");
        }

        String encode = bCryptPasswordEncoder.encode(users.getPassword());
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();



        List<Role> roles = roleMapper.findByUserId(users.getId());
        List<Menu> menus = menuMapper.findByUserId(users.getId());

        if(roles != null && roles.size() > 0){
            for(Role role : roles){
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getName());
                grantedAuthorityList.add(simpleGrantedAuthority);
            }
        }

        if(menus != null && menus.size() > 0 ){
            for(Menu menu : menus){
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(menu.getPerms());
                grantedAuthorityList.add(simpleGrantedAuthority);
            }
        }

        User user = new User(username,encode,grantedAuthorityList);


        return user;
    }
}
