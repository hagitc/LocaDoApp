package com.example.hagitz.locadoapp;

import android.location.Location;

import java.util.ArrayList;

/**
 * Created by hagitz on 11/28/2016.
 */
public class ReminderList {
    ArrayList<Reminder> remiderList;

    public ReminderList() {
        this.remiderList = new ArrayList<Reminder>();
    }

    public void AddReminder(Reminder reminder)
    {
        remiderList.add(reminder);
    }

    public void RemoveReminder(Reminder reminder)
    {
        remiderList.remove(reminder);
    }

    public ArrayList<Location> getLocationList()
    {
        ArrayList<Location> locationArrayList = new ArrayList<Location>();
        for (Reminder r:remiderList) {
            locationArrayList.add(r.getLocation());
        }
        return  locationArrayList;
    }


}
