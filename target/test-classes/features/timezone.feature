Feature: Get the timezone

  Scenario: Get all timezones
    Given I have access to timezonedb
    When I request for all timezone
    Then It should return "OK" and timezone with all "zones"

  Scenario: Get localtime timezone
    Given I provide the following timezone:
      |zone         |
      |Asia/Kolkata |
    When I request for specified timezone
    Then It should return "OK" with countryname "India"