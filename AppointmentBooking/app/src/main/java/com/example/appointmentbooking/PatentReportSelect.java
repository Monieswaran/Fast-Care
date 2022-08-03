package com.example.appointmentbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PatentReportSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_select_patent);
    }

    public void covidReport(View view) {
        Intent intent = new Intent(this, SearchReport.class);
        intent.putExtra("special","Covid");
        startActivity(intent);
    }

    public void eyeReport(View view) {
        Intent intent = new Intent(this, SearchReport.class);
        intent.putExtra("special","Eye");
        startActivity(intent);
    }

    public void kidnyReport(View view) {
        Intent intent = new Intent(this, SearchReport.class);
        intent.putExtra("special","Kidney");
        startActivity(intent);
    }

    public void cardiologyReport(View view) {
        Intent intent = new Intent(this, SearchReport.class);
        intent.putExtra("special","Cardiology");
        startActivity(intent);
    }
}