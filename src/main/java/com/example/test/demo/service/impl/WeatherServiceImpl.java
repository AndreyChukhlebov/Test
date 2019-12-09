package com.example.test.demo.service.impl;

import com.example.test.demo.models.WeatherInfo;
import com.example.test.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public WeatherInfo getWeatherByCode(String code) {
        return jdbcTemplate.queryForObject(
                "select id, temperature, sity_code from weather_info where sity_code = ?", new Object[]{code},
                (rs, rowNum) -> new WeatherInfo(
                        rs.getLong("id"),
                        rs.getInt("temperature"),
                        rs.getString("sity_code"))
        );
    }
}
