package com.swp.weatherstation.controller;

import java.util.List;

import com.swp.weatherstation.model.entity.WeatherEntity;
import com.swp.weatherstation.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/search/{name}")
    public WeatherEntity search(@PathVariable("name") String name){
        WeatherEntity weatherEntity = weatherService.saveWeatherInformation(name.toLowerCase());
        return weatherEntity;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/history/{name}", produces = "application/json")
    public List<WeatherEntity> history(@PathVariable("name") String name) {
        List<WeatherEntity> weatherEntities = weatherService.loadWeatherHistory(name.toLowerCase());
        return weatherEntities;
    }

    }
