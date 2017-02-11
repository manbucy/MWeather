package com.manbu.mweather;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.manbu.mweather.gson.DailyForecast;
import com.manbu.mweather.gson.HeWeather;
import com.manbu.mweather.util.HttpUtil;
import com.manbu.mweather.util.Utility;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {

    private ScrollView weatherLayout;
    private ImageView bingPicImg;
    private TextView titleCity;
    private TextView titleUpdateTime;
    private TextView degreeText;
    private TextView weatherInfoText;
    private LinearLayout forecastLayout;
    private LinearLayout aqiLayout;
    private TextView aqiText;
    private TextView pm25Text;
    private TextView comfortText;
    private TextView carWashText;
    private TextView dressText;
    private TextView influenzaText;
    private TextView sportText;
    private TextView travelText;
    private TextView ultravioletText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_weather);
        initView();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString = preferences.getString("weather", null);
        if (weatherString != null) {
            HeWeather heWeather = Utility.handleHeWeatherResponse(weatherString);
            showWeatherInfo(heWeather);
        } else {
            String weatherId = getIntent().getStringExtra("weather_id");
            weatherLayout.setVisibility(View.INVISIBLE);
            requestWeather(weatherId);
        }
        String bingPic = preferences.getString("bing_pic",null);
        if (bingPic !=null){
            Glide.with(this).load(bingPic).into(bingPicImg);
        }else{
            loadBingPic();
        }
    }

    private void loadBingPic() {
        String requestBingPic = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String bingPic = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                editor.putString("bing_pic",bingPic);
                editor.apply();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(WeatherActivity.this).load(bingPic).into(bingPicImg);
                    }
                });
            }
        });
    }

    private void requestWeather(final String weatherId) {
        String weatherUrl = "https://free-api.heweather.com/v5/weather?" +
                "city=" + weatherId + "&key=c28a015598a647b597e9fb0311379bf8";
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.d("weatherText", "run: "+e.toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WeatherActivity.this, "获取天气信息失败",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                final HeWeather heWeather = Utility.handleHeWeatherResponse(responseText);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (heWeather != null && "ok".equals(heWeather.status)) {
                            SharedPreferences.Editor editor = PreferenceManager
                                    .getDefaultSharedPreferences(WeatherActivity.this).edit();
                            editor.putString("weather", responseText);
                            editor.apply();
                            showWeatherInfo(heWeather);
                        } else {
                            Log.d("weatherText", "heWeather ");
                            Toast.makeText(WeatherActivity.this, "获取天气信息失败",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    private void showWeatherInfo(HeWeather heWeather) {
        String cityName = heWeather.basic.city;
        String updateTime = heWeather.basic.update.loc.split(" ")[1];
        String degree = heWeather.now.tmp + "℃";
        String weatherInfo = heWeather.now.cond.txt;
        titleCity.setText(cityName);
        titleUpdateTime.setText(updateTime);
        degreeText.setText(degree);
        weatherInfoText.setText(weatherInfo);
        forecastLayout.removeAllViews();
        for (DailyForecast forecast : heWeather.dailyForecasts) {
            View view = LayoutInflater.from(this).inflate(R.layout.foecast_item, forecastLayout, false);
            TextView dataText = (TextView) view.findViewById(R.id.data_text);
            TextView infoText = (TextView) view.findViewById(R.id.info_text);
            TextView maxText = (TextView) view.findViewById(R.id.max_text);
            TextView minText = (TextView) view.findViewById(R.id.min_text);
            dataText.setText(forecast.date);
            infoText.setText(forecast.cond.txtD);
            maxText.setText(forecast.tmp.max);
            minText.setText(forecast.tmp.min);
            forecastLayout.addView(view);
        }
        aqiLayout.setVisibility(View.GONE);
        if (heWeather.aqi != null) {
            aqiText.setText(heWeather.aqi.city.aqi);
            pm25Text.setText(heWeather.aqi.city.pm25);
            aqiLayout.setVisibility(View.VISIBLE);
        }
        String comfort = "舒适度指数：" + heWeather.suggestion.comf.brf + "," + heWeather.suggestion.comf.txt;
        String carWash = "洗车指数：" + heWeather.suggestion.cw.brf + "," + heWeather.suggestion.cw.txt;
        String dress = "穿衣指数：" + heWeather.suggestion.drsg.brf + "," + heWeather.suggestion.drsg.txt;
        String influenza = "感冒指数：" + heWeather.suggestion.flu.brf + "," + heWeather.suggestion.flu.txt;
        String sport = "运功指数：" + heWeather.suggestion.sport.brf + "," + heWeather.suggestion.sport.txt;
        String travel = "旅游指数：" + heWeather.suggestion.trav.brf + "," + heWeather.suggestion.trav.txt;
        String ultraviolet = "紫外线指数：" + heWeather.suggestion.uv.brf + "," + heWeather.suggestion.uv.txt;
        comfortText.setText(comfort);
        carWashText.setText(carWash);
        dressText.setText(dress);
        influenzaText.setText(influenza);
        sportText.setText(sport);
        travelText.setText(travel);
        ultravioletText.setText(ultraviolet);
        weatherLayout.setVisibility(View.VISIBLE);
    }

    private void initView() {
        weatherLayout = (ScrollView) findViewById(R.id.weather_layout);
        bingPicImg = (ImageView) findViewById(R.id.bing_pic_img);
        titleCity = (TextView) findViewById(R.id.title_city);
        titleUpdateTime = (TextView) findViewById(R.id.title_update_time);
        degreeText = (TextView) findViewById(R.id.degree_text);
        weatherInfoText = (TextView) findViewById(R.id.weather_info_text);
        forecastLayout = (LinearLayout) findViewById(R.id.forecast_layout);
        aqiLayout = (LinearLayout) findViewById(R.id.aqi_layout);
        aqiText = (TextView) findViewById(R.id.aqi_text);
        pm25Text = (TextView) findViewById(R.id.pm25_text);
        comfortText = (TextView) findViewById(R.id.comfort_text);
        carWashText = (TextView) findViewById(R.id.car_wash_text);
        dressText = (TextView) findViewById(R.id.dress_text);
        influenzaText = (TextView) findViewById(R.id.influenza_text);
        sportText = (TextView) findViewById(R.id.sport_text);
        travelText = (TextView) findViewById(R.id.travel_text);
        ultravioletText = (TextView) findViewById(R.id.ultraviolet_text);
    }
}
