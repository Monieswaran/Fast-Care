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

public class CardioReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardio_report);

    }

    public void CardioSubmit(View view) {
        EditText uid = findViewById(R.id.carUid);
        EditText name = findViewById(R.id.carName);
        EditText age = findViewById(R.id.carAge);
        EditText gender = findViewById(R.id.carGender);
        EditText repDate = findViewById(R.id.carRegDate);
        EditText weight = findViewById(R.id.carWeight);
        EditText height = findViewById(R.id.carHeight);
        EditText risk = findViewById(R.id.carRisk);
        EditText bbp = findViewById(R.id.carBaseBp);
        EditText pbp = findViewById(R.id.carPeakBp);
        EditText bhp = findViewById(R.id.carBaseHp);
        EditText php = findViewById(R.id.carPeakHp);
        EditText bp = findViewById(R.id.carBP);
        EditText hp = findViewById(R.id.carHP);
        EditText med = findViewById(R.id.carMed);

        String uId = uid.getText().toString();
        String uName = name.getText().toString();
        String uAge = age.getText().toString();
        String uGender = gender.getText().toString();
        String uDate = repDate.getText().toString();
        String uWeight = weight.getText().toString();
        String uheight = height.getText().toString();
        String uRisk = risk.getText().toString();
        String ubbp = bbp.getText().toString();
        String upbp = pbp.getText().toString();
        String ubhp = bhp.getText().toString();
        String uphp = php.getText().toString();
        String ubp = bp.getText().toString();
        String uhp = hp.getText().toString();
        String umed = med.getText().toString();


        if(uId.equals("") || uName.equals("") || uAge.equals("") || uGender.equals("") || uDate.equals("")
                || uWeight.equals("")
                || uRisk.equals("")
                || ubbp.equals("")
                || upbp.equals("")
                || ubhp.equals("")
                || uphp.equals("")
                || ubp.equals("")
                || uhp.equals("")
                || umed.equals("")
                || uheight.equals("")){
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
                postData.put("weight",uWeight);
                postData.put("height",uheight);
                postData.put("riskfactor",uRisk);
                postData.put("baseBp",ubbp);
                postData.put("peakBp",upbp);
                postData.put("baseHp",ubhp);
                postData.put("peakHp",uphp);
                postData.put("bp",ubp);
                postData.put("hp",uhp);
                postData.put("medications",umed);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,  helper.HOST+"/report/cardio", postData, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        System.out.println(response.getString("message"));
                        if(response.getString("message").equals("true")){
                            Toast.makeText(CardioReport.this, "Report OK ",
                                    Toast.LENGTH_LONG).show();
                            load.dismissDialog();
                            finish();
                        }else{
                            Toast.makeText(CardioReport.this, "Error!",
                                    Toast.LENGTH_LONG).show();
                            load.dismissDialog();
                        }
                    } catch (JSONException e) {
                        load.dismissDialog();
                        Toast.makeText(CardioReport.this, e.toString(),
                                Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println(error.toString());
                    load.dismissDialog();
                    Toast.makeText(CardioReport.this, error.toString(),
                            Toast.LENGTH_LONG).show();
                }
            });
            mRequestQueue.add(req);
        }
    }
}