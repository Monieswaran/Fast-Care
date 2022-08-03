package com.example.appointmentbooking;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = helper.HOST+"/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);

        DatabaseHandler db = new DatabaseHandler(this);
        String res = db.checkLogin();
        System.out.println(res);
        if(res.equals("dr")){
            Intent myIntent = new Intent(this, DrHome.class);
            startActivity(myIntent);
        }else if(res.equals("user")){
            Intent myIntent = new Intent(this, PatientHome.class);
            startActivity(myIntent);
        }else{
        setContentView(R.layout.activity_main);
        }
    }


    public void drLogin(View view) {
        Intent myIntent = new Intent(this, DrLogin.class);
        startActivity(myIntent);
//        sendAndRequestResponse();
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//            }
//        }, 3000L);
    }
    public void patBtn(View view) {
        Intent myIntent = new Intent(this, PatientLogin.class);
        startActivity(myIntent);
    }
    private void sendAndRequestResponse() {
        mRequestQueue = Volley.newRequestQueue(this);
        LoadingDialog load = new LoadingDialog(this);
        load.startLoadingDialog();
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println(response.getString("message"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                load.dismissDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
                load.dismissDialog();
            }
        });
        mRequestQueue.add(req);
    }
}