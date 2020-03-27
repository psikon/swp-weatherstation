package com.swp.weatherstation.database;

import java.util.List;

import com.swp.weatherstation.model.entity.WeatherEntity;
import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<WeatherEntity, Long> {

    List<WeatherEntity> findByName(String name);
}
