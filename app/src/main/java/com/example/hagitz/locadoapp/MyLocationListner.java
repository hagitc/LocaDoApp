package com.example.hagitz.locadoapp;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by hagitz on 11/28/2016.
 */
public class MyLocationListner implements LocationListener {
    final String _logTag = "Monitor Location";
    Location mlLoc;

    public void onLocationChanged(Location location) {
        String provider = location.getProvider();
        double lat = location.getLatitude();
        double lng = location.getLongitude();
        float accuracy = location.getAccuracy();
        long time = location.getTime();
        mlLoc= location;
        Log.d(_logTag, "Monitor Location:" + lng);
    }Location location;

    public Location getLastLoc()
    {
        return  mlLoc;

    }

    public void onStatusChanged(String s, int i, Bundle bundle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void onProviderEnabled(String s) {
        Log.d(_logTag, "Monitor Location - Provider Enabled:" + s);
    }

    public void onProviderDisabled(String s) {
        Log.d(_logTag, "Monitor Location - Provider DISabled:" + s);
    }
}
