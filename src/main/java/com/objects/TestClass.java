package com.objects;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class TestClass {

    static String CarResponse = "" + 
    		"{" + 
    		"  \"cars\" : [" + 
    		"				{	" + 
    		"					\"Car\" : {" + 
    		"     \"make\": \"Audi\"" + "," +
    		"	  \"model\": \"A7\"" + "," +
    		"     \"vin\": \"09AGHY64352JITEG98K\"" + "," +
    		"     \"metadata\" : {" + 
    		"         \"Color\" : \"Black\"" + "," +
    		"         \"Notes\" : \"Scratches on the front side of the car\"" +
    		"         }" + "," +
    		"     \"perdayrent\" : {" + 
    		"        \"Price\" : 140" + "," +
    		"         \"Discount\" : 15" + 
    		"         }" + "," +
    		"     \"metrics\" : {" + 
    		"         \"yoymaintenancecost\" : 2190.76" + "," +
    		"         \"depreciation\": 2256.43" + "," +
    		"         \"rentalcount\" : {" + 
    		"             \"lastweek\" : 4" + "," +
    		"             \"yeartodate\" : 221" +
    		"             }" +
    		"         }" + 
    		"} " +
    		"    }," + 
    		"				{" + 
    		"					\"Car\" : {" + 
    		"     \"make\": \"Tesla\"" + "," +
    		"	  \"model\": \"B7\"" + "," +
    		"     \"vin\": \"09AGHY64352JITEG62K\"" + "," +
    		"     \"metadata\" : {" + 
    		"         \"Color\" : \"Blue\"" + "," +
    		"         \"Notes\" : \"Scratches on the Top of the car\"" + 
    		"         }" + "," +
    		"     \"perdayrent\" : {" + 
    		"        \"Price\" : 170" + "," +
    		"         \"Discount\" : 20" + 
    		"         }" + "," +
    		"     \"metrics\" : {" + 
    		"         \"yoymaintenancecost\" : 2590.76" + "," +
    		"         \"depreciation\": 3256.43" + "," +
    		"         \"rentalcount\" : {" + 
    		"             \"lastweek\" : 8" + "," +
    		"             \"yeartodate\" : 231" +
    		"             }" + 
    		"         }" + 
    		"    }" + 
    		"	}," + 
    		"				{" + 
    		"				\"Car\" : {" + 
    		"     \"make\": \"Toyota\"" + "," +
    		"	  \"model\": \"C7\"" + "," +
    		"     \"vin\": \"09AGHY64352JITEG99K\"" + "," +
    		"     \"metadata\" : {" + 
    		"         \"Color\" : \"RED\"" + "," +
    		"         \"Notes\" : \"Scratches on the Left Window of the car\"" +
    		"         }" + "," + 
    		"     \"perdayrent\" : {" + 
    		"        \"Price\" : 290" + "," +
    		"         \"Discount\" : 25" +
    		"         }" + "," + 
    		"     \"metrics\" : {" + 
    		"         \"yoymaintenancecost\" : 2990.76" + "," +
    		"         \"depreciation\": 2656.43" + "," +
    		"         \"rentalcount\" : {" + 
    		"             \"lastweek\" : 6" + "," +
    		"             \"yeartodate\" : 211" + 
    		"             }" + 
    		"         }" + 
    		"    }" + 
    		"				" + 
    		"				}," + 
    		"				" + 
    		"				{" + 
    		"				\"Car\" : {" + 
    		"     \"make\": \"Tesla\"" + "," +
    		"	  \"model\": \"A2\"" + "," +
    		"     \"vin\": \"09AGHY64352JITEG52K\"" + "," +
    		"     \"metadata\" : {" + 
    		"         \"Color\" : \"Blue\"" + "," +
    		"         \"Notes\" : \"Scratches on the back side of the car\"" + 
    		"         }" + "," + 
    		"     \"perdayrent\" : {" + 
    		"        \"Price\" : 110" + "," +
    		"         \"Discount\" : 12" + 
    		"         }" + "," + 
    		"     \"metrics\" : {" + 
    		"         \"yoymaintenancecost\" : 2191.76" + "," +
    		"         \"depreciation\": 2146.43" + "," +
    		"         \"rentalcount\" : {" + 
    		"             \"lastweek\" : 3" + "," +
    		"             \"yeartodate\" : 201" + 
    		"             }" + 
    		"         }" + 
    		"    }" + 
    		"				" + 
    		"				}" + 
    		"  " + 
    		"  ]" + 
    		"" + 
    		"" + 
    		"}";
    
    public static void main(String[] args) throws JsonProcessingException, IOException {
    	
    	String tempJson = "{\"cars\" : [ {\"Car\" : {\"make\":\"toyota\"}}, {\"Car\" : {\"make\":\"tesla\"}} ]}";
    	//String temp1Json = "{\"cars\" : [ {\"make\":\"toyota\"}, {\"make\":\"tesla\"} ]}";

    	ObjectMapper objectMapper = new ObjectMapper();
    	JsonNode carsNode = objectMapper.readTree(CarResponse);
    	ArrayNode carArrayNode = (ArrayNode) carsNode.get("cars");
    	
    	Iterator<JsonNode> carIterator = carArrayNode.elements();
    	while (carIterator.hasNext()) {
    	    JsonNode carNode = carIterator.next();
    	    JsonNode carText = carNode.get("Car");
    	    String carData = objectMapper.writeValueAsString(carText);
    	    //System.out.println(carData);
    	    Car car = objectMapper.readValue(carData, Car.class);
    	    System.out.println(car.getMake());
    	    System.out.println(car.getPerdayrent().getPrice());


//    	    System.out.println(carNode.get("make"));
//    	    System.out.println(carNode.get("model"));
//    	    System.out.println(carNode.get("price"));
    	}
    }
}
