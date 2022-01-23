package com.example.recycler_view_arnau;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView url_image;
    private TextView text_title;
    private TextView desc_d;

    String text, url, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        url_image = findViewById(R.id.url_2);
        text_title = findViewById(R.id.text_title_2);
        desc_d = findViewById(R.id.desc_2);

        getData();
        setData();
    }

    private void getData(){
        if (getIntent().hasExtra("text_title")){
            text = getIntent().getStringExtra("text_title");
            url = getIntent().getStringExtra("url");
            desc = getIntent().getStringExtra("desc");
        } else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        text_title.setText(text);
        desc_d.setText(desc);
        Picasso.get().load(url)
                .fit()
                .centerCrop()
                .into(url_image);
    }
}