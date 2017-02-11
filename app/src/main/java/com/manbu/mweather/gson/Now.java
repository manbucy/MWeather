package com.manbu.mweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yang on 2017/2/11.
 */

public class Now {

    /**
     * code : 100
     * txt : 晴
     */

    @SerializedName("cond")
    public CondBean cond;
    /**
     * cond : {"code":"100","txt":"晴"}
     * fl : 28
     * hum : 41
     * pcpn : 0
     * pres : 1005
     * tmp : 26
     * vis : 10
     * wind : {"deg":"330","dir":"西北风","sc":"6-7","spd":"34"}
     */

    @SerializedName("fl")
    public String fl;
    @SerializedName("hum")
    public String hum;
    @SerializedName("pcpn")
    public String pcpn;
    @SerializedName("pres")
    public String pres;
    @SerializedName("tmp")
    public String tmp;
    @SerializedName("vis")
    public String vis;
    /**
     * deg : 330
     * dir : 西北风
     * sc : 6-7
     * spd : 34
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
