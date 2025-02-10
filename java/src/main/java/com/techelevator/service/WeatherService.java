package com.techelevator.service;

import com.techelevator.model.LatLon;
import com.techelevator.model.WeatherObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private RestTemplate template = new RestTemplate();
    private final String API_URL = "http://api.openweathermap.org/";
    @Value("${OPEN_WEATHER_API_KEY}") //Note the ${} syntax!
    private String API_KEY;

    public LatLon getLatLong(String zip){
//        System.out.println(API_KEY);  //for debug
        String url = API_URL + "geo/1.0/zip?zip=" + zip + "&appid=" + API_KEY;
        return template.getForObject(url, LatLon.class);
    }
    public WeatherObject getWeather(LatLon latLon){
        String url = "https://api.openweathermap.org" +
                "/data/2.5/weather?lat=" + latLon.getLat() +
                "&lon=" + latLon.getLon() +
                "&appid=" + API_KEY + "&units=imperial";
        WeatherObject response =
                template.getForObject(url, WeatherObject.class);
        return response;
    }




}
