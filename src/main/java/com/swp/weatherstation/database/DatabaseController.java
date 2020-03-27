package com.swp.weatherstation.database;

import java.util.ArrayList;
import java.util.List;

import com.swp.weatherstation.model.entity.WeatherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseController {

    @Autowired
    private WeatherRepository repository;

    public void save(WeatherEntity weatherEntity) {
        repository.save(weatherEntity);
    }

    public List<WeatherEntity> findAllByLocation(String name) {
        List<WeatherEntity> weatherEntities = new ArrayList<>();
        Iterable<WeatherEntity> all = repository.findAll();
        for (WeatherEntity entity : all) {
            if (entity.getName() != null && entity.getName().toLowerCase().equals(name)) {
                weatherEntities.add(entity);
            }
        }
        return weatherEntities;
    }


}
