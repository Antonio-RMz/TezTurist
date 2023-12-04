package com.example.tezturist.acateno.carruselAcateno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.tezturist.R;
import com.example.tezturist.atoluca.carruselAtoluca.ImageViewActivity;

public class ImageViewActivityAcateno extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_acateno);

     //   ImageView imageView = findViewById(R.id.imageView);

       // Glide.with(ImageViewActivityAcateno.this).load(getIntent().getStringExtra("image")).into(imageView);
    }
}