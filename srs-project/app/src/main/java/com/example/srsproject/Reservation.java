package com.example.srsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.srsproject.guest.GuestInformation;
import com.squareup.timessquare.CalendarPickerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Reservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);

        CalendarPickerView calendarPickerView = findViewById(R.id.calendarPickerView);
        calendarPickerView.init(today, calendar.getTime())
                .inMode(CalendarPickerView.SelectionMode.RANGE)
                .withSelectedDate(today);

        TextView textViewCheckIn = findViewById(R.id.check_in_date);
        TextView textViewCheckOut = findViewById(R.id.check_out_date);
        TextView textViewNights = findViewById(R.id.nights);

        calendarPickerView.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                List<Date> dates = calendarPickerView.getSelectedDates();
                String totalDates = dates.size() + "";
                Date checkInDate = dates.get(0);
                Date checkOutDate = dates.get(dates.size() - 1);

                String format = "yyyy/MM/dd";
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);

                String checkInDateStr = sdf.format(checkInDate);
                String checkOutDateStr = sdf.format(checkOutDate);

                textViewCheckIn.setText(checkInDateStr);
                textViewCheckOut.setText(checkOutDateStr);
                textViewNights.setText(totalDates);
                System.out.println("Nights: " + textViewNights.getText());
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });

        ElegantNumberButton adultsButton = findViewById(R.id.adults);
        ElegantNumberButton bedsButton = findViewById(R.id.beds);
        ElegantNumberButton childrenButton = findViewById(R.id.children);

        adultsButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("adults: " + adultsButton.getNumber());
            }
        });

        bedsButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("beds: " + bedsButton.getNumber());
            }
        });

        childrenButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("children: " + childrenButton.getNumber());
            }
        });


        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Reservation.this, GuestInformation.class));
            }
        });

    }
}