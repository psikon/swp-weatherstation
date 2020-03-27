package com.swp.weatherstation.model;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swp.weatherstation.model.entity.WeatherEntity;
import com.swp.weatherstation.model.json.Weather;
import com.swp.weatherstation.utils.WeatherConstants;
import com.swp.weatherstation.utils.WeatherUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherParser {

    private static String NODE_TEMP ="/main";
    private static final String NODE_COORD = "/coord";
    private static final String NODE_WIND = "/wind";

    @Autowired
    private WeatherUtils weatherUtils;

    private List<String> nodes = Arrays.asList(NODE_TEMP, NODE_COORD, NODE_WIND);

    public Weather parseWeatherFromJson(String json) {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Weather weather = new Weather();
        try {
            weather = mapper.readValue(json, Weather.class);
        } catch (IOException e) {
            return weatherUtils.getFailedResponse("500", e.getMessage());
        }
        if (weather.getCode().equals("404") ) {
            return weatherUtils.getFailedResponse(weather.getCode(), WeatherConstants.NOT_FOUND);
        }
        return weather;
    }

    public WeatherEntity mapWeatherToEntity(Weather weather) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(weather, WeatherEntity.class);
    }



}
