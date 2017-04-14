package com.example.jiashuaowei.service;

import com.example.jiashuaowei.dao.TeacherDao;
import com.example.jiashuaowei.entity.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jiashuaowei on 14/04/2017.
 */
@Service("teacherService")

public class TeacherService {
    @Resource(name = "teacherDao")
    private TeacherDao teacherDao;

    /**
     * 获取实验室所有老师名单
     *
     * @return
     */
    public List<Teacher> findAllTch() {
        return teacherDao.findAllTch();
    }

    /**
     * 增加一个老师
     *
     * @param teacher
     * @return
     */
    public boolean insertATch(Teacher teacher) {
        return teacherDao.insertATch(teacher);
    }

    /**
     * 删除一个老师
     *
     * @param id
     * @return
     */
    public boolean deleteATchById(int id) {
        return teacherDao.deleteATchById(id);
    }


}
