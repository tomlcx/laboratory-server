package com.example.jiashuaowei.dao;

import com.example.jiashuaowei.entity.Curriculum;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

/**
 * Created by jiashuaowei on 11/04/2017.
 */
@Repository("curriculumDao")
public class CurriculumDao {
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 查询date日期的老师的课程
     *
     * @param teacherId 老师id
     * @return
     */
    public List<Curriculum> findCurrByTchId(int teacherId) {
        return sqlSessionTemplate.selectList("curriculumMapper.findCurrByTchId", teacherId);
    }

    /**
     * 查询date日期的课表
     *
     * @param date 日期
     * @return
     */
    public List<Curriculum> findCurrByDate(Date date) {
        return sqlSessionTemplate.selectList("curriculumMapper.findCurrByDate", date);
    }

    /**
     * 增加一个课程
     *
     * @param curr
     * @return
     */
    public boolean insertACurr(Curriculum curr) {
        int k = sqlSessionTemplate.insert("curriculumMapper.insertACurr", curr);
        return k > 0;
    }

    /**
     * 删除一个课程
     *
     * @param id
     * @return
     */
    public boolean deleteACurrById(int id) {
        int k = sqlSessionTemplate.delete("curriculumMapper.deleteACurr", id);
        return k > 0;
    }

}
