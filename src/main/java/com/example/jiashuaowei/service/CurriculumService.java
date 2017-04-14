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

    /**
     * 查询date日期的课表
     *
     * @param date
     * @return
     */
    public List<Curriculum> findCurriculaByDate(Date date) {
        return curriculumDao.findCurrByDate(date);
    }

    /**
     * 添加一个课程
     *
     * @param curriculum
     */
    public void insertACurr(Curriculum curriculum) {
        if (!curriculumDao.insertACurr(curriculum)) {
            logger.error("添加课程出错");
        }
    }

    /**
     * 删除一个课程
     *
     * @param id
     */
    public void deleteACurrById(int id) {
        if (!curriculumDao.deleteACurrById(id)) {
            logger.error("删除课程出错");
        }
    }


}
