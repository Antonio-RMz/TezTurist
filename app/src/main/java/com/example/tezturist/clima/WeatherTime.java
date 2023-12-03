package com.example.tezturist.clima;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.tezturist.R;

public class WeatherTime extends WeatherPhoto {
    String degrees;
    String times;

    WeatherTime(Activity activity, String yourWeather, String degrees, String times) {
        super(activity, yourWeather);
        this.degrees = degrees;
        this.times = times;
    }

    void wyswietl() {
        TableRow timeWeather1 = activity.findViewById(R.id.timeWeather);
        LinearLayout timeLayout = new LinearLayout(activity);

        timeLayout.setOrientation(LinearLayout.VERTICAL);
        timeLayout.setBackgroundResource(R.drawable.radius);

        LinearLayout.LayoutParams timeParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
        );

        timeParams.gravity = Gravity.CENTER;
        LinearLayout.LayoutParams timetime = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
        );
        timetime.gravity = Gravity.CENTER;
        TextView timeget = new TextView(activity);
        timeget.setText(R.string.time);
        timeget.setTypeface(null, Typeface.BOLD);
        timeget.setGravity(Gravity.CENTER);
        timeget.setTextColor(Color.WHITE);
        timeget.setLayoutParams(timetime);

        TextView time = new TextView(activity);
        time.setText(times);

        time.setTextColor(Color.WHITE);
        time.setLayoutParams(timeParams);

        ImageView icon = new ImageView(activity);
        wywolaj(icon);
        LinearLayout.LayoutParams degreeParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
        );

        degreeParams.gravity = Gravity.CENTER;

        TextView degree = new TextView(activity);
        degree.setText(degrees + "°");

        degree.setTypeface(null, Typeface.BOLD);
        degree.setTextColor(Color.LTGRAY);
        degree.setLayoutParams(degreeParams);

        // Configuración de parámetros para orientación vertical
        timeLayout.setMinimumHeight(650);
        timeLayout.setMinimumWidth(328);
        timeParams.bottomMargin = 32;
        timeParams.topMargin = 6;
        timetime.topMargin = 95;
        timetime.bottomMargin = 12;
        timeget.setTextSize(18);
        time.setTextSize(36);
        degreeParams.topMargin = 32;
        degree.setTextSize(32);

        timeLayout.addView(timeget);
        timeLayout.addView(time);
        timeLayout.addView(icon);
        timeLayout.addView(degree);
        timeWeather1.addView(timeLayout);
        TextView textView1 = new TextView(activity);
        textView1.setText("   ");
        timeWeather1.addView(textView1);
    }
}
