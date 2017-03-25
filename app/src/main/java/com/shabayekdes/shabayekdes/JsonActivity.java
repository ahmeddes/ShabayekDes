package com.shabayekdes.shabayekdes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class JsonActivity extends AppCompatActivity {
TextView txtjson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        txtjson = (TextView) findViewById(R.id.txtjson);
        JSONObject myjson = new JSONObject();
        try {
                myjson.put("fname" , "esmail");
                myjson.put("lname" , "shabayek");
                myjson.put("age" , "27");
            JSONArray address = new JSONArray();
                JSONObject fitem = new JSONObject();
                    fitem.put("first" , "23 july");
                    fitem.put("second" , "26 july");
                address.put(fitem);
                JSONObject sitem = new JSONObject();
                    sitem.put("city" , "alarish");
                    sitem.put("country" , "egypt");
                address.put(sitem);
            myjson.put("address" , address);
            JSONArray jobs = new JSONArray();
                jobs.put("graphics");
                jobs.put("desginer");
                jobs.put("web");
            myjson.put("jobs" , jobs);
        txtjson.setText(myjson.toString());

        // Read


        }catch (Exception ex){}


    }
}
