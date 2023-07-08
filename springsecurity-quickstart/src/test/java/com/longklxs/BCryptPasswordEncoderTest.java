package com.longklxs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BCryptPasswordEncoderTest {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Test
    public void testBCryptPasswordEncoder(){
//        原始密码
        String rawPassword = "1234";
//        1.加密密码
        String encode = bCryptPasswordEncoder.encode(rawPassword);
//        2.输出
        System.out.println(encode);
//        3.比较密码
        boolean matches = bCryptPasswordEncoder.matches(rawPassword, encode);
        System.out.println(matches);
    }

}
