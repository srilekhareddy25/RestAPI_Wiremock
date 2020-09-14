package com.runner;

import org.junit.runner.RunWith;
//import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\technicals\\workspace\\CarRentalRestProject\\src\\test\\java\\com\\features",
glue= {"com.stepdefinition"})

public class CarRunner {

}
