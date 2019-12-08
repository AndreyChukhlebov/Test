package com.example.test.demo.models;

import java.io.Serializable;
import java.util.StringJoiner;

public class GeoLocationInfo implements Serializable {

    private Long id;

    private String zipCode;

    private String timeZone;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GeoLocationInfo(long id, String zipCode, String timeZone) {
        this.id = id;
        this.zipCode = zipCode;
        this.timeZone = timeZone;
    }

    public GeoLocationInfo() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GeoLocationInfo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("zipCode='" + zipCode + "'")
                .add("timeZone='" + timeZone + "'")
                .toString();
    }
}
