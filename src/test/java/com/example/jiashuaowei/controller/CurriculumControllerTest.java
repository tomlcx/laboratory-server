package com.example.jiashuaowei.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jiashuaowei.Constant;
import com.example.jiashuaowei.entity.Curriculum;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Date;
import java.sql.Time;

import static org.junit.Assert.*;

/**
 * Created by jiashuaowei on 15/04/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/dispatcher-servlet.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional

public class CurriculumControllerTest {
    private MockMvc mockMvc;

//    @Autowired
//    CurriculumController curriculumController;

    @Autowired
    WebApplicationContext wac;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getCurrByDate() throws Exception {
        Date date = new Date(System.currentTimeMillis());
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/curriculum/getcurrbydate").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(date))).andDo(MockMvcResultHandlers.print()).andReturn();
    }

    @Test
    public void getCurrByTchId() throws Exception {
        int id = 1;
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/curriculum/getcurrbytchid").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(id))).andDo(MockMvcResultHandlers.print()).andReturn();

    }

    @Test
    public void addACurr() throws Exception {
        Curriculum curriculum = new Curriculum();
        curriculum.setDuring(new Time(System.currentTimeMillis()));
        curriculum.setName("jaisdfjisdjf");
        curriculum.setDate(new Date(System.currentTimeMillis()));
        curriculum.setStartTime(new Time(System.currentTimeMillis()));
        curriculum.setEndTime(new Time(System.currentTimeMillis()));
        curriculum.setTeacherId(1);
        mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/curriculum/addacurr").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(curriculum))).andExpect(MockMvcResultMatchers.jsonPath("$.event").value(Constant.SUCCESS)).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();

    }

    @Test
    public void delACurr() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/curriculum/delacurrbyid").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(3))).andExpect(MockMvcResultMatchers.jsonPath("$.event").value(Constant.SUCCESS)).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
    }

    @Test
    public void findCurrToday() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/curriculum/findcurrtoday").accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print());
    }

}