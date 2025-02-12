package com.techelevator.service;

import com.techelevator.model.LatLon;
import com.techelevator.model.WeatherDto;
import com.techelevator.model.WeatherObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class WeatherService {

    private RestTemplate template = new RestTemplate();
    private final String API_URL = "http://api.openweathermap.org/";

    @Value("${OPEN_WEATHER_API_KEY}")
    private String API_KEY;

    public LatLon getLatLong(String zip){
//        System.out.println(API_KEY);
        String url = API_URL + "geo/1.0/zip?zip=" + zip + "&appid=" + API_KEY;
        return template.getForObject(url, LatLon.class);

    }

    public WeatherDto getWeather(LatLon latLon, int userId){
        String url = "https://api.openweathermap.org" +
                "/data/2.5/weather?lat=" + latLon.getLat() +
                "&lon=" + latLon.getLon() +
                "&appid=" + API_KEY + "&units=imperial";
        WeatherObject response =
                template.getForObject(url, WeatherObject.class);
        WeatherDto dto = new WeatherDto(0, userId,
                Integer.parseInt(latLon.getZip()),
                LocalDate.now(),
                response.getMain().getTemp(),
                response.getMain().getFeelsLike(),
                response.getMain().getHumidity(),
                response.getWeather()[0].getDescription(),
                response.getWeather()[0].getIcon(),
                latLon.getName());
        return dto;
    }
}
