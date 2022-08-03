package com.example.appointmentbooking;

import androidx.appcompat.app.AppCompatActivity;

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

import org.json.JSONException;
import org.json.JSONObject;

public class KidneyReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kidney_report);
    }


    public void KidneySubmit(View view) {
        EditText uid = findViewById(R.id.kidUid);
        EditText name = findViewById(R.id.kidName);
        EditText age = findViewById(R.id.kidAge);
        EditText gender = findViewById(R.id.kidGender);
        EditText repDate = findViewById(R.id.kidRegDate);
        EditText glucose = findViewById(R.id.kidGluco);
        EditText wbc = findViewById(R.id.kidWbc);
        EditText rbc = findViewById(R.id.kidRbc);
        EditText egfr = findViewById(R.id.kideGFR);
        EditText ureaNitrogen = findViewById(R.id.kidUrea);
        EditText sodium = findViewById(R.id.kidSodium);
        EditText potassium = findViewById(R.id.kidPotac);
        EditText cloride = findViewById(R.id.kidChloride);

        String uId = uid.getText().toString();
        String uName = name.getText().toString();
        String uAge = age.getText().toString();
        String uGender = gender.getText().toString();
        String uDate = repDate.getText().toString();
        String u_glucose = glucose.getText().toString();
        String u_wbc = wbc.getText().toString();
        String u_rbc = rbc.getText().toString();
        String u_egfr = egfr.getText().toString();
        String u_ureaNitrogen = ureaNitrogen.getText().toString();
        String u_sodium = sodium.getText().toString();
        String u_potassium = potassium.getText().toString();
        String u_cloride = cloride.getText().toString();


        if(uId.equals("") || uName.equals("") || uAge.equals("") || uGender.equals("") || uDate.equals("")
                || u_glucose.equals("")
                || u_wbc.equals("")
                || u_rbc.equals("")
                || u_egfr.equals("")
                || u_ureaNitrogen.equals("")
                || u_sodium.equals("")
                || u_potassium.equals("")
                || u_cloride.equals("")){
            Toast.makeText(this, "Error!",
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
                postData.put("regDate",uDate);
                postData.put("glucose",u_glucose);
                postData.put("wbc",u_wbc);
                postData.put("rbc",u_rbc);
                postData.put("egfr",u_egfr);
                postData.put("ureaNitrogen",u_ureaNitrogen);
                postData.put("sodium",u_sodium);
                postData.put("potassium",u_potassium);
                postData.put("cloride",u_cloride);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,  helper.HOST+"/report/kidney", postData, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        System.out.println(response.getString("message"));
                        if(response.getString("message").equals("true")){
                            Toast.makeText(KidneyReport.this, "Report OK ",
                                    Toast.LENGTH_LONG).show();
                            load.dismissDialog();
                            finish();
                        }else{
                            Toast.makeText(KidneyReport.this, "Error!",
                                    Toast.LENGTH_LONG).show();
                            load.dismissDialog();
                        }
                    } catch (JSONException e) {
                        load.dismissDialog();
                        Toast.makeText(KidneyReport.this, e.toString(),
                                Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println(error.toString());
                    load.dismissDialog();
                    Toast.makeText(KidneyReport.this, error.toString(),
                            Toast.LENGTH_LONG).show();
                }
            });
            mRequestQueue.add(req);
        }
    }
}