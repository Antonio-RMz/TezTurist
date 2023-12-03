package com.example.tezturist;
//este proyecto usa una base de datos de firebase de tu correo rodriguezmendezmarcoantonioh@gmail.com
import static androidx.navigation.ui.NavigationUI.setupWithNavController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        setupNavegacion();



    }


    private void setupNavegacion() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_hostfragmet);
        NavigationUI.setupWithNavController(
                bottomNavigationView,
                navHostFragment.getNavController()
        );
    }

}