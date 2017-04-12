package com.example.jiashuaowei.dao;

import com.example.jiashuaowei.entity.Signin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jiashuaowei on 12/04/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})

public class SigninDaoTest {
    @Resource(name = "signinDao")
    private SigninDao signinDao;

    @Test
    public void findSigninRECByDate() throws Exception {
        Date date = new Date(System.currentTimeMillis());
        List<Signin> list = signinDao.findSigninRECByDate(date);
        System.out.println(list.size());
    }

    @Test
    public void findSigninRECByTchId() throws Exception {
        List<Signin> list = signinDao.findSigninRECByTchId(2);
        System.out.println(list.size());
    }

    @Test
    public void deleteSigninRECById() throws Exception {
        signinDao.deleteSigninRECById(1);
    }

    @Test
    public void insertSigninREC() throws Exception {
        Signin signin = new Signin();
        signin.setTeacherId(2);

        signin.setTime(new Timestamp(System.currentTimeMillis()));
        signin.setDate(new Date(System.currentTimeMillis()));
        signinDao.insertSigninREC(signin);
    }

}