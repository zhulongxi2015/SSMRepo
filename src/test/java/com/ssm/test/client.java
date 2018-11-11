package com.ssm.test;

import com.ssm.model.User;
import com.ssm.service.UserService;
import com.ssm.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class client {
    @Resource
    private UserService userService;
    @Test
    public void test1(){
        User user=userService.getUserById(4);
        System.out.println(user);
    }
}
