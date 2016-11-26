package com.example.hagitz.locadoapp;

import java.util.Date;

/**
 * Created by hagitz on 11/26/2016.
 */
public class Reminder {
    private String name;
    private String address;
    private Date createDay;
    private boolean state;


    public Reminder(String _name, String _add) {
        address = _add;
        name = _name;
        state = true;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getDAddress() {
        return address;
    }

    public Date getCreateDay() {
        return createDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetail(String address) {
        this.address = address;
    }

    public void setCreateDay(Date createDay) {
        this.createDay = createDay;
    }

    public void changeState() {
        state= !state;
    }
}

