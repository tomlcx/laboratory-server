package com.example.jiashuaowei.controller;

import com.example.jiashuaowei.Constant;
import com.example.jiashuaowei.entity.Response;
import com.example.jiashuaowei.entity.Signin;
import com.example.jiashuaowei.service.SigninService;
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
@RequestMapping("/laboratory/signin")
public class SigninController {
    @Resource(name = "signinService")
    private SigninService signinService;

    @ResponseBody
    @RequestMapping("/getsigninrecbydate")
    public Response<List<Signin>> getSigninRECByDate(@RequestBody Date date) {
        Response response = new Response(Constant.FAIL, "未知错误");
        List<Signin> list = signinService.findSigninRECByDate(date);
        if (list != null) {
            response.setObjList(list);
            response.setMsg("getSignInRECBydate success");
            response.setEvent(Constant.SUCCESS);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("/getsigninrecbytchid")
    public Response<List<Signin>> getSigninRECByTchId(@RequestBody int tchId) {
        Response response = new Response(Constant.FAIL, "未知错误");
        List<Signin> list = signinService.findSigninRECByTchId(tchId);
        if (list != null) {
            response.setObjList(list);
            response.setMsg("getSigninRECByTchId success");
            response.setEvent(Constant.SUCCESS);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("/delsigninrecbyid")
    public Response<List<Signin>> delSigninRECById(@RequestBody int id) {
        Response response = new Response(Constant.FAIL, "未知错误");
        if (signinService.deleteSigninRECById(id)) {
            response.setMsg("delSigninRECById success");
            response.setEvent(Constant.SUCCESS);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("/insertsigninrec")
    public Response<List<Signin>> insertSigninREC(@RequestBody Signin signin) {
        Response response = new Response(Constant.FAIL, "未知错误");
        if (signinService.insertSigninREC(signin)) {
            response.setMsg("insertSigninREC success");
            response.setEvent(Constant.SUCCESS);
        }
        return response;
    }
}
