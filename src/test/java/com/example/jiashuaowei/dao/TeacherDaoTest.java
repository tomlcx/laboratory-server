package com.example.jiashuaowei.dao;

import com.example.jiashuaowei.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jiashuaowei on 12/04/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class TeacherDaoTest {
    @Resource(name = "teacherDao")
    private TeacherDao teacherDao;

    @Test
    public void findAllTch() throws Exception {
        List<Teacher> list = teacherDao.findAllTch();
        System.out.println(list.size());
    }

    @Test
    public void insertATch() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setAdministrator(false);
        teacher.setAge(30);
        teacher.setName("jia2");
        teacherDao.insertATch(teacher);
    }

    @Test
    public void deleteATchById() throws Exception {
        teacherDao.deleteATchById(4);
    }

}