package com.example.appointmentbooking;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
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

public class PatentSignUp extends AppCompatActivity {
    private String url = helper.HOST+"/patient/reg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patent_sign_up);
    }

//    public void pSignUp(View view) {
//        Intent intent = new Intent(PatentSignUp.this, PatientLogin.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);
//    }
    public void pSignUp(View view) throws JSONException {
        EditText emailEt = findViewById(R.id.pEmail);
        EditText passwordEt = findViewById(R.id.pPassword);
        EditText nameEt = findViewById(R.id.pName);
        EditText ageEt = findViewById(R.id.pAge);

        String password = passwordEt.getText().toString();
        String email = emailEt.getText().toString();
        String name = nameEt.getText().toString();
        String age = ageEt.getText().toString();
        if(!password.equals("") || !email.equals("") || !name.equals("") || !age.equals("")){
            RequestQueue mRequestQueue = Volley.newRequestQueue(this);
            LoadingDialog load = new LoadingDialog(this);
            load.startLoadingDialog();
            JSONObject postData = new JSONObject();
            postData.put("email", email);
            postData.put("password",password);
            postData.put("age",age);
            postData.put("name",name);
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,url, postData, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        System.out.println(response.getString("message"));
                        if(response.getString("message").equals("true")){
                            load.dismissDialog();
                            Toast.makeText(PatentSignUp.this, "You can Login Now!",
                                    Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(PatentSignUp.this, PatientLogin.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);

                        }else{
                            Toast.makeText(PatentSignUp.this, "Invalid Information!",
                                    Toast.LENGTH_LONG).show();
                            load.dismissDialog();
                        }
                    } catch (JSONException e) {
                        load.dismissDialog();
                        Toast.makeText(PatentSignUp.this, e.toString(),
                                Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println(error.toString());
                    load.dismissDialog();
                    Toast.makeText(PatentSignUp.this, error.toString(),
                            Toast.LENGTH_LONG).show();
                }
            });
            mRequestQueue.add(req);
        }else{
            Toast.makeText(PatentSignUp.this, "Please Fill Email and Password!",
                    Toast.LENGTH_LONG).show();
        }
    }

}