package com.manbu.mweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yang on 2017/2/11.
 */

public class DailyForecast {

    /**
     * mr : 03:09
     * ms : 17:06
     * sr : 05:28
     * ss : 18:29
     */

    @SerializedName("astro")
    public AstroBean astro;
    /**
     * code_d : 100
     * code_n : 100
     * txt_d : 晴
     * txt_n : 晴
     */

    @SerializedName("cond")
    public CondBean cond;
    /**
     * astro : {"mr":"03:09","ms":"17:06","sr":"05:28","ss":"18:29"}
     * cond : {"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"}
     * date : 2016-08-30
     * hum : 45
     * pcpn : 0.0
     * pop : 8
     * pres : 1005
     * tmp : {"max":"29","min":"22"}
     * vis : 10
     * wind : {"deg":"339","dir":"北风","sc":"4-5","spd":"24"}
     */

    @SerializedName("date")
    public String date;
    @SerializedName("hum")
    public String hum;
    @SerializedName("pcpn")
    public String pcpn;
    @SerializedName("pop")
    public String pop;
    @SerializedName("pres")
    public String pres;
    /**
     * max : 29
     * min : 22
     */

    @SerializedName("tmp")
    public TmpBean tmp;
    @SerializedName("vis")
    public String vis;
    /**
     * deg : 339
     * dir : 北风
     * sc : 4-5
     * spd : 24
     */

    @SerializedName("wind")
    public WindBean wind;

    public static class AstroBean {
        @SerializedName("mr")
        public String mr;
        @SerializedName("ms")
        public String ms;
        @SerializedName("sr")
        public String sr;
        @SerializedName("ss")
        public String ss;
    }

    public static class CondBean {
        @SerializedName("code_d")
        public String codeD;
        @SerializedName("code_n")
        public String codeN;
        @SerializedName("txt_d")
        public String txtD;
        @SerializedName("txt_n")
        public String txtN;
    }

    public static class TmpBean {
        @SerializedName("max")
        public String max;
        @SerializedName("min")
        public String min;
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
