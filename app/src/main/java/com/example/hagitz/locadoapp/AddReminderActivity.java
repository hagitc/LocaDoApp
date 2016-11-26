package com.example.hagitz.locadoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddReminderActivity extends AppCompatActivity {

    EditText Name;
    EditText Address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);
        Name = (EditText) findViewById(R.id.edName);
        Address = (EditText) findViewById(R.id.edLoc);
    }

    public void createRemider(View view)
    {
        String fName = Name.getText().toString();
        String lName = Address.getText().toString();

        Intent i = new Intent();
        i.putExtra("Name",fName);
        i.putExtra("Address",lName);
        setResult(RESULT_OK,i);
        finish();
    }
}

