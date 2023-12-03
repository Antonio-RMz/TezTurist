package com.example.tezturist.clima;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tezturist.R;


public class ActivityLugares extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);
        

        Button btnClimaAtoluca = findViewById(R.id.btnClimaAtoluca);
        Button btnClimaSebas = findViewById(R.id.btnClimaSebas);
        Button btnClimaSanDiego = findViewById(R.id.btnClimaSanDiego);

        Button btnClimaSanJuan = findViewById(R.id.btnClimaSanJuan);
        Button btnClimaMexcal = findViewById(R.id.btnClimaMexcal);
        Button btnClimaTeziutlan = findViewById(R.id.btnClimaTeziutlan);

        btnClimaAtoluca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMainWeather(19.9631125, -97.2328597);
            }
        });

        btnClimaSebas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMainWeather(19.8553597, -97.3912882);
            }
        });

        btnClimaSanDiego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMainWeather(19.8616575,-97.3756818);
            }
        });


        btnClimaSanJuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMainWeather(19.8616575,-97.3756818);
            }
        });

        btnClimaMexcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMainWeather(19.8616575,-97.3756818);
            }
        });

        btnClimaTeziutlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMainWeather(19.8616575,-97.3756818);
            }
        });


    }

    private void abrirMainWeather(double latitude, double longitude) {
        Intent intent = new Intent(ActivityLugares.this, MainWeather.class);
        intent.putExtra("latitude", latitude);
        intent.putExtra("longitude", longitude);
        startActivity(intent);
    }
}
