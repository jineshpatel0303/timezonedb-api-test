package com.example.models;

import net.serenitybdd.rest.SerenityRest;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

public class TimeZone {
    public void getAllTimeZone(String key, String format) throws IOException {
        SerenityRest.given().contentType(MediaType.TEXT_HTML)
                .queryParam("key", key)
                .queryParam("format", format)
                .when()
                .get("http://api.timezonedb.com/v2.1/list-time-zone");
    }

    public void getTimeByZone(String key, String format, String zone) throws IOException {
        SerenityRest.given().contentType(MediaType.TEXT_HTML)
                .queryParam("key", key)
                .queryParam("format", format)
                .queryParam("by", "zone")
                .queryParam("zone", zone)
                .when()
                .get("http://api.timezonedb.com/v2.1/list-time-zone");
    }
}
