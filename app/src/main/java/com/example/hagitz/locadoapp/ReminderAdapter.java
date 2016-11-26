package com.example.hagitz.locadoapp;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
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
    ImageView img;

    public ReminderAdapter(Context context,  ArrayList<Reminder> objects) {
        super(context,R.layout.reminder_item, objects);
        this.context = context;
        this.valuesList = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.reminder_item, parent, false);

        tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvAddress = (TextView) rowView.findViewById(R.id.tvAddress);
        img = (ImageView) rowView.findViewById(R.id.imgState);

        tvName.setText(valuesList.get(position).getName());
        tvAddress.setText(valuesList.get(position).getDAddress());
        img.setImageResource(R.drawable.alarmblue);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valuesList.get(position).changeState();
                boolean state= valuesList.get(position).isState();
                ImageView mg = (ImageView) view.findViewById(R.id.imgState);
                if(state)
                    mg.setImageResource(R.drawable.alarmblue);
                else
                    mg.setImageResource(R.drawable.alarm);
            }
        });
        return rowView;
    }
}
