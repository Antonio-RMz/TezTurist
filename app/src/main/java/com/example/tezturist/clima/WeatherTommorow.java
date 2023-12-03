package com.example.tezturist.clima;
//mostrar información meteorológica específica para el día siguiente en la interfaz de usuario
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tezturist.R;

public class WeatherTommorow extends WeatherPhoto {
    String youtDay;
    String degree1;
    ImageView weatherTommorow;
    WeatherTommorow(Activity activity, String yourDay, String yourWeather, String degree1) {
        super(activity, yourWeather);
        this.youtDay = yourDay;
        this.degree1=degree1;
    }
    void wyswietl(String rain, String wind, String humidity, String tomoroww, String description) {
        weatherTommorow= activity.findViewById(R.id.weatherTommorow);
        wywolaj(weatherTommorow);

        TextView degreeTommorow = activity.findViewById(R.id.degreeTommorow);
        degreeTommorow.setText(degree1+"°");

        TextView infoTommorow = activity.findViewById(R.id.infoTommorow);
        infoTommorow.setText(description);

        TextView rainTommorow= activity.findViewById(R.id.rainTommorow);
        rainTommorow.setText(rain+" hPa");

        TextView windTommorow= activity.findViewById(R.id.windTommorow);
        windTommorow.setText(wind+"km/h");

        TextView humidityTommorow= activity.findViewById(R.id.humidityTommorow);
        humidityTommorow.setText(humidity+"%");

        TextView tommorow = activity.findViewById(R.id.tommorow);
        tommorow.setText(tomoroww);
    }
}
