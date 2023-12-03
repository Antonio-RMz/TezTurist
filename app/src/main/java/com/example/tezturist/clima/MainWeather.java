package com.example.tezturist.clima;
// muestra datos meteorológicos en la interfaz de usuario después de realizar una llamada asíncrona a la API de OpenWeatherMap

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tezturist.R;

public class MainWeather extends AppCompatActivity {
    TextView next,atolucaText;
    ImageView image;
    String val;
    TableLayout tablica;
    RelativeLayout napis1;
    View divider;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        progressBar = findViewById(R.id.progressBar);
        divider = findViewById(R.id.divider);
        tablica = findViewById(R.id.tablica);
        napis1 = findViewById(R.id.napis1);
        next = findViewById(R.id.nextBtn);
        image = findViewById(R.id.image);

        // Obtener las coordenadas de la Intent
        double latitude = getIntent().getDoubleExtra("latitude", 0.0);
        double longitude = getIntent().getDoubleExtra("longitude", 0.0);

        // Guardar las coordenadas en la clase Api
        Api.setCoordinates(latitude, longitude);

        next.setOnClickListener(view -> {
            Intent intent = new Intent(MainWeather.this, MainWeatherNext.class);
            intent.putExtra("latitude", latitude);
            intent.putExtra("longitude", longitude);
            startActivity(intent);
        });

        new ApiTask().execute();
    }


    class ApiTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            // Obtener datos meteorológicos usando coordenadas
            Api.api();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            displayData();
        }
    }

    void displayData() {
        progressBar.setVisibility(View.GONE);

        if (Api.responseCode != 200) {
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
        } else {
            napis1.setVisibility(View.VISIBLE);
            tablica.setVisibility(View.VISIBLE);
            divider.setVisibility(View.VISIBLE);





            String seaGrndLevel = "S: " + Api.tab1[9][0] + " hPa | G: " + Api.tab1[10][0] + " hPa";
            MainPhoto mainPhoto = new MainPhoto(this, Api.tab1[0][0]);
            mainPhoto.wyswietl(
                    getTranslatedCondition(Api.tab1[2][0]),  // Traduce la descripción del clima
                    Api.tab1[5][0], Api.tab1[4][0], Api.tab1[8][0], Api.tab1[7][0], Api.tab1[6][0], null, seaGrndLevel
            );
            mainPhoto.wywolaj(image);

            WeatherTime[] weatherTimes = new WeatherTime[10];
            for (int i = 1; i < weatherTimes.length; i++) {
                weatherTimes[i] = new WeatherTime(this, Api.tab1[0][i], Api.tab1[4][i], Api.tab1[11][i]);
                weatherTimes[i].wyswietl();
            }
        }
    }

    // Método para obtener la traducción de la condición meteorológica
    private String getTranslatedCondition(String condition) {
        int resourceId = getResources().getIdentifier(condition, "string", getPackageName());
        if (resourceId != 0) {
            return getString(resourceId);
        } else {
            return condition;  // Si no se encuentra una traducción, devuelve la condición original
        }
    }



}
