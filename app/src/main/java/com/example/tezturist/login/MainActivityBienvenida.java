package com.example.tezturist.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tezturist.R;
import com.example.tezturist.login.ActivityLogin;

public class MainActivityBienvenida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bienvenida);


    }


    public void abreActivityPrincipal(View view) {
        Intent intent = new Intent(view.getContext(), ActivityLogin.class);
        view.getContext().startActivity(intent);
    }
}