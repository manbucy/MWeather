package com.manbu.mweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yang on 2017/2/11.
 */

public class Suggestion {

    /**
     * brf : 较舒适
     * txt : 白天天气晴好，您在这种天气条件下，会感觉早晚凉爽、舒适，午后偏热。
     */

    @SerializedName("comf")
    public ComfBean comf;
    /**
     * brf : 较不宜
     * txt : 较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。
     */

    @SerializedName("cw")
    public CwBean cw;
    /**
     * brf : 热
     * txt : 天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。
     */

    @SerializedName("drsg")
    public DrsgBean drsg;
    /**
     * brf : 较易发
     * txt : 虽然温度适宜但风力较大，仍较易发生感冒，体质较弱的朋友请注意适当防护。
     */

    @SerializedName("flu")
    public FluBean flu;
    /**
     * brf : 较适宜
     * txt : 天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意防风。
     */

    @SerializedName("sport")
    public SportBean sport;
    /**
     * brf : 适宜
     * txt : 天气较好，风稍大，但温度适宜，是个好天气哦。适宜旅游，您可以尽情地享受大自然的无限风光。
     */

    @SerializedName("trav")
    public TravBean trav;
    /**
     * brf : 强
     * txt : 紫外线辐射强，建议涂擦SPF20左右、PA++的防晒护肤品。避免在10点至14点暴露于日光下。
     */

    @SerializedName("uv")
    public UvBean uv;

    public static class ComfBean {
        @SerializedName("brf")
        public String brf;
        @SerializedName("txt")
        public String txt;
    }

    public static class CwBean {
        @SerializedName("brf")
        public String brf;
        @SerializedName("txt")
        public String txt;
    }

    public static class DrsgBean {
        @SerializedName("brf")
        public String brf;
        @SerializedName("txt")
        public String txt;
    }

    public static class FluBean {
        @SerializedName("brf")
        public String brf;
        @SerializedName("txt")
        public String txt;
    }

    public static class SportBean {
        @SerializedName("brf")
        public String brf;
        @SerializedName("txt")
        public String txt;
    }

    public static class TravBean {
        @SerializedName("brf")
        public String brf;
        @SerializedName("txt")
        public String txt;
    }

    public static class UvBean {
        @SerializedName("brf")
        public String brf;
        @SerializedName("txt")
        public String txt;
    }
}
