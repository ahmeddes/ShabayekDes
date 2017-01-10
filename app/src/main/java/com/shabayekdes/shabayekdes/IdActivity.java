package com.shabayekdes.shabayekdes;

import android.content.Intent;
import java.util.Calendar;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IdActivity extends AppCompatActivity {
Intent intent;
    TextView txtv_name,txtv_country,txtv_date;
    String name,brithdate;
   int ddate,mdate,ydate;
    int c_ddate,c_mdate,c_ydate;
    int res_ddate,res_mdate,res_ydate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);
        txtv_name = (TextView) findViewById(R.id.txtv_name);
        txtv_country = (TextView) findViewById(R.id.txtv_country);
        txtv_date = (TextView) findViewById(R.id.txtv_date);

        Calendar calendar = Calendar.getInstance();
        c_ddate = calendar.get(calendar.DAY_OF_MONTH);
        c_mdate = calendar.get(calendar.MONTH);
        c_mdate = c_mdate +1;
        c_ydate = calendar.get(calendar.YEAR);

        intent = getIntent();
        Register register = (Register) intent.getSerializableExtra("register");
        name = register.getFname() + "" +register.getLname();
        ddate = register.getDdate();
        mdate = register.getMdate();
        ydate = register.getYdate();
        res_ydate = c_ydate - ydate;
        brithdate = ddate + "/" + mdate + "/" + ydate;
        txtv_name.setText("Your name is " + name);
        txtv_country.setText("Your country is " + register.getCountry());
        txtv_date.setText("you have " + opAgeDay() + " day ," + opAgeMonth() + " month ," + res_ydate + " ago.");

    }
    public int opAgeDay() {
        if (c_ddate > ddate) {
            res_ddate = c_ddate - ddate;
            return res_ddate;
        } else {
            c_ddate = c_ddate + 30;
            c_mdate = c_mdate - 1;
            res_ddate = c_ddate - ddate;
            return res_ddate;
        }
    }
    public int opAgeMonth(){
        if(c_mdate > mdate){
            res_mdate = c_mdate - mdate;
            return res_mdate;
        }else{
            c_mdate = c_mdate + 12;
            c_ydate = res_ydate - 1;
            res_mdate = c_mdate - mdate;
            return res_mdate;
        }
    }

}
