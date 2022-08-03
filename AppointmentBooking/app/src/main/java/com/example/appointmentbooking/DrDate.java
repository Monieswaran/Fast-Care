 package com.example.appointmentbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

public class DrDate extends AppCompatActivity {
    DatePicker datePicker;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dr_date);

        Intent intent = getIntent();
        id = intent.getExtras().getString("id");

        datePicker = (DatePicker) findViewById(R.id.datePicker1);

        Calendar today = Calendar.getInstance();
        Calendar twoDaysLater = (Calendar) today.clone();
        twoDaysLater.add(Calendar.DATE, 2);
        datePicker.setMinDate(today.getTimeInMillis());
        datePicker.setMaxDate(twoDaysLater.getTimeInMillis());
    }

    public void viewBookings(View view) {
        String NowDate = datePicker.getDayOfMonth() + "-" + (datePicker.getMonth()+1) + "-"  + datePicker.getYear();
        Intent intent = new Intent(this, DoctorAppoinmentsView.class);
        intent.putExtra("date",NowDate);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}