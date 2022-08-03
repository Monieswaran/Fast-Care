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

public class EyeReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eye_report);
    }

    public void EyeSubmit(View view) {
        EditText uid = findViewById(R.id.eyeUid);
        EditText name = findViewById(R.id.eyeName);
        EditText age = findViewById(R.id.eyeAge);
        EditText gender = findViewById(R.id.eyeGender);
        EditText repDate = findViewById(R.id.eyeRegDate);
        EditText re_dist_sph = findViewById(R.id.eyeDistsphR);
        EditText re_dist_cyl = findViewById(R.id.eyeDistcylR);
        EditText re_near_sph = findViewById(R.id.eyeNearsphR);
        EditText re_near_cyl = findViewById(R.id.eyeNearcylR);
        EditText le_dist_sph = findViewById(R.id.eyeDistSphL);
        EditText le_dist_cyl = findViewById(R.id.eyeDistClyL);
        EditText le_near_sph = findViewById(R.id.eyeNearSphL);
        EditText le_near_cyl = findViewById(R.id.eyeNearClyL);
        EditText use = findViewById(R.id.eyeUse);

        String uId = uid.getText().toString();
        String uName = name.getText().toString();
        String uAge = age.getText().toString();
        String uGender = gender.getText().toString();
        String uDate = repDate.getText().toString();
        String u_re_dist_sph = re_dist_sph.getText().toString();
        String u_re_dist_cyl = re_dist_cyl.getText().toString();
        String u_re_near_sph = re_near_sph.getText().toString();
        String u_re_near_cyl = re_near_cyl.getText().toString();
        String u_le_dist_sph = le_dist_sph.getText().toString();
        String u_le_dist_cyl = le_dist_cyl.getText().toString();
        String u_le_near_sph = le_near_sph.getText().toString();
        String u_le_near_cyl = le_near_cyl.getText().toString();
        String u_use = use.getText().toString();


        if(uId.equals("") || uName.equals("") || uAge.equals("") || uGender.equals("") || uDate.equals("")
                || u_re_dist_sph.equals("")
                || u_re_dist_cyl.equals("")
                || u_re_near_sph.equals("")
                || u_re_near_cyl.equals("")
                || u_le_dist_sph.equals("")
                || u_le_dist_cyl.equals("")
                || u_le_near_sph.equals("")
                || u_le_near_cyl.equals("")
                || u_use.equals("")
        ){
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
                postData.put("re_dist_sph",u_re_dist_sph);
                postData.put("re_dist_cyl",u_re_dist_cyl);
                postData.put("re_near_sph",u_re_near_sph);
                postData.put("re_near_cyl",u_re_near_cyl);
                postData.put("le_dist_sph",u_le_dist_sph);
                postData.put("le_dist_cyl",u_le_dist_cyl);
                postData.put("le_near_sph",u_le_near_sph);
                postData.put("le_near_cyl",u_le_near_cyl);
                postData.put("use",u_use);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,  helper.HOST+"/report/eye", postData, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        System.out.println(response.getString("message"));
                        if(response.getString("message").equals("true")){
                            Toast.makeText(EyeReport.this, "Report OK ",
                                    Toast.LENGTH_LONG).show();
                            load.dismissDialog();
                            finish();
                        }else{
                            Toast.makeText(EyeReport.this, "Error!",
                                    Toast.LENGTH_LONG).show();
                            load.dismissDialog();
                        }
                    } catch (JSONException e) {
                        load.dismissDialog();
                        Toast.makeText(EyeReport.this, e.toString(),
                                Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println(error.toString());
                    load.dismissDialog();
                    Toast.makeText(EyeReport.this, error.toString(),
                            Toast.LENGTH_LONG).show();
                }
            });
            mRequestQueue.add(req);
        }
    }
}