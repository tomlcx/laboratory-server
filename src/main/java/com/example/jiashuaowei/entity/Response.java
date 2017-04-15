package com.example.jiashuaowei.entity;

import com.example.jiashuaowei.Constant;

/**
 * Created by jiashuaowei on 14/04/2017.
 */
public class Response<T> {
    private String event;
    private String msg;
    private T obj;
    private T objList;

    public Response(String event, String msg) {
        this.event = event;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return event.equals(Constant.SUCCESS);
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getObjList() {
        return objList;
    }

    public void setObjList(T objList) {
        this.objList = objList;
    }
}
