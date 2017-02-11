package com.manbu.mweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yang on 2017/2/11.
 */

public class AQI {

    /**
     * aqi : 60
     * co : 0
     * no2 : 14
     * o3 : 95
     * pm10 : 67
     * pm25 : 15
     * qlty : 良
     * so2 : 10
     */

    @SerializedName("city")
    public CityBean city;

    public static class CityBean {
        @SerializedName("aqi")
        public String aqi;
        @SerializedName("co")
        public String co;
        @SerializedName("no2")
        public String no2;
        @SerializedName("o3")
        public String o3;
        @SerializedName("pm10")
        public String pm10;
        @SerializedName("pm25")
        public String pm25;
        @SerializedName("qlty")
        public String qlty;
        @SerializedName("so2")
        public String so2;
    }
}
