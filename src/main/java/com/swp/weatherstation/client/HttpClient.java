package com.swp.weatherstation.client;

import org.springframework.stereotype.Component;

@Component
public interface HttpClient {

    String getData(String location);

    String getRequestUrl(String location);
}
