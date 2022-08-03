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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class PatientLogin extends AppCompatActivity {

    private String url = helper.HOST+"/patient";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);
    }

    public void pLogin(View view) throws JSONException {
        EditText email = findViewById(R.id.pemail);
        EditText password = findViewById(R.id.ppassword);
        String pass = password.getText().toString();
        String em = email.getText().toString();
        if(!pass.equals("") || !em.equals("")){
            RequestQueue mRequestQueue = Volley.newRequestQueue(this);
            LoadingDialog load = new LoadingDialog(this);
            load.startLoadingDialog();
            JSONObject postData = new JSONObject();
            postData.put("email", em);
            postData.put("password",pass);
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,url, postData, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        System.out.println(response.getString("message"));
                        if(response.getString("message").equals("true")){
                            DatabaseHandler db = new DatabaseHandler(PatientLogin.this);
                            db.deleteAll();
                            db.newProfile(
                                    Integer.parseInt(response.getString("id")),
                                    response.getString("name"),
                                    response.getString("email"),
                                    response.getString("age"),
                                    "user"
                            );
                            load.dismissDialog();
                            Intent myIntent = new Intent(PatientLogin.this, PatientHome.class);
                            startActivity(myIntent);
                        }else{
                            Toast.makeText(PatientLogin.this, "Invalid Email or Password!",
                                    Toast.LENGTH_LONG).show();
                            load.dismissDialog();
                        }
                    } catch (JSONException e) {
                        load.dismissDialog();
                        Toast.makeText(PatientLogin.this, e.toString(),
                                Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println(error.toString());
                    load.dismissDialog();
                    Toast.makeText(PatientLogin.this, error.toString(),
                            Toast.LENGTH_LONG).show();
                }
            });
            mRequestQueue.add(req);
        }else{
            Toast.makeText(PatientLogin.this, "Please Fill Email and Password!",
                    Toast.LENGTH_LONG).show();
        }
    }


    public void createNewAcc(View view) {
        Intent myIntent = new Intent(PatientLogin.this, PatentSignUp.class);
        startActivity(myIntent);
    }
}