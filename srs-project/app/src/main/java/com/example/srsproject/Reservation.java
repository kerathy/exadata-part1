package com.example.srsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import org.naishadhparmar.zcustomcalendar.CustomCalendar;
import org.naishadhparmar.zcustomcalendar.OnDateSelectedListener;
import org.naishadhparmar.zcustomcalendar.Property;

import java.util.Calendar;
import java.util.HashMap;

public class Reservation extends AppCompatActivity {

    CustomCalendar customCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

//        getSupportActionBar().hide();

        customCalendar = findViewById(R.id.custom_calendar);
        HashMap<Object, Property> map = new HashMap<>();

        Property property = new Property();
        property.layoutResource = R.layout.default_view;
        property.dateTextViewResource = R.id.text_view2;
        map.put("default", property);

        Property currentProperty = new Property();
        currentProperty.layoutResource = R.layout.current_view;
        currentProperty.dateTextViewResource = R.id.text_view3;
        map.put("current", currentProperty);

        customCalendar.setMapDescToProp(map);

        HashMap<Integer, Object> map2 = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        map2.put(calendar.get(Calendar.DAY_OF_MONTH), "current");
        map2.put(1, "default");
        map2.put(2, "default");

        customCalendar.setDate(calendar, map2);


        customCalendar.setOnDateSelectedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(View view, Calendar selectedDate, Object desc) {
                String date = selectedDate.get(Calendar.DAY_OF_MONTH) +
                        "/" + (selectedDate.get(Calendar.MONTH) + 1) +
                        "/" + selectedDate.get(Calendar.YEAR);

                Toast.makeText(getApplicationContext(), date, Toast.LENGTH_SHORT).show();
            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Reservation.this, GuestInformation.class);
                startActivity(intent);
                finish();
            }
        }, 1000);

    }
}