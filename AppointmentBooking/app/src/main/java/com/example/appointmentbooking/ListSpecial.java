package com.example.appointmentbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class ListSpecial extends AppCompatActivity {
    DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_special);
        datePicker = (DatePicker) findViewById(R.id.datePicker);

        // disable dates before two days and after two days after today
        Calendar today = Calendar.getInstance();
//        Calendar twoDaysAgo = (Calendar) today.clone();
//        twoDaysAgo.add(Calendar.DATE, -2);
        Calendar twoDaysLater = (Calendar) today.clone();
        twoDaysLater.add(Calendar.DATE, 2);
        datePicker.setMinDate(today.getTimeInMillis());
        datePicker.setMaxDate(twoDaysLater.getTimeInMillis());
    }

    public void covidBook(View view) {
        String NowDate = datePicker.getDayOfMonth() + "-" + (datePicker.getMonth()+1) + "-"  + datePicker.getYear();
        Intent intent = new Intent(this, BookAppointment.class);
        intent.putExtra("special","Covid");
        intent.putExtra("date",NowDate);
        startActivity(intent);
    }

    public void eyeBook(View view) {
        String NowDate = datePicker.getDayOfMonth() + "-" + (datePicker.getMonth()+1) + "-"  + datePicker.getYear();
        Intent intent = new Intent(this, BookAppointment.class);
        intent.putExtra("special","Eye");
        intent.putExtra("date",NowDate);
        startActivity(intent);
    }

    public void kidnyBook(View view) {
        String NowDate = datePicker.getDayOfMonth() + "-" + (datePicker.getMonth()+1) + "-"  + datePicker.getYear();
        Intent intent = new Intent(this, BookAppointment.class);
        intent.putExtra("special","Kidney");
        intent.putExtra("date",NowDate);
        startActivity(intent);
    }

    public void cardiologyBook(View view) {
        String NowDate = datePicker.getDayOfMonth() + "-" + (datePicker.getMonth()+1) + "-"  + datePicker.getYear();
        Intent intent = new Intent(this, BookAppointment.class);
        intent.putExtra("special","Cardiology");
        intent.putExtra("date",NowDate);
        startActivity(intent);
    }
}