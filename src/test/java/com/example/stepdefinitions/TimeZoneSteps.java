package com.example.stepdefinitions;

import com.example.constants.ApplicationConstants;
import com.example.constants.ResponseConstants;
import com.example.models.TimeZone;
import com.example.utils.EnvironmentConfiguration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import com.example.models.BaseResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeZoneSteps {

    @Steps
    TimeZone timeZone;

    @Steps
    BaseResponse baseResponse;

    private String timezone;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime localTime;

    @Given("I have access to timezonedb")
    public void iHaveAccessToTimezonedb(){
    }

    @When("I request for all timezone")
    public void iRequestForAllTimezone() throws IOException {
        timeZone.getAllTimeZone(EnvironmentConfiguration.getProperty(ApplicationConstants.KEY), ApplicationConstants.FORMAT);
    }

    @Then("It should return {string} and timezone with all {string}")
    public void itShouldReturnAndTimezoneWithAll(String responseStatus, String dataKey) throws IOException {
        Map<String, Object> actualResponse = baseResponse.returned();
        assertThat(actualResponse).isNotNull();
        assertThat(actualResponse.get(ResponseConstants.STATUS_CODE)).isEqualTo(200);

        Map<String, Object> responseObject = (Map) actualResponse.get(ResponseConstants.ZONE);
        assertThat(responseObject).isNotNull();
        assertThat(responseObject.get(ResponseConstants.STATUS)).isEqualTo(responseStatus);
        assertThat(responseObject.get(dataKey)).isNotNull();

    }

    @Given("I provide the following timezone:")
    public void iProvideTheFollowingTimezone(List<String> timezoneDetail){
        timezone = timezoneDetail.get(1);
    }

    @When("I request for specified timezone")
    public void iRequestForSpecifiedTimezone() throws IOException {
        localTime = LocalDateTime.now();
        timeZone.getTimeByZone(EnvironmentConfiguration.getProperty(ApplicationConstants.KEY), ApplicationConstants.FORMAT, timezone);
    }

    @Then("It should return {string} with countryname {string}")
    public void itShouldReturnWithCountryname(String responseStatus, String countryName) throws IOException {
        Map<String, Object> actualResponse = baseResponse.returned();
        assertThat(actualResponse).isNotNull();
        assertThat(actualResponse.get(ResponseConstants.STATUS_CODE)).isEqualTo(200);
        assertThat(actualResponse.get(ResponseConstants.STATUS)).isEqualTo(responseStatus);
        assertThat(actualResponse.get(ResponseConstants.COUNTRY_NAME)).isEqualTo(countryName);

        assertThat(actualResponse.get(ResponseConstants.FORMATTED)).isEqualTo(localTime);

    }


}
