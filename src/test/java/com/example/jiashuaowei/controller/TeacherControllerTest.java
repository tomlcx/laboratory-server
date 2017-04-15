package com.example.jiashuaowei.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jiashuaowei.Constant;
import com.example.jiashuaowei.entity.Teacher;
import com.sun.corba.se.impl.orbutil.ObjectWriter;
import com.sun.tools.internal.jxc.ap.Const;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.junit.Assert.*;

/**
 * Created by jiashuaowei on 14/04/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/dispatcher-servlet.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional

public class TeacherControllerTest {
    @Autowired
    TeacherController teacherController;


    MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        mockMvc = MockMvcBuilders.standaloneSetup(teacherController).build();
    }

    @Test
    public void getTchList() throws Exception {

        ResultActions ra = mockMvc.perform(MockMvcRequestBuilders.get("/laboratory/teacher/gettchlist").accept(MediaType.APPLICATION_JSON));

        MvcResult mr = ra.andReturn();
        String result = mr.getResponse().getContentAsString();
        System.out.println(result);

    }

    @Test
    public void addATch() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setAdministrator(true);
        teacher.setAge(200);
        teacher.setName("justfortest");
        teacher.setId(100);
        String requestJson = JSONObject.toJSONString(teacher);
        MvcResult mr = mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/teacher/addatch").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(requestJson.getBytes())).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.event").value(Constant.SUCCESS)).andDo(MockMvcResultHandlers.print()).andReturn();
    }

    @Test
    public void delATchById() throws Exception {
        String json = JSONObject.toJSONString(10);
        mockMvc.perform(MockMvcRequestBuilders.post("/laboratory/teacher/delatchbyid").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("event").value(Constant.SUCCESS)).andDo(MockMvcResultHandlers.print()).andReturn();
    }

}