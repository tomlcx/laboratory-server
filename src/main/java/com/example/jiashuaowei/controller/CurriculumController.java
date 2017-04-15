package com.example.jiashuaowei.controller;

import com.example.jiashuaowei.Constant;
import com.example.jiashuaowei.dao.CurriculumDao;
import com.example.jiashuaowei.entity.Curriculum;
import com.example.jiashuaowei.entity.Response;
import com.example.jiashuaowei.service.CurriculumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

/**
 * Created by jiashuaowei on 15/04/2017.
 */
@Controller
@RequestMapping("/laboratory/curriculum")
public class CurriculumController {
    @Resource(name = "curriculumService")
    private CurriculumService curriculumService;

    /**
     * 查询date日期的课程
     *
     * @param date
     * @return
     */
    @ResponseBody
    @RequestMapping("/getcurrbydate")
    public Response<List<Curriculum>> getCurrByDate(@RequestBody Date date) {
        Response response = new Response(Constant.FAIL, "未知错误");
        List<Curriculum> list = curriculumService.findCurrByDate(date);
        if (list != null) {
            response.setEvent(Constant.SUCCESS);
            response.setMsg("查询成功");
            response.setObjList(list);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("findcurrtoday")
    public Response<List<Curriculum>> findcurrtoday() {
        Response response = new Response(Constant.FAIL, "未知错误");
        List<Curriculum> list = curriculumService.findCurriculaToday();
        if (list != null) {
            response.setEvent(Constant.SUCCESS);
            response.setMsg("查询成功");
            response.setObjList(list);
        }
        return response;

    }

    /**
     * 查询老师的课表
     *
     * @param teacherId
     * @return
     */
    @ResponseBody
    @RequestMapping("getcurrbytchid")

    public Response<List<Curriculum>> getCurrByTchId(@RequestBody int teacherId) {
        Response response = new Response(Constant.FAIL, "未知错误");
        List<Curriculum> list = curriculumService.findCurrByTchId(teacherId);
        if (list != null) {
            response.setEvent(Constant.SUCCESS);
            response.setMsg("查询成功");
            response.setObjList(list);
        }
        return response;
    }

    /**
     * 增加一个课程
     *
     * @param curriculum
     * @return
     */
    @ResponseBody
    @RequestMapping("addacurr")
    public Response<Void> addACurr(@RequestBody Curriculum curriculum) {
        Response response = new Response(Constant.FAIL, "未知错误");
        if (curriculumService.insertACurr(curriculum)) {
            response.setEvent(Constant.SUCCESS);
            response.setMsg("增加curr成功");
        }
        return response;
    }

    /**
     * 删除一个课程
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("delacurrbyid")
    public Response<Void> delACurrById(@RequestBody int id) {
        Response response = new Response(Constant.FAIL, "未知错误");
        if (curriculumService.deleteACurrById(id)) {
            response.setEvent(Constant.SUCCESS);
            response.setMsg("删除curr成功");
        }
        return response;
    }


}
