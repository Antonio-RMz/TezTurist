package com.example.tezturist.clima;
//recursos de imagen específicos según el tipo de clima proporcionado

import android.app.Activity;
import android.widget.ImageView;

import com.example.tezturist.R;

public abstract class WeatherPhoto {
    Activity activity;
    String yourWeather;
    WeatherPhoto(Activity activity, String yourWeather){
        this.activity=activity;
        this.yourWeather=yourWeather;
    }
    void wywolaj(ImageView weatherPhoto){
        switch (yourWeather) {
            case "Rain":
                weatherPhoto.setImageResource(R.drawable.rain);
                break;
            case "Clouds":
                weatherPhoto.setImageResource(R.drawable.cloudy);
                break;
            case "Rainy":
                weatherPhoto.setImageResource(R.drawable.rainy);
                break;
            case "Snow":
                weatherPhoto.setImageResource(R.drawable.snowy);
                break;
            case "Storm":
                weatherPhoto.setImageResource(R.drawable.storm);
                break;
            case "Sunny":
                weatherPhoto.setImageResource(R.drawable.sunny);
                break;
            case "Wind":
                weatherPhoto.setImageResource(R.drawable.wind);
                break;
            case "Windy":
                weatherPhoto.setImageResource(R.drawable.windy);
                break;
            case "Cloudy Sunny":
                weatherPhoto.setImageResource(R.drawable.windy);
                break;
            case "Clear":
                weatherPhoto.setImageResource(R.drawable.cloudy_sunny);
                break;
            default:
                weatherPhoto.setImageResource(R.drawable.radius);
                break;
        }
    }
}
