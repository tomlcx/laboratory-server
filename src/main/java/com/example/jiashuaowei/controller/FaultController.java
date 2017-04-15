package com.example.jiashuaowei.controller;

import com.example.jiashuaowei.Constant;
import com.example.jiashuaowei.entity.Fault;
import com.example.jiashuaowei.entity.Response;
import com.example.jiashuaowei.service.FaultService;
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
@RequestMapping("/laboratory/fault")
public class FaultController {
    @Resource(name = "faultService")
    private FaultService faultService;

    @ResponseBody
    @RequestMapping("/getfaultsbydate")
    public Response<List<Fault>> getFaultsByDate(@RequestBody Date date) {
        Response response = new Response(Constant.FAIL, "未知错误");
        List<Fault> list = faultService.findFaultsByDate(date);
        if (list != null) {
            response.setEvent(Constant.SUCCESS);
            response.setMsg("获取故障信息成功");
            response.setObjList(list);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("/getfaultsbytchid")
    public Response<List<Fault>> getFaultsByTchId(@RequestBody int tecId) {
        Response response = new Response(Constant.FAIL, "未知错误");
        List<Fault> list = faultService.findFaultsByTchId(tecId);
        if (list != null) {
            response.setEvent(Constant.SUCCESS);
            response.setMsg("获取故障信息成功");
            response.setObjList(list);
        }
        return response;
    }


    @ResponseBody
    @RequestMapping("/getfaultsischecked")
    public Response<List<Fault>> getFaultsIsChecked() {
        Response response = new Response(Constant.FAIL, "未知错误");
        List<Fault> list = faultService.findFaultsIsChecked();
        if (list != null) {
            response.setEvent(Constant.SUCCESS);
            response.setMsg("获取checked故障信息成功");
            response.setObjList(list);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("/getfaultsisnotchecked")
    public Response<List<Fault>> getFaultsIsNotChecked() {
        Response response = new Response(Constant.FAIL, "未知错误");
        List<Fault> list = faultService.findFaultsIsNotChecked();
        if (list != null) {
            response.setEvent(Constant.SUCCESS);
            response.setMsg("获取unchecked故障信息成功");
            response.setObjList(list);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("/" +
            "")
    public Response<List<Fault>> insertAFault(@RequestBody Fault fault) {
        Response response = new Response(Constant.FAIL, "未知错误");
        if (faultService.insertAFault(fault)) {
            response.setEvent(Constant.SUCCESS);
            response.setMsg("insert故障信息成功");
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("/delafaultbyid")
    public Response<List<Fault>> delafaultbyid(@RequestBody int id) {
        Response response = new Response(Constant.FAIL, "未知错误");
        if (faultService.deleteAFaultById(id)) {
            response.setEvent(Constant.SUCCESS);
            response.setMsg("del故障信息成功");
        }
        return response;
    }
}
