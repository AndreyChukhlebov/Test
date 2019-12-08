package com.example.test.demo.controller;


import com.example.test.demo.logging.LogExecution;
import com.example.test.demo.models.WeatherInfo;
import com.example.test.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/info/{code}", method = GET)
    @ResponseBody
    @LogExecution
    public WeatherInfo getTest(@PathVariable String code) {
        return weatherService.getWeatherByCode(code);
    }
}
