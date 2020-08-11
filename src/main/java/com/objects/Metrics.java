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
"yoymaintenancecost",
"depreciation",
"rentalcount"
})
public class Metrics {

@JsonProperty("yoymaintenancecost")
private Double yoymaintenancecost;
@JsonProperty("depreciation")
private Double depreciation;
@JsonProperty("rentalcount")
private Rentalcount rentalcount;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("yoymaintenancecost")
public Double getYoymaintenancecost() {
return yoymaintenancecost;
}

@JsonProperty("yoymaintenancecost")
public void setYoymaintenancecost(Double yoymaintenancecost) {
this.yoymaintenancecost = yoymaintenancecost;
}

@JsonProperty("depreciation")
public Double getDepreciation() {
return depreciation;
}

@JsonProperty("depreciation")
public void setDepreciation(Double depreciation) {
this.depreciation = depreciation;
}

@JsonProperty("rentalcount")
public Rentalcount getRentalcount() {
return rentalcount;
}

@JsonProperty("rentalcount")
public void setRentalcount(Rentalcount rentalcount) {
this.rentalcount = rentalcount;
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
