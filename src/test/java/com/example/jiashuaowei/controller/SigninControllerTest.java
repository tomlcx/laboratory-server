package com.example.jiashuaowei.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jiashuaowei.entity.Signin;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Date;
import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * Created by jiashuaowei on 15/04/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/dispatcher-servlet.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional

public class SigninControllerTest {
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getsigninrecbydate() throws Exception {
        Date date = new Date(System.currentTimeMillis());
        mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/signin/getsigninrecbydate").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(date))).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getSigninRECByTchId() throws Exception {
        int id = 1;
        mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/signin/getsigninrecbytchid").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(id))).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void delSigninRECById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/signin/delsigninrecbyid").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(2))).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void insertSigninREC() throws Exception {
        Signin signin = new Signin();
        signin.setTeacherId(1);
        signin.setTime(new Timestamp(System.currentTimeMillis()));
        signin.setDate(new Date(System.currentTimeMillis()));
        mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/signin/insertsigninrec").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(signin))).andDo(MockMvcResultHandlers.print());
    }

}