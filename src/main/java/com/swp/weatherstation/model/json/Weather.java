package com.swp.weatherstation.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class Weather {

    private String message;

    @JsonProperty("cod")
    private String code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("dt")
    private long time;

    @JsonProperty("main")
    private Temp temperature;

    @JsonProperty("wind")
    private Wind wind;

    @JsonProperty("coord")
    private Coord coord;

    @JsonProperty("sys")
    private Sys sys;

    public Weather() {

    }

    public Weather(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Temp getTemperature() {
        return temperature;
    }

    public void setTemperature(Temp temperature) {
        this.temperature = temperature;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }
}
