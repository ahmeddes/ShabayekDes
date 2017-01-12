package com.shabayekdes.shabayekdes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class IntentActivity extends AppCompatActivity {
EditText fname,lname,country,ddate,mdate,ydate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        fname = (EditText) findViewById(R.id.ed_fname);
        lname = (EditText) findViewById(R.id.ed_lname);
        country = (EditText) findViewById(R.id.ed_cntry);
        ddate = (EditText) findViewById(R.id.ed_ddate);
        mdate = (EditText) findViewById(R.id.ed_mdate);
        ydate = (EditText) findViewById(R.id.ed_ydate);
    }


    public void btnIntentClick(View view) {
        Register register = new Register();
        register.setFname(fname.getText().toString());
        register.setLname(lname.getText().toString());
        register.setCountry(country.getText().toString());
        register.setDdate(Integer.parseInt(ddate.getText().toString()));
        register.setMdate(Integer.parseInt(mdate.getText().toString()));
        register.setYdate(Integer.parseInt(ydate.getText().toString()));
        Intent intent = new Intent(IntentActivity.this,IdActivity.class);
        intent.putExtra("register",register);
        startActivity(intent);
    }
    public void btnBack(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
