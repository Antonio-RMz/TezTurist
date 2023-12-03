package com.example.tezturist.clima;

//a funcionalidad principal se encuentra dentro del método api(), donde
// realiza una llamada a la API de OpenWeatherMap, procesa la respuesta JSON
// para extraer datos meteorológicos y los almacena en arrays para su uso posterior.
// Los datos incluyen temperatura, humedad, velocidad
// del viento, presión y otros detalles para una ubicación específica

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class Api {
    static String nazwa;
    static String kraj;
    static int responseCode;

    // Nuevos atributos para las coordenadas
    static double latitude;
    static double longitude;



    static String[][] tablica;
    static String[][] tab1;


    // Método para establecer manualmente las coordenadas
    public static void setCoordinates(double lat, double lon) {
        latitude = lat;
        longitude = lon;
    }
         static void api() {
            try {

                URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?lat=" + latitude + "&lon=" + longitude + "&appid=f19913da8c5c25a3f515b87e1592f9db");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                responseCode= httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    throw new RuntimeException("HttpResponseCode: " + responseCode);
                }
                else {
                    StringBuilder informationString = new StringBuilder();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                    String line=reader.readLine();
                    informationString.append(line);

                    JSONObject jsonObject = new JSONObject(informationString.toString());
                    JSONArray listArray = jsonObject.getJSONArray("list");

                    tablica = new String[10][listArray.length()];

                    int sum = 0;
                    for(int i = 0 ; i< 4; i++){

                        sum+=8;
                        JSONObject firstListObject = listArray.getJSONObject(sum);

                            Long dtt = Long.valueOf(firstListObject.getString("dt"));
                            JSONObject mainObject = firstListObject.getJSONObject("main");

                            double temp_max = mainObject.getDouble("temp_max");
                            double temp_maxC =temp_max - 273.15;
                            int result1 = (int) temp_maxC;
                            String temp_maximum = String.valueOf(result1);

                            double temp_min = mainObject.getDouble("temp_min");
                            double temp_minC =temp_min - 273.15;
                            int result2 = (int) temp_minC;
                            String temp_miniimum = String.valueOf(result2);

                            String pressure = mainObject.getString("pressure");
                            String humidity = mainObject.getString("humidity");
                            JSONObject windObject = firstListObject.getJSONObject("wind");
                            int speed0 = windObject.getInt("speed");
                            double speed1 = speed0*3.6;
                            String speed = String.valueOf(speed1);

                            JSONArray weatherArray = firstListObject.getJSONArray("weather");
                            JSONObject weatherObject = weatherArray.getJSONObject(0);

                            String main = weatherObject.getString("main");
                            String id = weatherObject.getString("icon");
                            String description = weatherObject.getString("description");

                            Date date = new Date(dtt*1000);
                            String dayMonth = String.format("%ta",date);
                            String dayFull = String.format("%tA",date);

                            tablica[0][i]=main;
                            tablica[1][i]=id;
                            tablica[2][i]=description;
                            tablica[3][i]=temp_miniimum;
                            tablica[4][i]=temp_maximum;
                            tablica[5][i]=dayMonth;
                            tablica[6][i]=humidity;
                            tablica[7][i]=speed;
                            tablica[8][i]=pressure;
                            tablica[9][i] =dayFull;
                        System.out.println(tablica[0][i]);
                    }


                    tab1 = new String[13][listArray.length()];
                    for(int i = 0 ; i< listArray.length(); i++){

                        JSONObject firstListObject = listArray.getJSONObject(i);
                        Long dta = Long.valueOf(firstListObject.getString("dt"));
                        Date date = new Date(dta * 1000);
                        String dt = String.format("%tR", date);
                        String datemonth = String.format("%tA, %td %tB",date, date, date)+ " | "+ dt;
                        JSONObject mainObject = firstListObject.getJSONObject("main");

                        String grndLevel = mainObject.getString("grnd_level");
                        String seaLevel = mainObject.getString("sea_level");
                        double temp_max = mainObject.getDouble("temp_max");
                        double temp_maxC =temp_max - 273.15;
                        int result1 = (int) temp_maxC;
                        String temp_maximum = String.valueOf(result1);

                        double temp_min = mainObject.getDouble("temp_min");
                        double temp_minC =temp_min - 273.15;
                        int result2 = (int) temp_minC;
                        String temp_miniimum = String.valueOf(result2);

                        String pressure = mainObject.getString("pressure");
                        String humidity = mainObject.getString("humidity");

                        JSONObject windObject = firstListObject.getJSONObject("wind");
                        int speed0 = windObject.getInt("speed");
                        double speed1 = speed0*3.6;
                        String speed = String.valueOf(speed1);

                        JSONArray weatherArray = firstListObject.getJSONArray("weather");
                        JSONObject weatherObject = weatherArray.getJSONObject(0);

                        String main = weatherObject.getString("main");
                        String id = weatherObject.getString("icon");
                        String description = weatherObject.getString("description");

                        tab1[0][i]=main;
                        tab1[1][i]=id;
                        tab1[2][i]=description;
                        tab1[3][i]=temp_miniimum;
                        tab1[4][i]=temp_maximum;
                        tab1[5][i]=datemonth;
                        tab1[6][i]=humidity;
                        tab1[7][i]=speed;
                        tab1[8][i]=pressure;
                        tab1[9][i]=seaLevel;
                        tab1[10][i]=grndLevel;
                        tab1[11][i]=dt;
                    }
                }
            } catch (Exception e) {
                System.out.println("Błąd"+" "+e.getMessage());
            }
        }
}
