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

public class SearchReport extends AppCompatActivity {

    String special;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_report);

        Intent intent = getIntent();
        special = intent.getExtras().getString("special");
    }

    public void SearchUid(View view) throws JSONException {
        EditText ed1 = findViewById(R.id.searchUid);
        String s = ed1.getText().toString();
        if(s.equals("")){
            Toast.makeText(this,"Enter A Number",
                    Toast.LENGTH_LONG).show();
        }else{
            RequestQueue mRequestQueue = Volley.newRequestQueue(this);
            LoadingDialog load = new LoadingDialog(this);
            load.startLoadingDialog();
            JSONObject postData = new JSONObject();
            postData.put("uid", s);
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,helper.HOST+"/search/"+special, postData, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    try {
                        System.out.println(response.getString("message"));
                        if(response.getString("message").equals("true")){
                            load.dismissDialog();
                            if(special.equals("Eye")){
                                JSONArray cast = response.getJSONArray("data");
                                if(cast.length() >=1){
                                    JSONObject obj = cast.getJSONObject(0);
                                    System.out.println(obj);
                                    Intent intent = new Intent(SearchReport.this, Preports.class);
                                    intent.putExtra("key1","UID");
                                    intent.putExtra("val1",obj.getString("uid"));
                                    intent.putExtra("val2",obj.getString("name"));
                                    intent.putExtra("key2","Name");
                                    intent.putExtra("val3",obj.getString("age"));
                                    intent.putExtra("key3","Age");
                                    intent.putExtra("val4",obj.getString("gender"));
                                    intent.putExtra("key4","Gender");
                                    intent.putExtra("val5",obj.getString("regDate"));
                                    intent.putExtra("key5","Registered Date");
                                    intent.putExtra("val6","RE - OD");
                                    intent.putExtra("key6","");
                                    intent.putExtra("val7",obj.getString("re_dist_sph"));
                                    intent.putExtra("key7","DIST SPH");
                                    intent.putExtra("val8",obj.getString("re_dist_cyl"));
                                    intent.putExtra("key8","DIST CYL");
                                    intent.putExtra("val9",obj.getString("re_near_sph"));
                                    intent.putExtra("key9","NEAR SPH");
                                    intent.putExtra("val10",obj.getString("re_near_cyl"));
                                    intent.putExtra("key10","NEAR CYL");
                                    intent.putExtra("val11","LE - OS");
                                    intent.putExtra("key11","");
                                    intent.putExtra("val12",obj.getString("le_dist_sph"));
                                    intent.putExtra("key12","DIST SPH");
                                    intent.putExtra("val13",obj.getString("le_dist_cyl"));
                                    intent.putExtra("key13","DIST SPH");
                                    intent.putExtra("val14",obj.getString("le_near_sph"));
                                    intent.putExtra("key14","NEAR SPH");
                                    intent.putExtra("val15",obj.getString("le_near_cyl"));
                                    intent.putExtra("key15","NEAR CYL");
                                    intent.putExtra("val16","");
                                    intent.putExtra("key16","");
                                    intent.putExtra("val17",obj.getString("use"));
                                    intent.putExtra("key17","USE");
                                    intent.putExtra("val18","");
                                    intent.putExtra("key18","");
                                    intent.putExtra("val19","");
                                    intent.putExtra("key19","");
                                    intent.putExtra("val20","");
                                    intent.putExtra("key20","");
                                    startActivity(intent);
                                }else
                                {
                                    Intent intent = new Intent(SearchReport.this, Preports.class);
                                    intent.putExtra("val1","No Report Found");
                                    intent.putExtra("key1","");
                                    intent.putExtra("val2","");
                                    intent.putExtra("key2","");
                                    intent.putExtra("val3","");
                                    intent.putExtra("key3","");
                                    intent.putExtra("val4","");
                                    intent.putExtra("key4","");
                                    intent.putExtra("val5","");
                                    intent.putExtra("key5","");
                                    intent.putExtra("val6","");
                                    intent.putExtra("key6","");
                                    intent.putExtra("val7","");
                                    intent.putExtra("key7","");
                                    intent.putExtra("val8","");
                                    intent.putExtra("key8","");
                                    intent.putExtra("val9","");
                                    intent.putExtra("key9","");
                                    intent.putExtra("val10","");
                                    intent.putExtra("key10","");
                                    intent.putExtra("val11","");
                                    intent.putExtra("key11","");
                                    intent.putExtra("val12","");
                                    intent.putExtra("key12","");
                                    intent.putExtra("val13","");
                                    intent.putExtra("key13","");
                                    intent.putExtra("val14","");
                                    intent.putExtra("key14","");
                                    intent.putExtra("val15","");
                                    intent.putExtra("key15","");
                                    intent.putExtra("val16","");
                                    intent.putExtra("key16","");
                                    intent.putExtra("val17","");
                                    intent.putExtra("key17","");
                                    intent.putExtra("val18","");
                                    intent.putExtra("key18","");
                                    intent.putExtra("val19","");
                                    intent.putExtra("key19","");
                                    intent.putExtra("val20","");
                                    intent.putExtra("key20","");
                                    startActivity(intent);
                                }
                            }else
                                if(special.equals("Covid")){
                                JSONArray cast = response.getJSONArray("data");
                                System.out.println(cast);
                                if(cast.length() >=1){
                                    JSONObject obj = cast.getJSONObject(0);
                                    System.out.println(obj);
                                    Intent intent = new Intent(SearchReport.this, Preports.class);
                                    intent.putExtra("key1","UID");
                                    intent.putExtra("val1",obj.getString("uid"));
                                    intent.putExtra("val2",obj.getString("name"));
                                    intent.putExtra("key2","Name");
                                    intent.putExtra("val3",obj.getString("age"));
                                    intent.putExtra("key3","Age");
                                    intent.putExtra("val4",obj.getString("gender"));
                                    intent.putExtra("key4","Gender");
                                    intent.putExtra("val5",obj.getString("regDate"));
                                    intent.putExtra("key5","regDate");
                                    intent.putExtra("val6",obj.getString("collectedDate"));
                                    intent.putExtra("key6","Collected Date");
                                    intent.putExtra("val7",obj.getString("desc"));
                                    intent.putExtra("key7","Test Description ");
                                    intent.putExtra("val8",obj.getString("vaccine"));
                                    intent.putExtra("key8","Vaccine");
                                    intent.putExtra("val9","");
                                    intent.putExtra("key9","");
                                    intent.putExtra("val10","");
                                    intent.putExtra("key10","");
                                    intent.putExtra("val11","");
                                    intent.putExtra("key11","");
                                    intent.putExtra("val12","");
                                    intent.putExtra("key12","");
                                    intent.putExtra("val13","");
                                    intent.putExtra("key13","");
                                    intent.putExtra("val14","");
                                    intent.putExtra("key14","");
                                    intent.putExtra("val15","");
                                    intent.putExtra("key15","");
                                    intent.putExtra("val16","");
                                    intent.putExtra("key16","");
                                    intent.putExtra("val17","");
                                    intent.putExtra("key17","");
                                    intent.putExtra("val18","");
                                    intent.putExtra("key18","");
                                    intent.putExtra("val19","");
                                    intent.putExtra("key19","");
                                    intent.putExtra("val20","");
                                    intent.putExtra("key20","");
                                    startActivity(intent);
                                }else
                                    {
                                    Intent intent = new Intent(SearchReport.this, Preports.class);
                                    intent.putExtra("val1","No Report Found");
                                    intent.putExtra("key1","");
                                    intent.putExtra("val2","");
                                    intent.putExtra("key2","");
                                    intent.putExtra("val3","");
                                    intent.putExtra("key3","");
                                    intent.putExtra("val4","");
                                    intent.putExtra("key4","");
                                    intent.putExtra("val5","");
                                    intent.putExtra("key5","");
                                    intent.putExtra("val6","");
                                    intent.putExtra("key6","");
                                    intent.putExtra("val7","");
                                    intent.putExtra("key7","");
                                    intent.putExtra("val8","");
                                    intent.putExtra("key8","");
                                    intent.putExtra("val9","");
                                    intent.putExtra("key9","");
                                    intent.putExtra("val10","");
                                    intent.putExtra("key10","");
                                    intent.putExtra("val11","");
                                    intent.putExtra("key11","");
                                    intent.putExtra("val12","");
                                    intent.putExtra("key12","");
                                    intent.putExtra("val13","");
                                    intent.putExtra("key13","");
                                    intent.putExtra("val14","");
                                    intent.putExtra("key14","");
                                    intent.putExtra("val15","");
                                    intent.putExtra("key15","");
                                    intent.putExtra("val16","");
                                    intent.putExtra("key16","");
                                    intent.putExtra("val17","");
                                    intent.putExtra("key17","");
                                    intent.putExtra("val18","");
                                    intent.putExtra("key18","");
                                    intent.putExtra("val19","");
                                    intent.putExtra("key19","");
                                    intent.putExtra("val20","");
                                    intent.putExtra("key20","");
                                    startActivity(intent);
                                }
                            }else
                                if(special.equals("Kidney")){
                                JSONArray cast = response.getJSONArray("data");
                                if(cast.length() >=1){
                                    JSONObject obj = cast.getJSONObject(0);
                                    System.out.println(obj);
                                    Intent intent = new Intent(SearchReport.this, Preports.class);
                                    intent.putExtra("key1","UID");
                                    intent.putExtra("val1",obj.getString("uid"));
                                    intent.putExtra("val2",obj.getString("name"));
                                    intent.putExtra("key2","Name");
                                    intent.putExtra("val3",obj.getString("age"));
                                    intent.putExtra("key3","Age");
                                    intent.putExtra("val4",obj.getString("gender"));
                                    intent.putExtra("key4","Gender");
                                    intent.putExtra("val5",obj.getString("regDate"));
                                    intent.putExtra("key5","Registered Date");
                                    intent.putExtra("val6",obj.getString("glucose"));
                                    intent.putExtra("key6","Glucose");
                                    intent.putExtra("val7",obj.getString("wbc"));
                                    intent.putExtra("key7","WBC");
                                    intent.putExtra("val8",obj.getString("rbc"));
                                    intent.putExtra("key8","RBC");
                                    intent.putExtra("val9",obj.getString("egfr"));
                                    intent.putExtra("key9","eGFR");
                                    intent.putExtra("val10",obj.getString("ureaNitrogen"));
                                    intent.putExtra("key10","UREA NITROGEN");
                                    intent.putExtra("val11",obj.getString("sodium"));
                                    intent.putExtra("key11","Sodium");
                                    intent.putExtra("val12",obj.getString("potassium"));
                                    intent.putExtra("key12","Potassium");
                                    intent.putExtra("val13",obj.getString("cloride"));
                                    intent.putExtra("key13","Chloride");
                                    intent.putExtra("val14","");
                                    intent.putExtra("key14","");
                                    intent.putExtra("val15","");
                                    intent.putExtra("key15","");
                                    intent.putExtra("val16","");
                                    intent.putExtra("key16","");
                                    intent.putExtra("val17","");
                                    intent.putExtra("key17","");
                                    intent.putExtra("val18","");
                                    intent.putExtra("key18","");
                                    intent.putExtra("val19","");
                                    intent.putExtra("key19","");
                                    intent.putExtra("val20","");
                                    intent.putExtra("key20","");
                                    startActivity(intent);
                                }else
                                {
                                    Intent intent = new Intent(SearchReport.this, Preports.class);
                                    intent.putExtra("val1","No Report Found");
                                    intent.putExtra("key1","");
                                    intent.putExtra("val2","");
                                    intent.putExtra("key2","");
                                    intent.putExtra("val3","");
                                    intent.putExtra("key3","");
                                    intent.putExtra("val4","");
                                    intent.putExtra("key4","");
                                    intent.putExtra("val5","");
                                    intent.putExtra("key5","");
                                    intent.putExtra("val6","");
                                    intent.putExtra("key6","");
                                    intent.putExtra("val7","");
                                    intent.putExtra("key7","");
                                    intent.putExtra("val8","");
                                    intent.putExtra("key8","");
                                    intent.putExtra("val9","");
                                    intent.putExtra("key9","");
                                    intent.putExtra("val10","");
                                    intent.putExtra("key10","");
                                    intent.putExtra("val11","");
                                    intent.putExtra("key11","");
                                    intent.putExtra("val12","");
                                    intent.putExtra("key12","");
                                    intent.putExtra("val13","");
                                    intent.putExtra("key13","");
                                    intent.putExtra("val14","");
                                    intent.putExtra("key14","");
                                    intent.putExtra("val15","");
                                    intent.putExtra("key15","");
                                    intent.putExtra("val16","");
                                    intent.putExtra("key16","");
                                    intent.putExtra("val17","");
                                    intent.putExtra("key17","");
                                    intent.putExtra("val18","");
                                    intent.putExtra("key18","");
                                    intent.putExtra("val19","");
                                    intent.putExtra("key19","");
                                    intent.putExtra("val20","");
                                    intent.putExtra("key20","");
                                    startActivity(intent);
                                }
                            }else{
                                JSONArray cast = response.getJSONArray("data");
                                if(cast.length() >=1){
                                    JSONObject obj = cast.getJSONObject(0);
                                    System.out.println(obj);
                                    Intent intent = new Intent(SearchReport.this, Preports.class);
                                    intent.putExtra("key1","UID");
                                    intent.putExtra("val1",obj.getString("uid"));
                                    intent.putExtra("val2",obj.getString("name"));
                                    intent.putExtra("key2","Name");
                                    intent.putExtra("val3",obj.getString("age"));
                                    intent.putExtra("key3","Age");
                                    intent.putExtra("val4",obj.getString("gender"));
                                    intent.putExtra("key4","Gender");
                                    intent.putExtra("val5",obj.getString("regDate"));
                                    intent.putExtra("key5","Registered Date");
                                    intent.putExtra("val6",obj.getString("weight"));
                                    intent.putExtra("key6","Weight");
                                    intent.putExtra("val7",obj.getString("height"));
                                    intent.putExtra("key7","Height");
                                    intent.putExtra("val8",obj.getString("riskfactor"));
                                    intent.putExtra("key8","Risk Factor");
                                    intent.putExtra("val9",obj.getString("baseBp"));
                                    intent.putExtra("key9","Base BP");
                                    intent.putExtra("val10",obj.getString("peakBp"));
                                    intent.putExtra("key10","Peak BP");
                                    intent.putExtra("val11",obj.getString("baseHp"));
                                    intent.putExtra("key11","Base HP");
                                    intent.putExtra("val12",obj.getString("peakHp"));
                                    intent.putExtra("key12","Peak HP");
                                    intent.putExtra("val13",obj.getString("bp"));
                                    intent.putExtra("key13","BP");
                                    intent.putExtra("val14",obj.getString("hp"));
                                    intent.putExtra("key14","HP");
                                    intent.putExtra("val15",obj.getString("medications"));
                                    intent.putExtra("key15","Medications");
                                    intent.putExtra("val16","");
                                    intent.putExtra("key16","");
                                    intent.putExtra("val17","");
                                    intent.putExtra("key17","");
                                    intent.putExtra("val18","");
                                    intent.putExtra("key18","");
                                    intent.putExtra("val19","");
                                    intent.putExtra("key19","");
                                    intent.putExtra("val20","");
                                    intent.putExtra("key20","");
                                    startActivity(intent);
                                }else
                                {
                                    Intent intent = new Intent(SearchReport.this, Preports.class);
                                    intent.putExtra("val1","No Report Found");
                                    intent.putExtra("key1","");
                                    intent.putExtra("val2","");
                                    intent.putExtra("key2","");
                                    intent.putExtra("val3","");
                                    intent.putExtra("key3","");
                                    intent.putExtra("val4","");
                                    intent.putExtra("key4","");
                                    intent.putExtra("val5","");
                                    intent.putExtra("key5","");
                                    intent.putExtra("val6","");
                                    intent.putExtra("key6","");
                                    intent.putExtra("val7","");
                                    intent.putExtra("key7","");
                                    intent.putExtra("val8","");
                                    intent.putExtra("key8","");
                                    intent.putExtra("val9","");
                                    intent.putExtra("key9","");
                                    intent.putExtra("val10","");
                                    intent.putExtra("key10","");
                                    intent.putExtra("val11","");
                                    intent.putExtra("key11","");
                                    intent.putExtra("val12","");
                                    intent.putExtra("key12","");
                                    intent.putExtra("val13","");
                                    intent.putExtra("key13","");
                                    intent.putExtra("val14","");
                                    intent.putExtra("key14","");
                                    intent.putExtra("val15","");
                                    intent.putExtra("key15","");
                                    intent.putExtra("val16","");
                                    intent.putExtra("key16","");
                                    intent.putExtra("val17","");
                                    intent.putExtra("key17","");
                                    intent.putExtra("val18","");
                                    intent.putExtra("key18","");
                                    intent.putExtra("val19","");
                                    intent.putExtra("key19","");
                                    intent.putExtra("val20","");
                                    intent.putExtra("key20","");
                                    startActivity(intent);
                                }
                            }
                        }else{
                            Toast.makeText(SearchReport.this, "Invalid Information!",
                                    Toast.LENGTH_LONG).show();
                            load.dismissDialog();
                        }
                    } catch (JSONException e) {
                        load.dismissDialog();
                        Toast.makeText(SearchReport.this, e.toString(),
                                Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println(error.toString());
                    load.dismissDialog();
                    Toast.makeText(SearchReport.this, error.toString(),
                            Toast.LENGTH_LONG).show();
                }
            });
            mRequestQueue.add(req);
        }
    }
}