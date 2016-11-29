package com.example.hagitz.locadoapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    String TAG = "Debug";

    private ListView mainListView ;
    ArrayList<Reminder> remindersLists;
    ReminderAdapter adapter;
    FloatingActionButton btnAdd;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        btnAdd = (FloatingActionButton) findViewById(R.id.addRem);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Click new", Toast.LENGTH_SHORT).show();
            }
        });
        mainListView = (ListView) findViewById(R.id.listView);
        remindersLists = new ArrayList<Reminder>();
        remindersLists.add(new Reminder("test", "test it"));
        remindersLists.add(new Reminder("test1", "test it 1"));
        remindersLists.add(new Reminder("test2", "test it 2"));

        adapter = new ReminderAdapter(this, remindersLists);
        mainListView.setAdapter(adapter);

        mainListView.setOnItemClickListener(this);
        mainListView.setOnItemLongClickListener(this);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Toast.makeText(this,"Add new reminder",Toast.LENGTH_SHORT).show();
            Reminder r = new Reminder(data.getStringExtra("Name"),data.getStringExtra("Address"));
            remindersLists.add(r);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
       // Toast.makeText(this,"Item "+remindersLists.get(i).getName()+" clicked",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onItemClick: ");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        remindersLists.remove(i);
        adapter.notifyDataSetChanged();
        return true;
    }

    public void createNewReminder(View view) {
        Intent intent = new Intent(this,AddReminderActivity.class);
        startActivityForResult(intent,1);
    }
}


