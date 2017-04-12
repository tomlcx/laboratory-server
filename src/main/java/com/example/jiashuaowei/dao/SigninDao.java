package com.example.jiashuaowei.dao;

import com.example.jiashuaowei.entity.Signin;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

/**
 * Created by jiashuaowei on 12/04/2017.
 */
@Repository("signinDao")
public class SigninDao {
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 通过日期找签到表
     * REC是record缩写
     *
     * @param date
     * @return
     */
    public List<Signin> findSigninRECByDate(Date date) {
        return sqlSessionTemplate.selectList("signinMapper.findSigninRECByDate", date);
    }

    /**
     * 通过老师id查询签到情况
     *
     * @param teacherId
     * @return
     */
    public List<Signin> findSigninRECByTchId(int teacherId) {
        return sqlSessionTemplate.selectList("signinMapper.findSigninRECByTchId", teacherId);
    }

    /**
     * 删除一条签到
     *
     * @param id
     * @return
     */
    public boolean deleteSigninRECById(int id) {
        int k = sqlSessionTemplate.delete("signinMapper.deleteSigninRECById", id);
        return k > 0;
    }

    /**
     * 增加一条签到记录
     *
     * @param signin
     * @return
     */
    public boolean insertSigninREC(Signin signin) {
        int k = sqlSessionTemplate.insert("signinMapper.insertSigninREC", signin);
        return k > 0;
    }
}
