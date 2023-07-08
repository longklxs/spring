package com.longklxs;


import com.longklxs.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HelloTest {

    @Value("user.name")
    private String name;
    @Value("user.sex")
    private String sex;
    @Autowired
    Environment environment;

    @Autowired
    User user;
    @Test
    public void test01(){
        System.out.println(user);

        System.out.println(name + "------------" + sex);
        System.out.println(environment.getProperty("user.name") + "--------------" + environment.getProperty("user.sex"));
    }
}
