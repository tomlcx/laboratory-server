package com.example.jiashuaowei.service;

import com.example.jiashuaowei.dao.CurriculumDao;
import com.example.jiashuaowei.entity.Curriculum;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;


/**
 * Created by jiashuaowei on 14/04/2017.
 */
@Service("curriculumService")
public class CurriculumService {
    private Logger logger = Logger.getLogger(CurriculumService.class);

    @Resource(name = "curriculumDao")
    private CurriculumDao curriculumDao;

    /**
     * 查询今天的课表
     *
     * @return
     */
    public List<Curriculum> findCurriculaToday() {
        return curriculumDao.findCurrByDate(new Date(System.currentTimeMillis()));
    }

    public List<Curriculum> findCurrByTchId(int teacherId) {
        return curriculumDao.findCurrByTchId(teacherId);
    }

    /**
     * 查询date日期的课表
     *
     * @param date
     * @return
     */
    public List<Curriculum> findCurrByDate(Date date) {
        return curriculumDao.findCurrByDate(date);
    }

    /**
     * 添加一个课程
     *
     * @param curriculum
     */
    public boolean insertACurr(Curriculum curriculum) {
        return curriculumDao.insertACurr(curriculum);
    }

    /**
     * 删除一个课程
     *
     * @param id
     */
    public boolean deleteACurrById(int id) {
        return curriculumDao.deleteACurrById(id);
    }


}
