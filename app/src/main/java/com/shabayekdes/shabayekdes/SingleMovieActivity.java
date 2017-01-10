package com.shabayekdes.shabayekdes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class SingleMovieActivity extends AppCompatActivity {
TextView textView;
    ImageButton btn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_movie);
        textView = (TextView) findViewById(R.id.textView);
        intent = getIntent();
        final ArrayList<Movies> myadapter = new ArrayList<Movies>();
        myadapter.add(new Movies("The Godfather", "https://www.youtube.com/watch?v=sY1S34973zA"));
        myadapter.add(new Movies("The Lord of the Rings", "https://www.youtube.com/watch?v=r5X-hFf6Bwo"));
        myadapter.add(new Movies("Inception", "https://www.youtube.com/watch?v=YoHD9XEInc0"));
        myadapter.add(new Movies("The Matrix", "https://www.youtube.com/watch?v=vKQi3bBA1y8"));


        btn = (ImageButton) findViewById(R.id.btn_youtube);
        textView.setText(myadapter.get(Integer.parseInt(intent.getStringExtra("id"))).name);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(myadapter.get(Integer.parseInt(intent.getStringExtra("id"))).url));
                startActivity(i);
            }
        });


    }
}
