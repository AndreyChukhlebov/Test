package com.example.test.demo.controller;


import com.example.test.demo.logging.LogExecution;
import com.example.test.demo.models.GeoLocationInfo;
import com.example.test.demo.service.GeoLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/geo-location")
public class GeoLocationController {

    @Autowired
    private GeoLocationService geoLocationService;

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @LogExecution
    public GeoLocationInfo getInfo(@RequestBody String code) {
        return geoLocationService.geGeoLocationInfoByCode(code);
    }
}
