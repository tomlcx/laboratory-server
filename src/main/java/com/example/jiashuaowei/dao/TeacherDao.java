package com.example.jiashuaowei.dao;

import com.example.jiashuaowei.entity.Teacher;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

/**
 * Created by jiashuaowei on 11/04/2017.
 */
@Repository("teacherDao")
public class TeacherDao {
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 查询date日期的所有老师名单
     *
     * @param date
     * @return
     */
//    public List<Teacher> findTchByDate(Date date) {
//        return sqlSessionTemplate.selectList("teacherMapper.findTchByDate", date);
//    }

    /**
     * 获取实验室所有老师名单
     *
     * @return
     */
    public List<Teacher> findAllTch() {
        return sqlSessionTemplate.selectList("teacherMapper.findAllTch");
    }

    /**
     * 增加一个老师
     *
     * @param teacher
     * @return
     */
    public boolean insertATch(Teacher teacher) {

        int k = sqlSessionTemplate.insert("teacherMapper.insertATch", teacher);
        return k > 0;
    }

    /**
     * 删除一个老师
     *
     * @param id
     * @return
     */
    public boolean deleteATchById(int id) {
        int k = sqlSessionTemplate.delete("teacherMapper.deleteATchById", id);
        return k > 0;
    }


}
