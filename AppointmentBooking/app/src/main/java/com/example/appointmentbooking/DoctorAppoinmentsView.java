 package com.example.appointmentbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DoctorAppoinmentsView extends AppCompatActivity {

    ListView listView;
    ArrayList<String> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_appoinments_view);

        RequestQueue mRequestQueue = Volley.newRequestQueue(this);
        LoadingDialog load = new LoadingDialog(this);
        load.startLoadingDialog();

        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");

        JSONObject postData = new JSONObject();
        try {
            postData.put("DoctorId",id );
            postData.put("bookedOn",intent.getExtras().getString("date"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,helper.HOST+"/dr/bookings", postData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println(response.getString("message"));
                    if (response.getString("message").equals("true")) {
                        JSONArray cast = response.getJSONArray("data");
                        for (int i=0; i<cast.length(); i++) {
                            JSONObject obj = cast.getJSONObject(i);
                            String bookedOn = obj.getString("bookedOn");
                            String slot = obj.getString("desc");
                            String name = obj.getString("name");
                            String da = slot +"  " +name+"  - "+bookedOn;
                            System.out.println(da);
                            listData.add(da);
                        }
                        listView = findViewById(R.id.appList);
                        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(
                                DoctorAppoinmentsView.this,
                                android.R.layout.simple_list_item_1,
                                listData
                        );
                        listView.setAdapter(arrayAdapter);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String selectedItem = (String) parent.getItemAtPosition(position);
                                Toast.makeText(DoctorAppoinmentsView.this, selectedItem,Toast.LENGTH_LONG).show();
                            }
                        });
                        load.dismissDialog();

                    }else{
                        Toast.makeText(DoctorAppoinmentsView.this, "Invalid Email or Password!",
                                Toast.LENGTH_LONG).show();
                        load.dismissDialog();
                    }
                } catch (JSONException e) {
                    load.dismissDialog();
                    Toast.makeText(DoctorAppoinmentsView.this, e.toString(),
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
                load.dismissDialog();
                Toast.makeText(DoctorAppoinmentsView.this, error.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
        mRequestQueue.add(req);
    }
}