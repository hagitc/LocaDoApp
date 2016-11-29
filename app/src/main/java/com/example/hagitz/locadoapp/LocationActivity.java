package com.example.hagitz.locadoapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class LocationActivity extends AppCompatActivity {

    final String TAG = "Monitor Location";

    LocationListener _networkListener;
    LocationListener _gpsListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    private final String _logTag = "Debug";

    public void updateLoc(View view) {
        Log.d(_logTag, "Monitor Location - Start Listening");

        try {
            LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);

            _networkListener = new MyLocationListner();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this,"No permission ",Toast.LENGTH_LONG).show();
                return;
            }
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, _networkListener);

            _gpsListener = new MyLocationListner();
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, _gpsListener);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }



    }


}
