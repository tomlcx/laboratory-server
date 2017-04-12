package com.example.jiashuaowei.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by jiashuaowei on 11/04/2017.
 */
public class Fault {

    private int id;
    private Timestamp time;
    private Date date;
    private String description;
    private boolean isChecked;
    private int teacherId;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
