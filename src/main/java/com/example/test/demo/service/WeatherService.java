package com.example.test.demo.service;

import com.example.test.demo.models.WeatherInfo;

public interface WeatherService {

    WeatherInfo getWeatherByCode(String code);

}
