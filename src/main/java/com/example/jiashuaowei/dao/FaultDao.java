package com.example.jiashuaowei.dao;

import com.example.jiashuaowei.entity.Fault;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by jiashuaowei on 11/04/2017.
 */
@Repository("faultDao")
public class FaultDao {
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 查询date日期的故障记录
     *
     * @param date
     * @return
     */
    public List<Fault> findFaultsByDate(Date date) {
        return sqlSessionTemplate.selectList("faultMapper.findFaultsByDate", date);
    }

    /**
     * 查询所有故障记录
     *
     * @return
     */
    public List<Fault> findAllFaults() {
        return sqlSessionTemplate.selectList("faultMapper.findAllFaults");
    }

    /**
     * 通过teacherId查询故障报修记录
     *
     * @param teacherId
     * @return
     */
    public List<Fault> findFaultsByTchId(int teacherId) {
        return sqlSessionTemplate.selectList("faultMapper.findFaultsByTchId", teacherId);
    }

    /**
     * 查询已经修复的故障
     *
     * @return
     */
    public List<Fault> findFaultsIsChecked() {
        return sqlSessionTemplate.selectList("faultMapper.findFaultsIsChecked");
    }

    /**
     * 查询还未修复的故障
     *
     * @return
     */
    public List<Fault> findFaultsIsNotChecked() {
        return sqlSessionTemplate.selectList("faultMapper.findFaultsIsNotChecked");
    }

    /**
     * 增加一条故障记录
     *
     * @param fault
     * @return
     */
    public boolean insertAFault(Fault fault) {
        int k = sqlSessionTemplate.insert("faultMapper.insertAFault", fault);
        return k > 0;
    }

    /**
     * 删除一条故障记录
     *
     * @param id
     * @return
     */
    public boolean deleteAFaultById(int id) {
        int k = sqlSessionTemplate.delete("faultMapper.deleteAFaultById", id);
        return k > 0;
    }
}
