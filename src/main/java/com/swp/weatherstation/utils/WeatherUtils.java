package com.swp.weatherstation.utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.swp.weatherstation.model.entity.WeatherEntity;
import com.swp.weatherstation.model.json.Weather;
import org.springframework.stereotype.Component;

@Component
public class WeatherUtils {

    private static final String SEPARATOR = ",";
    private static final String NEWLINE = "\n";
    private static final String TAB = "\t";
    private static final String EXIT = "exit";

    public boolean isExit(String s) {
        return s.equals(EXIT);
    }

    public String printWeatherHistory(String location, List<WeatherEntity> weatherEntities) {
        StringBuilder sb = new StringBuilder();
        sb.append("History for: ").append(location).append(NEWLINE);
        if (weatherEntities.isEmpty()) {
            sb.append("No data found!");
        } else {
            weatherEntities.forEach(entity -> {
                sb.append(parseDate(entity.getTime())).append("\t")
                        .append("Temp: ").append(entity.getCurrentTemperature()).append("\t")
                        .append("Wind Speed: ").append(entity.getSpeed()).append(NEWLINE);
            });
        }
        return sb.toString();
    }

    public Weather getFailedResponse(String code, String message) {
        return new Weather(code, message);
    }

    public boolean isNullorEmpty(String s) {
        return s == null || s.equals("");
    }

    private String parseDate(long dt) {
        SimpleDateFormat newFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        Date date = new Date((dt) * 1000L);
        return newFormat.format(date);
    }

}
