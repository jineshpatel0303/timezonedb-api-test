package com.example.models;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.rest.SerenityRest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaseResponse {
    public Map<String, Object> returned() throws IOException {
        return new ObjectMapper().readValue(SerenityRest.lastResponse().getBody().prettyPrint(), new TypeReference<HashMap<String, Object>>() {
        });
    }
}
