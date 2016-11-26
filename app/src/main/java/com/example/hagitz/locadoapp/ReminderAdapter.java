package com.example.hagitz.locadoapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hagitz on 11/26/2016.
 */
public class ReminderAdapter extends ArrayAdapter<Reminder> {


    private final Context context;
    private final ArrayList<Reminder> valuesList;

    TextView tvName;
    TextView tvAddress;
    ImageButton imgBtn;

    public ReminderAdapter(Context context,  ArrayList<Reminder> objects) {
        super(context,R.layout.reminder_item, objects);
        this.context = context;
        this.valuesList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.reminder_item, parent, false);

        tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvAddress = (TextView) rowView.findViewById(R.id.tvAddress);
        imgBtn = (ImageButton) rowView.findViewById(R.id.btnState);

        tvName.setText(valuesList.get(position).getName());
        tvAddress.setText(valuesList.get(position).getDAddress());
        imgBtn.setImageResource(R.drawable.alarm);
        imgBtn.setBackgroundColor(Color.GREEN);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageButton mg = (ImageButton) view.findViewById(R.id.btnState);
                mg.setImageResource(R.drawable.alarmblue);
            }
        });
        return rowView;
    }
}
