package com.objects;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Price",
"Discount"
})
public class Perdayrent {

@JsonProperty("Price")
private Double price;
@JsonProperty("Discount")
private Double discount;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("Price")
public Double getPrice() {
return price;
}

@JsonProperty("Price")
public void setPrice(Double price) {
this.price = price;
}

@JsonProperty("Discount")
public Double getDiscount() {
return discount;
}

@JsonProperty("Discount")
public void setDiscount(Double discount) {
this.discount = discount;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}