package com.swp.weatherstation.model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity(name="weather")
public class WeatherEntity {

    private static final String SEPARATOR = ",";
    private static final String NEWLINE = "\n";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private long time;

    private String country;

    private double latitude;

    private double longitude;

    private double currentTemperature;

    private double tempMin;

    private double tempMax;

    private int pressure;

    private int humidity;

    private double speed;

    private int deg;

    private int sunrise;

    private int sunset;

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

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
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

    public String dateToString(long intTime) {
        SimpleDateFormat newFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        Date date = new Date((intTime) * 1000L);
        return newFormat.format(date);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(SEPARATOR).append(country)
                .append(" \t(Lon: ").append(getLongitude())
                .append(SEPARATOR).append(" Lat: ").append(latitude).append(")").append(NEWLINE)
                .append("Time: ").append(dateToString(time)).append(NEWLINE)
                .append("Temperature\t\t\tWind").append(NEWLINE)
                .append("\tCurrent: ").append(currentTemperature)
                .append("\tSpeed: ").append(speed).append(NEWLINE)
                .append("\tMin: ").append(tempMin)
                .append("\tDeg: ").append(deg).append(NEWLINE)
                .append("\tMax: ").append(tempMax);
        return sb.toString();
    }
}

