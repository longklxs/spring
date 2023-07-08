package com.longklxs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Value("${spring.security.user.password}")
    private String configPassword;

    @Value("${spring.security.user.name}")
    private String configUsername;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(username == null)
            throw new UsernameNotFoundException("没有用户名");
        if(!username.equals(configUsername))
            throw new UsernameNotFoundException("用户名不匹配");
        String encode = bCryptPasswordEncoder.encode(configPassword);
        return new User(username,encode, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,pm"));

    }
}
