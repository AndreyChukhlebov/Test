package com.example.test.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void run(String... strings) throws Exception {

        log.info("Creating table geolocations");
        jdbcTemplate.execute("drop table geolocations if exists");
        jdbcTemplate.execute("create table geolocations(id serial, time_zone varchar(255), zip varchar(255))");
        List<Object[]> splitGeolocationData = Arrays.asList("zone1 zip1", "zone2 zip2", "zone4 zip4", "zone3 zip3").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());
        splitGeolocationData.forEach(name -> log.info(String.format("Inserting geolocations record for %s %s", name[0], name[1])));
        jdbcTemplate.batchUpdate("insert into geolocations(time_zone, zip) values (?,?)", splitGeolocationData);


        log.info("Creating table weather_info");
        jdbcTemplate.execute("drop table weather_info if exists");
        jdbcTemplate.execute("create table weather_info(id serial, sity_code varchar(255), temperature number )");
        List<Object[]> splitUpNames = Arrays.asList("city1 100", "city2 23", "city3 44", "city4 222").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());
        splitUpNames.forEach(name -> log.info(String.format("Inserting weather_info record for %s %s", name[0], name[1])));
        jdbcTemplate.batchUpdate("insert into weather_info(sity_code, temperature) values (?,?)", splitUpNames);
    }

}
