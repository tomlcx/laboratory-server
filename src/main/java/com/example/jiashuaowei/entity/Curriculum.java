package com.example.jiashuaowei.entity;


import java.sql.Date;
import java.sql.Time;

/**
 * Created by jiashuaowei on 11/04/2017.
 */
public class Curriculum {
    private int id;
    private Time startTime;
    private Time endTime;
    private String name;
    private Time during;
    private Date date;
    private int teacherId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getDuring() {
        return during;
    }

    public void setDuring(Time during) {
        this.during = during;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
