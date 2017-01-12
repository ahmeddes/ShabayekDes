package com.shabayekdes.shabayekdes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.id.list;

public class SpinnerActivity extends AppCompatActivity {
Spinner spinner;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner = (Spinner) findViewById(R.id.spn);
        textView = (TextView) findViewById(R.id.txt_spn_show);

        final ArrayList<String> spnarray = new ArrayList<String>();
        spnarray.add("Facebook");
        spnarray.add("Twitter");
        spnarray.add("Youtube");
        spnarray.add("Google plus");
        spnarray.add("Linked in");

        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,spnarray);
        spinner.setAdapter(myadapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            textView.setText("You are selected is " + spnarray.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void btnBack(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
