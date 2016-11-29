package com.example.hagitz.locadoapp;

import android.location.Location;

import java.util.Date;

public class Reminder {

    private String name;
    private String address;
    private String details;
    private Date createDay;
    private boolean state;
    private int distance;
    private Location location;
    // Ringtone

    public Reminder(String _name, String _add) {
        address = _add;
        name = _name;
        state = true;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}

