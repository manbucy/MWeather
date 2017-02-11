package com.manbu.mweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yang on 2017/2/11.
 */

public class HeWeather {

    @SerializedName("alarms")
    public List<Alarm> alarms;

    @SerializedName("aqi")
    public AQI aqi;

    @SerializedName("basic")
    public Basic basic;

    @SerializedName("daily_forecast")
    public List<DailyForecast> dailyForecasts;

    @SerializedName("hourly_forecast")
    public List<HourlyForecast> hourlyForecasts;

    @SerializedName("now")
    public Now now;

    @SerializedName("status")
    public  String status;

    @SerializedName("suggestion")
    public Suggestion suggestion;

}
