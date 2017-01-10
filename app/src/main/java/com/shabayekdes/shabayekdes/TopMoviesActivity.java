package com.shabayekdes.shabayekdes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TopMoviesActivity extends AppCompatActivity {
ListView ls ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_movies);
        ArrayList<Movies> myadapter = new ArrayList<Movies>();
        myadapter.add(new Movies("The Godfather" ,"(1972)" ,"Crime, Drama" , "9.2/10" , R.drawable.godfather));
        myadapter.add(new Movies("The Lord of the Rings" ,"(2003)" , "Adventure, Drama, Fantasy" , "8.9/10" , R.drawable.lord));
        myadapter.add(new Movies("Inception" , "(2010)" , "Action, Adventure, Sci-Fi" , "8.8/10" , R.drawable.inception));
        myadapter.add(new Movies("The Matrix" , "(1999)" , "Action, Sci-Fi" , "8.7/10" , R.drawable.matrix));

        ls = (ListView) findViewById(R.id.movie_listv);
        MyCustomAdapter adapter = new MyCustomAdapter(myadapter);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TopMoviesActivity.this,SingleMovieActivity.class);
                intent.putExtra("id" , String.valueOf(i));
                startActivity(intent);
            }
        });

    }

    public class MyCustomAdapter extends BaseAdapter {

        ArrayList<Movies> myadapter = new ArrayList<Movies>();

        public MyCustomAdapter(ArrayList<Movies> myadapter) {
            this.myadapter = myadapter;
        }

        @Override
        public int getCount() {
            return myadapter.size();
        }

        @Override
        public Object getItem(int i) {
            return myadapter.get(i).name;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater myinflate = getLayoutInflater();
            View myview = myinflate.inflate(R.layout.list_movies,null);

            TextView txtname = (TextView) myview.findViewById(R.id.movie_name);
            TextView txtyear = (TextView) myview.findViewById(R.id.movie_year);
            TextView txttype = (TextView) myview.findViewById(R.id.movie_type);
            TextView txtrate = (TextView) myview.findViewById(R.id.movie_rate);
            ImageView imgv = (ImageView) myview.findViewById(R.id.movie_img);

            Movies temp = myadapter.get(i);

            txtname.setText(temp.name);
            txtyear.setText(temp.year);
            txttype.setText(temp.type);
            txtrate.setText(temp.rate);
            imgv.setImageResource(temp.img);

            return myview;

        }
    }
}
