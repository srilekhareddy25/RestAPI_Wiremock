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
@JsonPropertyOrder({"make","model","vin","metadata","perdayrent","metrics"})
public class Car {

@JsonProperty("make")
private String make;
@JsonProperty("model")
private String model;
@JsonProperty("vin")
private String vin;
@JsonProperty("metadata")
private Metadata metadata;
@JsonProperty("perdayrent")
private Perdayrent perdayrent;
@JsonProperty("metrics")
private Metrics metrics;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("make")
public String getMake() {
return make;
}

@JsonProperty("make")
public void setMake(String make) {
this.make = make;
}

@JsonProperty("model")
public String getModel() {
return model;
}

@JsonProperty("model")
public void setModel(String model) {
this.model = model;
}

@JsonProperty("vin")
public String getVin() {
return vin;
}

@JsonProperty("vin")
public void setVin(String vin) {
this.vin = vin;
}

@JsonProperty("metadata")
public Metadata getMetadata() {
return metadata;
}

@JsonProperty("metadata")
public void setMetadata(Metadata metadata) {
this.metadata = metadata;
}

@JsonProperty("perdayrent")
public Perdayrent getPerdayrent() {
return perdayrent;
}

@JsonProperty("perdayrent")
public void setPerdayrent(Perdayrent perdayrent) {
this.perdayrent = perdayrent;
}

@JsonProperty("metrics")
public Metrics getMetrics() {
return metrics;
}

@JsonProperty("metrics")
public void setMetrics(Metrics metrics) {
this.metrics = metrics;
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

