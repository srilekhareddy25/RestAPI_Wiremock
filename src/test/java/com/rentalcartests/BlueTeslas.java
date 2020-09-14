package com.rentalcartests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.objects.Car;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BlueTeslas {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
	String URL = "http://localhost:4567/getcars";
	
	RestAssured.baseURI=URL;
	

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
}
