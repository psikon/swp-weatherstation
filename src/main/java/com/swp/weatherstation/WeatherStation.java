package com.swp.weatherstation;

import javax.annotation.PostConstruct;

import com.swp.weatherstation.database.DatabaseController;
import com.swp.weatherstation.service.WeatherService;
import com.swp.weatherstation.utils.ConsoleView;
import com.swp.weatherstation.utils.WeatherUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherStation {

    @Autowired
    private ConsoleView consoleView;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private DatabaseController databaseController;

    @Autowired
    private WeatherUtils weatherUtils;

    @PostConstruct
    public void run() {
        String location = "";
        consoleView.welcome();
        /*while ((location = consoleView.getLocation()) != null) {

            if (weatherUtils.isExit(location)) {
                break;
            }
            if (weatherUtils.isNullorEmpty(location)) {
                consoleView.setOutput("No Input found!");
            } else if (location.equals("history")) {
                consoleView.setOutput("Print History for location: ");
                String input = consoleView.getLocation();
                List<WeatherEntity> weatherEntities = weatherService.loadWeatherHistory(input);
                consoleView.setOutput(weatherUtils.printWeatherHistory(input, weatherEntities));
            } else {
                WeatherEntity weatherEntity = weatherService.saveWeatherInformation(location);
                consoleView.setOutput(weatherEntity.toString());
            }
        };*/
    }


}
