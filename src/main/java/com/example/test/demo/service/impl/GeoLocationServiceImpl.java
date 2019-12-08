package com.example.test.demo.service.impl;

import com.example.test.demo.models.GeoLocationInfo;
import com.example.test.demo.service.GeoLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class GeoLocationServiceImpl implements GeoLocationService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public GeoLocationInfo geGeoLocationInfoByCode(String code) {
        return jdbcTemplate.queryForObject(
                "SELECT id, zip, time_zone FROM geolocations WHERE zip = ?", new Object[]{code},
                (rs, rowNum) -> new GeoLocationInfo(
                        rs.getLong("id"),
                        rs.getString("zip"),
                        rs.getString("time_zone"))
        );
    }
}
