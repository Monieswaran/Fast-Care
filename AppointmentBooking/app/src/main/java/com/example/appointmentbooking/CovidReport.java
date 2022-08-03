package com.example.appointmentbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class CovidReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.covid_report);
    }

    public void uploadCovidReport(View view) {
        EditText uid = findViewById(R.id.covUid),
                name = findViewById(R.id.covName),
                age = findViewById(R.id.covAge),
                gender = findViewById(R.id.covGender),
                rdate = findViewById(R.id.covRegDate),
                date = findViewById(R.id.covColDate),
                desc = findViewById(R.id.covTestDes),
                vaccine = findViewById(R.id.covVacine);

        String uId = uid.getText().toString();
        String uName = name.getText().toString();
        String uAge = age.getText().toString();
        String uGender = gender.getText().toString();
        String uDate = date.getText().toString();
        String uRDate = rdate.getText().toString();
        String uDes = desc.getText().toString();
        String uVaccine = vaccine.getText().toString();
        if(uId.equals("") || uName.equals("") || uAge.equals("") || uGender.equals("") || uDate.equals("") || uDes.equals("") || uVaccine.equals("")){
            Toast.makeText(CovidReport.this, "Error!",
                    Toast.LENGTH_LONG).show();
        }
        else{
            LoadingDialog load = new LoadingDialog(this);
            load.startLoadingDialog();

            RequestQueue mRequestQueue = Volley.newRequestQueue(this);
            JSONObject postData = new JSONObject();
            try {
                postData.put("uid", uId);
                postData.put("name",uName);
                postData.put("age",uAge);
                postData.put("gender",uGender);
                postData.put("regDate",uRDate);
                postData.put("collectedDate",uDate);
                postData.put("desc",uDes);
                postData.put("vaccine",uVaccine);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,  helper.HOST+"/report/covid", postData, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        System.out.println(response.getString("message"));
                        if(response.getString("message").equals("true")){
                            Toast.makeText(CovidReport.this, "Report OK ",
                                    Toast.LENGTH_LONG).show();
                            load.dismissDialog();
                            finish();
                        }else{
                            Toast.makeText(CovidReport.this, "Error!",
                                    Toast.LENGTH_LONG).show();
                            load.dismissDialog();
                        }
                    } catch (JSONException e) {
                        load.dismissDialog();
                        Toast.makeText(CovidReport.this, e.toString(),
                                Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println(error.toString());
                    load.dismissDialog();
                    Toast.makeText(CovidReport.this, error.toString(),
                            Toast.LENGTH_LONG).show();
                }
            });
            mRequestQueue.add(req);
        }
    }
}