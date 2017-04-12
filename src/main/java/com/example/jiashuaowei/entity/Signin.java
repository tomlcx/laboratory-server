package com.example.jiashuaowei.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by jiashuaowei on 12/04/2017.
 * 签到表entity
 */
public class Signin {
    private int id;

    private Date date;

    private Timestamp time;

    private int teacherId;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
