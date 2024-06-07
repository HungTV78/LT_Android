package com.example.ktl2_14_letanhung;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Country implements Serializable {
    @SerializedName("name")
    public Name name;

    @SerializedName("capital")
    public List<String> capital;

    @SerializedName("population")
    public long population;

    @SerializedName("continents")
    public List<String> continents;

    @SerializedName("languages")
    public Map<String, String> languages;

    @SerializedName("flags")
    public Flags flags;

    public static class Name implements Serializable {
        @SerializedName("common")
        public String common;

        @SerializedName("official")
        public String official;
    }

    public static class Flags implements Serializable {
        @SerializedName("png")
        public String png;

        @SerializedName("svg")
        public String svg;
    }
}
