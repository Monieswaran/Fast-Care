package com.example.appointmentbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        LoadingDialog load = new LoadingDialog(this);
        load.startLoadingDialog();

        Intent intent = getIntent();
        String role = intent.getExtras().getString("role");
        String id = intent.getExtras().getString("id");

        DatabaseHandler db = new DatabaseHandler(this);
        HashMap<String,String> data =  db.getProfile(Integer.parseInt(id));

        TextView nameTv = findViewById(R.id.profName);
        TextView emailTv = findViewById(R.id.profEmail);
        TextView extraTvKey = findViewById(R.id.oProfkey);
        TextView extraTvVal = findViewById(R.id.oProfVal);

        nameTv.setText(data.get("name"));
        emailTv.setText(data.get("email"));
        if(role.equals("user")){
            extraTvKey.setText("Age ");
            extraTvVal.setText(data.get("age"));
        }else{
            extraTvKey.setText("Special ");
            extraTvVal.setText(data.get("age"));
        }
        load.dismissDialog();
    }
}