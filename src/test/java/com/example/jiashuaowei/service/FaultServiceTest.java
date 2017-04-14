package com.example.jiashuaowei.service;

import com.example.jiashuaowei.entity.Fault;
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
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class FaultServiceTest {
    @Autowired
    private FaultService faultService;

    @Test
    public void findFaultsByDate() throws Exception {

        List<Fault> list = faultService.findFaultsByDate(new Date(System.currentTimeMillis()));
        System.out.println(list.size());
        for (Fault item : list) {
            System.out.println(item.getId());
        }
    }

    @Test
    public void findFaultsByTchId() throws Exception {
        List<Fault> list = faultService.findFaultsByTchId(1);
        for (Fault item : list) {
            System.out.println(item.getId());
        }
    }

    @Test
    public void findFaultsIsChecked() throws Exception {
        List<Fault> list = faultService.findFaultsIsChecked();
        for (Fault item : list) {
            System.out.println(item.getId());
        }
    }

    @Test
    public void findFaultsIsNotChecked() throws Exception {
        List<Fault> list = faultService.findFaultsIsNotChecked();
        for (Fault item : list) {
            System.out.println(item.getId());
        }
    }

    @Test
    public void insertAFault() throws Exception {
        Fault fault = new Fault();
        fault.setDate(new Date(System.currentTimeMillis()));
        fault.setTeacherId(1);
        fault.setDescription("juhygtrftgyhuj");
        fault.setTime(new Timestamp(System.currentTimeMillis()));
        fault.setChecked(false);
        faultService.insertAFault(fault);
    }

    @Test
    public void deleteAFaultById() throws Exception {
        faultService.deleteAFaultById(1);
    }

}