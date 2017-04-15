package com.example.jiashuaowei.controller;

import com.example.jiashuaowei.Constant;
import com.example.jiashuaowei.entity.Response;
import com.example.jiashuaowei.entity.Teacher;
import com.example.jiashuaowei.service.TeacherService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jiashuaowei on 14/04/2017.
 */
@Component
@RequestMapping("/laboratory/teacher")
public class TeacherController {
    @Resource(name = "teacherService")
    private TeacherService teacherService;

    /**
     * 获取老师列表
     */
    @RequestMapping("/gettchlist")
    @ResponseBody
    public Response<List<Teacher>> getTchList() {
        List<Teacher> lists = teacherService.findAllTch();
        Response<List<Teacher>> response = new Response<List<Teacher>>(Constant.FAIL, "未知错误");
        if (lists != null) {
            response.setEvent(Constant.SUCCESS);
            response.setMsg("查询老师列表成功");
            response.setObjList(lists);
        }
        return response;
    }

    @RequestMapping("/addatch")
    @ResponseBody
    public Response<Void> addATch(@RequestBody Teacher teacher) {
        Response<Void> response = new Response<>(Constant.FAIL, "未知错误");

        if (teacherService.insertATch(teacher)) {
            response.setEvent(Constant.SUCCESS);
            response.setMsg("添加一个老师成功");
        }
        return response;
    }

    @RequestMapping("delatchbyid")
    @ResponseBody
    public Response<Void> delATchById(@RequestBody int id) {
        Response<Void> response = new Response<>(Constant.FAIL, "未知错误");
        if (teacherService.deleteATchById(id)) {
            response.setEvent(Constant.SUCCESS);
            response.setMsg("删除一个老师成功");
        }
        return response;
    }
}
