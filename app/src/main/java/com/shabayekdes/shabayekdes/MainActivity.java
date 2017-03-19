package com.shabayekdes.shabayekdes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.exit)
            finish();
        return super.onOptionsItemSelected(item);
    }
    public void btnClick(View view) {

        switch (view.getId()){
            case R.id.btn_toast:
            {
                Toast.makeText(this, "Welcome to my app", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_dialog:
            {
                intent = new Intent(this,DialogActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_intent:
            {
                intent = new Intent(this,IntentActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_spn:
            {
                intent = new Intent(this,SpinnerActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_listv:
            {
                intent = new Intent(this,TopMoviesActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_webv:
            {
                intent = new Intent(this,WebViewActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_shared:
            {
                intent = new Intent(this,SharedActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_notify:
            {
                intent = new Intent(this,NotifyActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_sqlitedb:
            {
                intent = new Intent(this,SqlDatabase.class);
                startActivity(intent);
                break;
            }

        }

    }
}
