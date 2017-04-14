package com.example.jiashuaowei.service;

import com.example.jiashuaowei.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jiashuaowei on 14/04/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;

    @Test
    public void findAllTch() throws Exception {
        List<Teacher> list = teacherService.findAllTch();
        System.out.println(list.size());
        for (Teacher item : list) {
            System.out.println(item.getId());
        }
    }

    @Test
    public void insertATch() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setName("jiajia");
        teacher.setAge(20);
        teacher.setAdministrator(true);
        teacherService.insertATch(teacher);
    }

    @Test
    public void deleteATchById() throws Exception {
        teacherService.deleteATchById(8);
    }

}