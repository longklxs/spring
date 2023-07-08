package com.longklxs.config;

import com.longklxs.filter.JsonUsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.ForwardAuthenticationFailureHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter(){
        JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter = new JsonUsernamePasswordAuthenticationFilter();
        jsonUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(new ForwardAuthenticationSuccessHandler("/home/info"));
        jsonUsernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(new ForwardAuthenticationFailureHandler("/home/fail"));
        return jsonUsernamePasswordAuthenticationFilter;
    }


    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/html/login.html") // 配置哪个 url 为登录页面
                .loginProcessingUrl("/login") // 设置哪个是登录的 url。
                .successForwardUrl("/home/info")//登录成功之后跳转到哪个 url
                .failureForwardUrl("/home/fail")//登录失败之后跳转到哪个 url
                .and().addFilterAt(jsonUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        http.authorizeRequests()
                //表示不需要权限也能访问的请求路径
                .antMatchers("/img/**","/js/**","/html/**")
                .permitAll()// 指定 URL 无需保护。
                .anyRequest()// 其他请求
                .authenticated();//需要认证
        // 关闭 csrf
        http.csrf().disable();
    }
}
