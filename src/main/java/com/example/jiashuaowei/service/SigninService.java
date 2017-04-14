package com.example.jiashuaowei.service;

import com.example.jiashuaowei.dao.SigninDao;
import com.example.jiashuaowei.entity.Signin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

/**
 * Created by jiashuaowei on 14/04/2017.
 */
@Service("signinService")
public class SigninService {
    @Resource(name = "signinDao")
    private SigninDao signinDao;

    /**
     * 通过日期找签到表
     * REC是record缩写
     *
     * @param date
     * @return
     */
    public List<Signin> findSigninRECByDate(Date date) {
        return signinDao.findSigninRECByDate(date);
    }

    /**
     * 通过老师id查询签到情况
     *
     * @param teacherId
     * @return
     */
    public List<Signin> findSigninRECByTchId(int teacherId) {
        return signinDao.findSigninRECByTchId(teacherId);
    }

    /**
     * 删除一条签到
     *
     * @param id
     * @return
     */
    public boolean deleteSigninRECById(int id) {
        return signinDao.deleteSigninRECById(id);
    }

    /**
     * 增加一条签到记录
     *
     * @param signin
     * @return
     */
    public boolean insertSigninREC(Signin signin) {
        return signinDao.insertSigninREC(signin);
    }

}
