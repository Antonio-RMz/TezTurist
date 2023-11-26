package com.example.tezturist.login1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tezturist.R;
import com.example.tezturist.fragmentsPrincipales.FragmentTres;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ForgotPassword1 extends AppCompatActivity {
    MaterialButton recuperarBoton;
    TextInputEditText emailEditText;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password1);

        recuperarBoton = findViewById(R.id.recuperarBoton);
        emailEditText = findViewById(R.id.emailEditText);

        recuperarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }
    public void validate() {
        String email = emailEditText.getText().toString().trim();
        if (email.isEmpty()|| !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("correo invalido");
            return;
        }
        sendEmail(email);
    }
    //cuando se quieran regresar a la ventana anterior que los mande al LoginActivity
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent= new Intent (ForgotPassword1.this, LoginActivity1.class);
        startActivity(intent);
        finish();
    }
    public void sendEmail (String email){

        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress= email;
        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(ForgotPassword1.this,"Correo enviado", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ForgotPassword1.this, LoginActivity1.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(ForgotPassword1.this, "Correo invalido xd", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}