package com.example.appointmentbooking;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class DrHome extends AppCompatActivity {
    String id;
    String special;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        DatabaseHandler db = new DatabaseHandler(this);
        id = db.getProfId();
        setContentView(R.layout.activity_dr_home);
        Intent intent = getIntent();
        special = intent.getExtras().getString("special");
    }

    public void drProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        intent.putExtra("role","dr");
        intent.putExtra("id",id);
        startActivity(intent);
    }

    public void drReport(View view) {
        if(special.equals("Eye")){
            Intent intent = new Intent(this, EyeReport.class);
            startActivity(intent);
        }else if(special.equals("Covid")){
            Intent intent = new Intent(this, CovidReport.class);
            startActivity(intent);
        }else if(special.equals("Kidney")){
            Intent intent = new Intent(this, KidneyReport.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, CardioReport.class);
            startActivity(intent);
        }
    }

    public void drAppoitment(View view) {
        Intent intent = new Intent(this, DrDate.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }

    public void drAbout(View view) {
        Intent intent = new Intent(this, DrAbout.class);
        startActivity(intent);
    }

    public void logOut(View view) {
        DatabaseHandler db = new DatabaseHandler(DrHome.this);
        db.deleteAll();
        Intent intent = new Intent(DrHome.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}