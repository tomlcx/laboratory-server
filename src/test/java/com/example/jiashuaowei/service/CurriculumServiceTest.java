package com.example.jiashuaowei.service;

import com.example.jiashuaowei.entity.Curriculum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jiashuaowei on 14/04/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class CurriculumServiceTest {
    @Autowired
    private CurriculumService curriculumService;

    @Test
    public void findCurriculaToday() throws Exception {
        List<Curriculum> list = curriculumService.findCurriculaToday();
        System.out.println(list.size());
        for (Curriculum item : list) {
            System.out.println(item.getId());
        }
    }

    @Test
    public void findCurriculaByDate() throws Exception {
        List<Curriculum> list = curriculumService.findCurriculaByDate(new Date(System.currentTimeMillis() - 24 * 3600 * 1000));
        System.out.println(list.size());
        for (Curriculum item : list) {
            System.out.println(item.getId());
        }
    }

    @Test
    public void insertACurr() throws Exception {
        Curriculum curriculum = new Curriculum();
        curriculum.setTeacherId(1);
        curriculum.setEndTime(new Time(System.currentTimeMillis()));
        curriculum.setStartTime(new Time(System.currentTimeMillis()));
        curriculum.setDate(new Date(System.currentTimeMillis() - 24 * 3600 * 1000));
        curriculum.setName("math");
        curriculum.setDuring(new Time(10000));
        curriculumService.insertACurr(curriculum);
    }

    @Test
    public void deleteACurrById() throws Exception {
        curriculumService.deleteACurrById(9);
    }

}