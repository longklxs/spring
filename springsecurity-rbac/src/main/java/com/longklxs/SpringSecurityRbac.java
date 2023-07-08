package com.longklxs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@MapperScan("com.longklxs.mapper")
@EnableWebSecurity
public class SpringSecurityRbac {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityRbac.class,args);
    }


}
