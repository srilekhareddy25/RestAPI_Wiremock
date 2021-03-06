package com.rentalcartests;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.objects.Car;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LowestPerdayRental {

	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		String URL = "http://localhost:4567/getcars";
		
		RestAssured.baseURI=URL;
		

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
}
