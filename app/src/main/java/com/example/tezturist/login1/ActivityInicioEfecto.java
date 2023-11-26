package com.example.tezturist.login1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tezturist.MainActivity;
import com.example.tezturist.MainActivity1;
import com.example.tezturist.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityInicioEfecto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_inicio_efecto);


        //agregar las animaciones

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);


        ImageView loginImageView = findViewById(R.id.loginImageView);
        TextView deTextView = findViewById(R.id.deTextView);
        TextView antonRMTextView = findViewById(R.id.antonRMTextView);


        deTextView.setAnimation(animation2);
        antonRMTextView.setAnimation(animation2);
        loginImageView.setAnimation(animation1);




        new Handler().postDelayed(new Runnable() {
            //despues de que pasaron los 4 segundos de la animacion

            @Override
            public void run() {
                //si el usuario ya inicio sesion se va hacia el userACtiviti y si no se manda al login
                FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser(); //
                if (user!= null){
                    Intent intent = new Intent(ActivityInicioEfecto.this, MainActivity1.class);
                    startActivity(intent);
                    finish();
                }else {//si no inicia sesion
//(Animaciones)
                    Intent intent= new Intent(ActivityInicioEfecto.this, LoginActivity1.class);
                    Pair[] pairs= new Pair[2];
                    pairs[0]=new Pair<View, String>(loginImageView,"logoImageTrans");
                    pairs[1]=new Pair<View, String>(antonRMTextView,"textTrans");
//si la version del jdk no soporta que se salte la animacion
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ActivityInicioEfecto.this,pairs);
                        startActivity(intent, options.toBundle());
                    }else {
                        startActivity(intent);
                        finish();
                    }

                    startActivity(intent);
                    finish();
                }

            }

        },4000);
        //fin bloque animacion ejecutar
    }
}