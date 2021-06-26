package com.example.retrofit2withandroidjava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BaseUrl = "http://api.openweathermap.org/";
    public static final String AppId = "2e65127e909e178d0af311a81f39948c";
    public static String lat = "35";
    public static String lon = "139";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<WeatherResponse> currentWeatherData = weatherService.getCurrentWeatherData(lat, lon, AppId);

        currentWeatherData.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.code() == 200) {
                    WeatherResponse body = response.body();
                    String res = "Country: " + body.sys.country + "\n"
                            + "Temperature: " + body.main.temp + "\n"
                            + "Temperature(Min): " + body.main.temp_min + "\n"
                            + "Temperature(Max): " + body.main.temp_max + "\n"
                            + "Humidity: " + body.main.humidity + "\n"
                            + "Pressure: " + body.main.pressure;
                    textView.setText(res);
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}