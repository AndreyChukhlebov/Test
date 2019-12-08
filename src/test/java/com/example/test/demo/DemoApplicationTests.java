package com.example.test.demo;

import com.example.test.demo.models.GeoLocationInfo;
import com.example.test.demo.models.WeatherInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Test
    public void happyGeoLocationTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/geo-location/info";
        URI uri = new URI(baseUrl);
        ResponseEntity<GeoLocationInfo> response = this.restTemplate.postForEntity(uri, "zip1", GeoLocationInfo.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        GeoLocationInfo geoLocationInfo = response.getBody();
        Assert.assertNotNull(geoLocationInfo);
    }

    @Test
    public void happyWeatheTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/weather/info";
        URI uri = new URI(baseUrl);
        ResponseEntity<WeatherInfo> response = restTemplate.getForEntity(uri + "/city1", WeatherInfo.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        WeatherInfo weatherInfo = response.getBody();
        Assert.assertNotNull(weatherInfo);
    }
}
