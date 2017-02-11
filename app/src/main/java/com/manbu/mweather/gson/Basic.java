package com.manbu.mweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yang on 2017/2/11.
 */

public class Basic {


    /**
     * city : 青岛
     * cnty : 中国
     * id : CN101120201
     * lat : 36.088000
     * lon : 120.343000
     * prov : 山东
     * update : {"loc":"2016-08-30 11:52","utc":"2016-08-30 03:52"}
     */

    @SerializedName("city")
    public String city;
    @SerializedName("cnty")
    public String cnty;
    @SerializedName("id")
    public String id;
    @SerializedName("lat")
    public String lat;
    @SerializedName("lon")
    public String lon;
    @SerializedName("prov")
    public String prov;
    /**
     * loc : 2016-08-30 11:52
     * utc : 2016-08-30 03:52
     */

    @SerializedName("update")
    public UpdateBean update;

    public static class UpdateBean {
        @SerializedName("loc")
        public String loc;
        @SerializedName("utc")
        public String utc;
    }
}
