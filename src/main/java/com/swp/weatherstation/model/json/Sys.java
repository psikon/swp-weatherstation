package com.swp.weatherstation.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sys {

    @JsonProperty("country")
    private String country;

    @JsonProperty("sunrise")
    private int sunrise;

    @JsonProperty("sunset")
    private int sunset;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }
}
