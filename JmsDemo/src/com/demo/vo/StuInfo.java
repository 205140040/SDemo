package com.demo.vo;

import java.util.Date;

public class StuInfo {
    private Integer id;

    private String name;

    private String sex;

    private Date birDay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirDay() {
        return birDay;
    }

    public void setBirDay(Date birDay) {
        this.birDay = birDay;
    }
}