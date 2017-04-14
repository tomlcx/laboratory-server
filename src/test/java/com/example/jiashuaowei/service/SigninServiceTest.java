package com.example.jiashuaowei.service;

import com.example.jiashuaowei.entity.Signin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jiashuaowei on 14/04/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class SigninServiceTest {
    @Autowired
    private SigninService signinService;

    @Test
    public void findSigninRECByDate() throws Exception {
        List<Signin> list = signinService.findSigninRECByDate(new Date(System.currentTimeMillis()));
        for (Signin item : list) {
            System.out.println(item.getId());
        }

    }

    @Test
    public void findSigninRECByTchId() throws Exception {
        List<Signin> list = signinService.findSigninRECByTchId(1);
        for (Signin item : list) {
            System.out.println(item.getId());
        }
    }

    @Test
    public void deleteSigninRECById() throws Exception {
        signinService.deleteSigninRECById(10);
    }

    @Test
    public void insertSigninREC() throws Exception {
        Signin signin = new Signin();
        signin.setDate(new Date(System.currentTimeMillis()));
        signin.setTime(new Timestamp(System.currentTimeMillis()));
        signin.setTeacherId(1);
        signinService.insertSigninREC(signin);
    }

}