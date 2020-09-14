
Feature: Test methods for rental cars api testing
  
Scenario: Print all the blue Teslas received in the web service response. Also print the notes
    Given I Set getcars service api endpoint
    When  I Send a GET HTTP request for blue teslas 
    Then  I got a response with all blue teslas with notes
    And   status code will be 200

 Scenario: Find the highest revenue generating car. 
 year over year maintenance cost + depreciation is the total expense per car for the full year for the rental car company.
    Given I Set getcars service api endpoint
    When  I Send a GET HTTP request for highest revenue generating car
    Then  I got a response with highest revenue generating car
    And   status code will be 200
    
    Scenario: Return all cars which have the lowest per day rental cost
    Given I Set getcars service api endpoint
    When  I Send a GET HTTP request for cars with the lowest per day rental cost
    Then  I got a response with cars which have the lowest per day rental cost
    And   status code will be 200
 
  