package com.shabayekdes.shabayekdes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SqlDatabase extends AppCompatActivity {
    EditText ed_fname, ed_lname, ed_age, ed_phone;
    ListView listv;
    Dbconnection mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_database);
        ed_fname = (EditText) findViewById(R.id.reg_fname);
        ed_lname = (EditText) findViewById(R.id.reg_lname);
        ed_age = (EditText) findViewById(R.id.reg_age);
        ed_phone = (EditText) findViewById(R.id.reg_phone);
        listv = (ListView) findViewById(R.id.sqlist);
    }

    public void btnSave(View view) {
        mydb = new Dbconnection(this);
        String fname = ed_fname.getText().toString();
        String lname = ed_lname.getText().toString();
        int age = Integer.parseInt(ed_age.getText().toString());
        String phone = ed_phone.getText().toString();
        long id = mydb.insertName(fname,lname,age,phone);
            if(id > 0){
                Toast.makeText(getApplicationContext(), "Data is added and user id:" + id, Toast.LENGTH_LONG).show();
            }else
                Toast.makeText(getApplicationContext(), "cannot insert", Toast.LENGTH_LONG).show();
        ed_fname.setText("");
        ed_lname.setText("");
        ed_age.setText("");
        ed_phone.setText("");
    }

    public void btnLoad(View view) {
        ArrayList myarray = mydb.getAllName();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myarray);

        listv.setAdapter(adapter);
    }
}
