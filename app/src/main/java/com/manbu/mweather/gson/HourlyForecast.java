package com.manbu.mweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yang on 2017/2/11.
 */

public class HourlyForecast {

    /**
     * code : 100
     * txt : 晴
     */

    @SerializedName("cond")
    public CondBean cond;
    /**
     * cond : {"code":"100","txt":"晴"}
     * date : 2016-08-30 12:00
     * hum : 47
     * pop : 0
     * pres : 1006
     * tmp : 29
     * wind : {"deg":"335","dir":"西北风","sc":"4-5","spd":"36"}
     */

    @SerializedName("date")
    public String date;
    @SerializedName("hum")
    public String hum;
    @SerializedName("pop")
    public String pop;
    @SerializedName("pres")
    public String pres;
    @SerializedName("tmp")
    public String tmp;
    /**
     * deg : 335
     * dir : 西北风
     * sc : 4-5
     * spd : 36
     */

    @SerializedName("wind")
    public WindBean wind;

    public static class CondBean {
        @SerializedName("code")
        public String code;
        @SerializedName("txt")
        public String txt;
    }

    public static class WindBean {
        @SerializedName("deg")
        public String deg;
        @SerializedName("dir")
        public String dir;
        @SerializedName("sc")
        public String sc;
        @SerializedName("spd")
        public String spd;
    }
}
