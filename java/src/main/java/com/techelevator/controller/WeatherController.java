package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.LatLon;
import com.techelevator.model.User;
import com.techelevator.model.WeatherDto;
import com.techelevator.model.WeatherObject;
import com.techelevator.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin
public class WeatherController {
    // could put a constructor in here, but using @Autowired will let Spring hook it up
    @Autowired // lets spring wire together our @Service and annotated file
    private WeatherService weatherService;
    @Autowired
    private UserDao userDao;

    @GetMapping("/weather")  // http://localhost:9000/weather?zip=XXXXX => zip will be request param
    public WeatherDto getWeather(@RequestParam String zip,
                                 Principal principal){

//        User user = userDao.getUserByUsername(principal.getName());
        LatLon latLon = weatherService.getLatLong(zip);

        //return weatherService.getWeather(latLon, 0); //user.getId());
        return null;  //commented above out so I can do Sunday night push without errors.
    }
}
