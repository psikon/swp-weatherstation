package com.swp.weatherstation.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swp.weatherstation.WeatherConstants;
import com.swp.weatherstation.model.entity.WeatherEntity;
import com.swp.weatherstation.model.json.Weather;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class WeatherParser {

    public Weather parseWeatherFromJson(String json) {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Weather weather = new Weather();
        try {
            weather = mapper.readValue(json, Weather.class);
        } catch (IOException e) {
            return getFailedResponse("500", e.getMessage());
        }
        if (weather.getCode().equals("404") ) {
            return getFailedResponse(weather.getCode(), WeatherConstants.NOT_FOUND);
        }
        return weather;
    }

    public WeatherEntity mapWeatherToEntity(Weather weather) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(weather, WeatherEntity.class);
    }

    public String getDescription(Weather weather) {
        if (weather.getDescriptionList().isEmpty()){
            return "";
        }
        return weather.getDescriptionList().get(0).getDescription();
    }

    public String getIcon(Weather weather) {
        if(weather.getDescriptionList().isEmpty()) {
            return "";
        }
        return weather.getDescriptionList().get(0).getIcon();
    }

    private Weather getFailedResponse(String code, String message) {
        return new Weather(code, message);
    }


}
