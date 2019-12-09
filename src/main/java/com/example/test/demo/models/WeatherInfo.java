package com.example.test.demo.models;

import java.io.Serializable;
import java.util.StringJoiner;

public class WeatherInfo implements Serializable {

    private Long id;

    private Integer temperature;

    private String sity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        this.sity = sity;
    }

    public WeatherInfo(Long id, Integer temperature, String sity) {
        this.id = id;
        this.temperature = temperature;
        this.sity = sity;
    }

    public WeatherInfo() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WeatherInfo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("temperature=" + temperature)
                .add("sity='" + sity + "'")
                .toString();
    }
}
