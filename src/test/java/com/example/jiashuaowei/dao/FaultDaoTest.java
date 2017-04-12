package com.example.jiashuaowei.dao;

import com.example.jiashuaowei.entity.Fault;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
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
public class FaultDaoTest {
    @Resource(name = "faultDao")
    private FaultDao faultDao;

    @Test
    public void findFaultsByDate() throws Exception {
        Date date = new Date(System.currentTimeMillis());
        List<Fault> list = faultDao.findFaultsByDate(date);
        System.out.println(list.size());
    }

    @Test
    public void findAllFaults() throws Exception {
        List<Fault> list = faultDao.findAllFaults();
        System.out.println(list.size());
    }

    @Test
    public void findFaultsByTchId() throws Exception {
        List<Fault> faultList = faultDao.findFaultsByTchId(1);
        System.out.println(faultList.size());
    }

    @Test
    public void findFaultsIsChecked() throws Exception {
        List<Fault> faultList = faultDao.findFaultsIsChecked();
        System.out.println(faultList.size());
    }

    @Test
    public void findFaultsIsNotChecked() throws Exception {
        List<Fault> faultList = faultDao.findFaultsIsNotChecked();
        System.out.println(faultList.size());
    }

    @Test
    public void insertAFault() throws Exception {
        Fault fault = new Fault();
        fault.setTime(new Timestamp(System.currentTimeMillis()));
        fault.setDescription("first fault");
        fault.setChecked(false);
        fault.setTeacherId(2);

        fault.setDate(new Date(System.currentTimeMillis()));
        faultDao.insertAFault(fault);
    }

    @Test
    public void deleteAFaultById() throws Exception {
        faultDao.deleteAFaultById(3);
    }

}