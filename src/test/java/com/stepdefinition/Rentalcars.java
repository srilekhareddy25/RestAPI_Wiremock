package com.stepdefinition;

import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.objects.Car;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Rentalcars {
	
	@Given("^I Set getcars service api endpoint$")
	public void i_Set_getcars_service_api_endpoint() throws Throwable {
		
		String URL = "http://localhost:4567/getcars";
		
		RestAssured.baseURI=URL;
		  
	}

	@When("^I Send a GET HTTP request for blue teslas$")
	public void i_Send_a_GET_HTTP_request_for_blue_teslas() throws Throwable {
	    
		Response res = RestAssured.get();
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode carsNode = objectMapper.readTree(res.asString());
		ArrayNode carArrayNode = (ArrayNode) carsNode.get("cars");
		
		Iterator<JsonNode> carIterator = carArrayNode.elements();
		while (carIterator.hasNext()) {
		    JsonNode carNode = carIterator.next();
		    JsonNode carText = carNode.get("Car");
		    String carData = objectMapper.writeValueAsString(carText);
		    //System.out.println(carData);
		    Car car = objectMapper.readValue(carData, Car.class);
		    if (car.getMake().equalsIgnoreCase("Tesla")) {
	            if(car.getMetadata().getColor().equalsIgnoreCase("Blue")  ) {
	               System.out.println(car.getMake());
	               System.out.println(car.getMetadata().getColor());
	               System.out.println(car.getMetadata().getNotes());
	               
	            }
	         }
		    
		}
		System.out.println(res.statusCode());
	}

	@Then("^I got a response with all blue teslas with notes$")
	public void i_got_a_response_with_all_blue_teslas_with_notes() throws Throwable {
		
		 
	   
	}

	@And("^status code will be (\\d+)$")
	public void status_code_will_be(int arg1) throws Throwable {
	   	
	}
	
	@When("^I Send a GET HTTP request for highest revenue generating car$")
	public void i_Send_a_GET_HTTP_request_for_highest_revenue_generating_car() throws Throwable {
Response res = RestAssured.get();
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode carsNode = objectMapper.readTree(res.asString());
		ArrayNode carArrayNode = (ArrayNode) carsNode.get("cars");
		
		Iterator<JsonNode> carIterator = carArrayNode.elements();
		double price = Integer.MIN_VALUE;
		Car HighestRevenueCar = new Car(); 
		
		

		while (carIterator.hasNext()) {
		    JsonNode carNode = carIterator.next();
		    JsonNode carText = carNode.get("Car");
		    String carData = objectMapper.writeValueAsString(carText);
		    //System.out.println(carData);
		    Car car = objectMapper.readValue(carData, Car.class);
		    
		    if(((car.getPerdayrent().getPrice()-car.getPerdayrent().getDiscount())*(car.getMetrics().getRentalcount().getYeartodate()))-(car.getMetrics().getYoymaintenancecost()+car.getMetrics().getDepreciation()) > price) {
		    	price = ((car.getPerdayrent().getPrice()-car.getPerdayrent().getDiscount())*(car.getMetrics().getRentalcount().getYeartodate()))-(car.getMetrics().getYoymaintenancecost()+car.getMetrics().getDepreciation());
		    	HighestRevenueCar = car;
		    }
		    
		   
		}
		
		System.out.println(HighestRevenueCar.getMake());
		System.out.println(res.statusCode()); 
	}

	@Then("^I got a response with highest revenue generating car$")
	public void i_got_a_response_with_highest_revenue_generating_car() throws Throwable {
	    
	}
	@When("^I Send a GET HTTP request for cars with the lowest per day rental cost$")
	public void i_Send_a_GET_HTTP_request_for_cars_with_the_lowest_per_day_rental_cost() throws Throwable {
Response res = RestAssured.get();
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode carsNode = objectMapper.readTree(res.asString());
		ArrayNode carArrayNode = (ArrayNode) carsNode.get("cars");
		
		Iterator<JsonNode> carIterator = carArrayNode.elements();
		double price = Integer.MAX_VALUE, priceafterDiscount = Integer.MAX_VALUE;
		Car cheapRentCar = new Car(); 		Car cheapRentCarWithDiscount = new Car();

		while (carIterator.hasNext()) {
		    JsonNode carNode = carIterator.next();
		    JsonNode carText = carNode.get("Car");
		    String carData = objectMapper.writeValueAsString(carText);
		    //System.out.println(carData);
		    Car car = objectMapper.readValue(carData, Car.class);
		    
		    if(car.getPerdayrent().getPrice() < price) {
		    	price = car.getPerdayrent().getPrice();
		    	cheapRentCar = car;
		    }
		    
		    if(car.getPerdayrent().getPrice() - car.getPerdayrent().getDiscount() < priceafterDiscount) {
		    	priceafterDiscount = car.getPerdayrent().getPrice() - car.getPerdayrent().getDiscount();
		    	cheapRentCarWithDiscount = car;
		    }
		    
		}
		
		System.out.println(cheapRentCar.getMake() + "---" + cheapRentCarWithDiscount.getMake());
	}

	@Then("^I got a response with cars which have the lowest per day rental cost$")
	public void i_got_a_response_with_cars_which_have_the_lowest_per_day_rental_cost() throws Throwable {
	    
	}



}
