package com.example.jiashuaowei.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jiashuaowei.entity.Fault;
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

public class FaultControllerTest {
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void getFaultsByDate() throws Exception {
        Date date = new Date(System.currentTimeMillis());
        mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/fault/getfaultsbydate").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(date))).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getFaultsByTchId() throws Exception {
        int id = 1;
        mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/fault/getfaultsbytchid").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(id))).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getFaultsIsChecked() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/fault/getfaultsischecked").accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getFaultsIsNotChecked() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/fault/getfaultsisnotchecked").accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void insertAFault() throws Exception {
        Fault fault = new Fault();
        fault.setChecked(false);
        fault.setTime(new Timestamp(System.currentTimeMillis()));
        fault.setDescription("description");
        fault.setTeacherId(1);
        fault.setDate(new Date(System.currentTimeMillis()));
        mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/fault/insertafault").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(fault))).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void delafaultbyid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/fault/delafaultbyid").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(10))).andDo(MockMvcResultHandlers.print());
    }

}