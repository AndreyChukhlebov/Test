package com.example.test.demo.configuration;

import com.example.test.demo.service.GeoLocationService;
import com.example.test.demo.service.WeatherService;
import com.example.test.demo.service.impl.GeoLocationServiceImpl;
import com.example.test.demo.service.impl.WeatherServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public WeatherService weatherService() {
        return new WeatherServiceImpl();
    }

    @Bean
    public GeoLocationService geoLocationService() {
        return new GeoLocationServiceImpl();
    }
}
