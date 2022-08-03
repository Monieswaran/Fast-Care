package com.example.appointmentbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Preports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preports);
        Intent intent = getIntent();
        String key1 = intent.getExtras().getString("key1");
        String val1 = intent.getExtras().getString("val1");
        String key2 = intent.getExtras().getString("key2");
        String val2 = intent.getExtras().getString("val2");
        String key3 = intent.getExtras().getString("key3");
        String val3 = intent.getExtras().getString("val3");
        String key4 = intent.getExtras().getString("key4");
        String val4 = intent.getExtras().getString("val4");
        String key5 = intent.getExtras().getString("key5");
        String val5 = intent.getExtras().getString("val5");
        String key6 = intent.getExtras().getString("key6");
        String val6 = intent.getExtras().getString("val6");
        String key7 = intent.getExtras().getString("key7");
        String val7 = intent.getExtras().getString("val7");
        String key8 = intent.getExtras().getString("key8");
        String val8 = intent.getExtras().getString("val8");
        String key9 = intent.getExtras().getString("key9");
        String val9 = intent.getExtras().getString("val9");
        String key10 = intent.getExtras().getString("key10");
        String val10 = intent.getExtras().getString("val10");
        String key11 = intent.getExtras().getString("key11");
        String val11 = intent.getExtras().getString("val11");
        String key12 = intent.getExtras().getString("key12");
        String val12 = intent.getExtras().getString("val12");
        String key13 = intent.getExtras().getString("key13");
        String val13 = intent.getExtras().getString("val13");
        String key14 = intent.getExtras().getString("key14");
        String val14 = intent.getExtras().getString("val14");
        String key15 = intent.getExtras().getString("key15");
        String val15 = intent.getExtras().getString("val15");
        String key16 = intent.getExtras().getString("key16");
        String val16 = intent.getExtras().getString("val16");
        String key17 = intent.getExtras().getString("key17");
        String val17 = intent.getExtras().getString("val17");
        String key18 = intent.getExtras().getString("key18");
        String val18 = intent.getExtras().getString("val18");
        String key19 = intent.getExtras().getString("key19");
        String val19 = intent.getExtras().getString("val19");
        String key20 = intent.getExtras().getString("key20");
        String val20 = intent.getExtras().getString("val20");

        TextView k1 = findViewById(R.id.key1);
        TextView k2 = findViewById(R.id.key2);
        TextView k3 = findViewById(R.id.key3);
        TextView k4 = findViewById(R.id.key4);
        TextView k5 = findViewById(R.id.key5);
        TextView k6 = findViewById(R.id.key6);
        TextView k7 = findViewById(R.id.key7);
        TextView k8 = findViewById(R.id.key8);
        TextView k9 = findViewById(R.id.key9);
        TextView k10 = findViewById(R.id.key10);
        TextView k11 = findViewById(R.id.key11);
        TextView k12 = findViewById(R.id.key12);
        TextView k13 = findViewById(R.id.key13);
        TextView k14 = findViewById(R.id.key14);
        TextView k15 = findViewById(R.id.key15);
        TextView k16 = findViewById(R.id.key16);
        TextView k17 = findViewById(R.id.key17);
        TextView k18 = findViewById(R.id.key18);
        TextView k19 = findViewById(R.id.key19);
        TextView k20 = findViewById(R.id.key20);

        TextView v1 = findViewById(R.id.val1);
        TextView v2 = findViewById(R.id.val2);
        TextView v3 = findViewById(R.id.val3);
        TextView v4 = findViewById(R.id.val4);
        TextView v5 = findViewById(R.id.val5);
        TextView v6 = findViewById(R.id.val6);
        TextView v7 = findViewById(R.id.val7);
        TextView v8 = findViewById(R.id.val8);
        TextView v9 = findViewById(R.id.val9);
        TextView v10 = findViewById(R.id.val10);
        TextView v11 = findViewById(R.id.val11);
        TextView v12 = findViewById(R.id.val12);
        TextView v13 = findViewById(R.id.val13);
        TextView v14 = findViewById(R.id.val14);
        TextView v15 = findViewById(R.id.val15);
        TextView v16 = findViewById(R.id.val16);
        TextView v17 = findViewById(R.id.val17);
        TextView v18 = findViewById(R.id.val18);
        TextView v19 = findViewById(R.id.val19);
        TextView v20 = findViewById(R.id.val20);


        v1.setText(val1);
        v2.setText(val2);
        v3.setText(val3);
        v4.setText(val4);
        v5.setText(val5);
        v6.setText(val6);
        v7.setText(val7);
        v8.setText(val8);
        v9.setText(val9);
        v10.setText(val10);
        v11.setText(val11);
        v12.setText(val12);
        v13.setText(val13);
        v14.setText(val14);
        v15.setText(val15);
        v16.setText(val16);
        v17.setText(val17);
        v18.setText(val18);
        v19.setText(val19);
        v20.setText(val20);



        k1.setText(key1);
        k2.setText(key2);
        k3.setText(key3);
        k4.setText(key4);
        k5.setText(key5);
        k6.setText(key6);
        k7.setText(key7);
        k8.setText(key8);
        k9.setText(key9);
        k10.setText(key10);
        k11.setText(key11);
        k12.setText(key12);
        k13.setText(key13);
        k14.setText(key14);
        k15.setText(key15);
        k16.setText(key16);
        k17.setText(key17);
        k18.setText(key18);
        k19.setText(key19);
        k20.setText(key20);
    }
}