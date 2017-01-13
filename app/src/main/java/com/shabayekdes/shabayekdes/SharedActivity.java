package com.shabayekdes.shabayekdes;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SharedActivity extends AppCompatActivity {
    EditText ed_Fname;
    EditText ed_lanme;
    TextView txtv;
    String fname,lname;
    SharedPreferences myshared;
    SharedPreferences.Editor editeshared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);
        ed_Fname = (EditText) findViewById(R.id.ed_fname);
        ed_lanme = (EditText) findViewById(R.id.ed_lname);
        txtv = (TextView) findViewById(R.id.txtv_shared);
    }

    public void btnSaveName(View view) {
        myshared = getSharedPreferences("savename" , Context.MODE_PRIVATE);
        editeshared = myshared.edit();

        editeshared.putString("fname" , ed_Fname.getText().toString());
        editeshared.putString("lname" , ed_lanme.getText().toString());
        editeshared.apply();
    }

    public void btnLoadName(View view) {
        myshared = getSharedPreferences("savename" , Context.MODE_PRIVATE);
        fname = myshared.getString("fname" , "Your");
        lname = myshared.getString("lname" , "name");
        txtv.setText(fname + " " + lname);
    }
}
