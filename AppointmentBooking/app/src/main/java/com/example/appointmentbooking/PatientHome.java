package com.example.appointmentbooking;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class PatientHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);
    }

    public void searchBtn(View view) {
        Intent intent = new Intent(this, PatentReportSelect.class);
        startActivity(intent);
//        Toast.makeText(this, "Search Page",
//                Toast.LENGTH_LONG).show();
    }

    public void profileBtn(View view) {
        DatabaseHandler db = new DatabaseHandler(this);
        String id = db.getProfId();
        Intent intent = new Intent(this, Profile.class);
        intent.putExtra("role","user");
        intent.putExtra("id",id);
        startActivity(intent);
    }

    public void appoinmentBtn(View view) {
        Intent intent = new Intent(this, ListSpecial.class);
        startActivity(intent);
    }

    public void aboutBtn(View view) {
//        Toast.makeText(this, "About Page",
//                Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, PatientAbout.class);
        startActivity(intent);
    }

    public void apoinmentList(View view) {
//        Toast.makeText(this, "View Previus Appoitment Page",
//                Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, AllAppoinmentsP.class);
        startActivity(intent);
    }

    public void logOut(View view) {
        DatabaseHandler db = new DatabaseHandler(PatientHome.this);
        db.deleteAll();
        Intent intent = new Intent(PatientHome.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}