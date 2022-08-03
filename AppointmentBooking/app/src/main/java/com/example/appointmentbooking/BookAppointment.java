






















package com.example.appointmentbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class BookAppointment extends AppCompatActivity {
    String special;
    String date;
    String drId;
    Button slot1;
    Button slot2;
    Button slot3;
    Button slot4;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_appointment);

        LoadingDialog load = new LoadingDialog(this);
        load.startLoadingDialog();
        DatabaseHandler db = new DatabaseHandler(this);
        uid = db.getProfId();

        Intent intent = getIntent();
        special = intent.getExtras().getString("special");
        date = intent.getExtras().getString("date");

        if(special.equals("Eye")){
            drId = "2";
        }else if(special.equals("Covid")){
            drId = "1";
        }else if(special.equals("Kidney")){
            drId = "3";
        }else{
            drId = "4";
        }

         slot1 = findViewById(R.id.slot1);
         slot2 = findViewById(R.id.slot2);
         slot3 = findViewById(R.id.slot3);
         slot4 = findViewById(R.id.slot4);

        RequestQueue mRequestQueue = Volley.newRequestQueue(this);
        JSONObject postData = new JSONObject();
        try {
            postData.put("DoctorId", drId);
            postData.put("bookedOn",date);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,  helper.HOST+"/getBookings", postData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println(response.getString("message"));
                    if(response.getString("message").equals("true")){

                        JSONArray cast = response.getJSONArray("data");
                        System.out.println(cast);
                        System.out.println(cast.length());
                        String s1 = "false";
                        String s2= "false";
                        String s3= "false";
                        String s4= "false";
                        for (int i=0; i<cast.length(); i++) {
                            JSONObject obj = cast.getJSONObject(i);
                            String slotObj = obj.getString("slot");
                            System.out.println(slotObj);
                            if(slotObj.equals("1")){
                                s1 = "true";
                            }else if(slotObj.equals("2")){
                                s2 ="true";
                            }else if(slotObj.equals("3")){
                                s3 = "true";
                            }else{
                                s4 = "true";
                            }
                        }

                        switch (special){
                            case "Covid":{
                                slot1.setText("9.00 - 9.15");
                                slot2.setText("9.16 - 9.30");
                                slot3.setText("9.31 - 9.45");
                                slot4.setText("9.46 - 10.00");
                            }break;
                            case "Eye":{
                                slot1.setText("10.00 - 10.15");
                                slot2.setText("10.16 - 10.30");
                                slot3.setText("10.31 - 10.45");
                                slot4.setText("10.46 - 11.00");
                            }break;
                            case "Kidney": {
                                slot1.setText("8.00 - 8.15");
                                slot2.setText("8.16 - 8.30");
                                slot3.setText("8.31 - 8.45");
                                slot4.setText("8.46 - 9.00");
                            }break;
                            case "Cardiology":{
                                slot1.setText("2.00 - 2.15");
                                slot2.setText("2.16 - 2.30");
                                slot3.setText("2.31 - 2.45");
                                slot4.setText("2.46 - 3.00");
                            }break;
                            default:{
                                System.out.println("Nothing");
                            }
                        }
                        if(s1.equals("false")){
                            slot1.setBackgroundColor(Color.GREEN);
                            slot1.setEnabled(true);
                            slot1.setTextColor(Color.BLACK);
                        }else{
                            slot1.setBackgroundColor(Color.RED);
                            slot1.setTextColor(Color.WHITE);
                            slot1.setEnabled(false);
                        }
                        if(s2.equals("false")){
                            slot2.setBackgroundColor(Color.GREEN);
                            slot2.setEnabled(true);
                            slot2.setTextColor(Color.BLACK);
                        }else{
                            slot2.setBackgroundColor(Color.RED);
                            slot2.setTextColor(Color.WHITE);
                            slot2.setEnabled(false);
                        }
                        if(s3.equals("false")){
                            slot3.setBackgroundColor(Color.GREEN);
                            slot3.setEnabled(true);
                            slot3.setTextColor(Color.BLACK);
                        }else{
                            slot3.setBackgroundColor(Color.RED);
                            slot3.setTextColor(Color.WHITE);
                            slot3.setEnabled(false);
                        }
                        if(s4.equals("false")){
                            slot4.setBackgroundColor(Color.GREEN);
                            slot4.setEnabled(true);
                            slot4.setTextColor(Color.BLACK);
                        }else{
                            slot4.setBackgroundColor(Color.RED);
                            slot4.setTextColor(Color.WHITE);
                            slot4.setEnabled(false);
                        }
                        load.dismissDialog();
                    }else{
                        Toast.makeText(BookAppointment.this, "Error!",
                                Toast.LENGTH_LONG).show();
                        load.dismissDialog();
                    }
                } catch (JSONException e) {
                    load.dismissDialog();
                    Toast.makeText(BookAppointment.this, e.toString(),
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
                load.dismissDialog();
                Toast.makeText(BookAppointment.this, error.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
        mRequestQueue.add(req);
    }

    public void slot1Book(View view) {
        BookAppoinment("1", slot1.getText().toString());
    }
    public void slot2Book(View view) {
        BookAppoinment("2" ,slot2.getText().toString());
    }
    public void slot3Book(View view) {
        BookAppoinment("3",slot3.getText().toString() );
    }
    public void slot4Book(View view) {
        BookAppoinment("4",slot4.getText().toString() );
    }

    void BookAppoinment(String slot, String desc){
        LoadingDialog load = new LoadingDialog(this);
        load.startLoadingDialog();
        RequestQueue mRequestQueue = Volley.newRequestQueue(this);
        JSONObject postData = new JSONObject();
        try {
            postData.put("UserId", uid);
            postData.put("DoctorId",drId);
            postData.put("slot",slot);
            postData.put("desc",desc);
            postData.put("bookedOn",date);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,  helper.HOST+"/book", postData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println(response.getString("message"));
                    String msg = response.getString("message");
                    if(msg.equals("true")){
                        Intent intent = new Intent(BookAppointment.this, PatientHome.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookAppointment.this, "Unable to Book",
                                Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(BookAppointment.this, PatientHome.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
            } catch (JSONException e) {
                load.dismissDialog();
                Toast.makeText(BookAppointment.this, e.toString(),
                        Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            System.out.println(error.toString());
            load.dismissDialog();
            Toast.makeText(BookAppointment.this, error.toString(),
                    Toast.LENGTH_LONG).show();
        }
    });
        mRequestQueue.add(req);
    }
}