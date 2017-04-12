package com.example.jiashuaowei.dao;

import com.example.jiashuaowei.entity.Curriculum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jiashuaowei on 12/04/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class CurriculumDaoTest {
    @Resource(name = "curriculumDao")
    private CurriculumDao curriculumDao;

    @Test
    public void findCurrByTchId() throws Exception {
        Date date = new Date(System.currentTimeMillis());
        List<Curriculum> list = curriculumDao.findCurrByTchId(1);
        System.out.println(list.size());
    }


    @Test
    public void findCurrByDate() throws Exception {
    }

    @Test
    public void insertACurr() throws Exception {
        Curriculum curriculum = new Curriculum();
        curriculum.setName("first curr");
        curriculum.setDuring(new Time(10000));
        long time = System.currentTimeMillis();
        curriculum.setStartTime(new Time(time));
        curriculum.setEndTime(new Time(time + 10000L));
        curriculum.setTeacherId(1);
        curriculum.setDate(new Date(time));

        curriculumDao.insertACurr(curriculum);
    }

    @Test
    public void deleteACurrById() throws Exception {
    }

}