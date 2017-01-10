package com.shabayekdes.shabayekdes;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        edit = (EditText) findViewById(R.id.ed_ent_name);
    }

    public void btnClear(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm delet")
               .setMessage("Are you sure to clear that!")
               .setPositiveButton("Yes" ,new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                    edit.setText("");
                       Toast.makeText(DialogActivity.this, "Donne!", Toast.LENGTH_SHORT).show();
                   }
               })
               .setNegativeButton("No" ,new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {

                   }
               })
               .setIcon(R.drawable.trash)
               .show();


    }
}
