package com.example.jiashuaowei.service;

import com.example.jiashuaowei.dao.FaultDao;
import com.example.jiashuaowei.entity.Fault;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

/**
 * Created by jiashuaowei on 14/04/2017.
 */
@Service("faultService")

public class FaultService {
    @Resource(name = "faultDao")
    private FaultDao faultDao;

    /**
     * 查询date日期的故障记录
     *
     * @param date
     * @return
     */
    public List<Fault> findFaultsByDate(Date date) {
        return faultDao.findFaultsByDate(date);
    }

    /**
     * 通过查找老师id为teacherId的故障提交记录
     *
     * @param teacherId
     * @return
     */
    public List<Fault> findFaultsByTchId(int teacherId) {
        return faultDao.findFaultsByTchId(teacherId);
    }

    /**
     * 查询已经修复的故障
     *
     * @return
     */
    public List<Fault> findFaultsIsChecked() {
        return faultDao.findFaultsIsChecked();
    }

    /**
     * 查询还未修复的故障
     *
     * @return
     */
    public List<Fault> findFaultsIsNotChecked() {
        return faultDao.findFaultsIsNotChecked();
    }

    /**
     * 增加一条故障记录
     *
     * @param fault
     * @return
     */
    public boolean insertAFault(Fault fault) {
        return faultDao.insertAFault(fault);
    }

    /**
     * 删除一条故障记录
     *
     * @param id
     * @return
     */
    public boolean deleteAFaultById(int id) {
        return faultDao.deleteAFaultById(id);
    }
}
