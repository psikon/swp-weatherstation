package com.swp.weatherstation.service;

import java.util.List;

import com.swp.weatherstation.client.HttpClient;
import com.swp.weatherstation.model.WeatherParser;
import com.swp.weatherstation.model.entity.WeatherEntity;
import com.swp.weatherstation.model.json.Weather;
import com.swp.weatherstation.WeatherConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherService {

    @Autowired
    private HttpClient httpClient;

    @Autowired
    private WeatherParser weatherParser;

    @Autowired
    private DatabaseService databaseService;

    public WeatherEntity saveWeatherInformation(String location) {
        String response = httpClient.getData(location);
        Weather weather = weatherParser.parseWeatherFromJson(response);
        WeatherEntity weatherEntity = weatherParser.mapWeatherToEntity(weather);
        weatherEntity.setDescription(weatherParser.getDescription(weather));
        weatherEntity.setIcon(weatherParser.getIcon(weather));
        if (weatherEntity.getName() != null) {
            databaseService.save(weatherEntity);
        } else {
            weatherEntity.setName(WeatherConstants.NOT_FOUND);
        }
        return weatherEntity;
    }

    public List<WeatherEntity> loadWeatherHistory(String location) {
        List<WeatherEntity> weatherEntities = databaseService.findAllByLocation(location);
        return weatherEntities;
    }


}
