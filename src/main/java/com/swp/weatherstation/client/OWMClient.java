package com.swp.weatherstation.client;

import java.io.IOException;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

@Component
public class OWMClient implements HttpClient{

    public static final String API_BASE = "http://api.openweathermap.org/data/2.5/weather?q=";
    public static final String UNITS = "metric"; // imperial
    public static final String FORMAT = "json";
    public static final String LANGUAGE = "en";
    public static final String API_KEY = "3ff9e5852c99fad6d597ad0c662db2f0";

    @Override
    public String getData(String location) {
        String response = "";
        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(getRequestUrl(location));
            request.addHeader("accept", "application/json");
            HttpResponse httpResponse = client.execute(request);
            response = IOUtils.toString(httpResponse.getEntity().getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public String getRequestUrl(String location) {
        StringBuilder sb = new StringBuilder()
                .append(API_BASE)
                .append(location)
                .append("&units=")
                .append(UNITS)
                .append("&mode=")
                .append(FORMAT)
                .append("&appid=")
                .append(API_KEY);
        return sb.toString();
    }
}
