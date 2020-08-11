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
"lastweek",
"yeartodate"
})
public class Rentalcount {

@JsonProperty("lastweek")
private Integer lastweek;
@JsonProperty("yeartodate")
private Integer yeartodate;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("lastweek")
public Integer getLastweek() {
return lastweek;
}

@JsonProperty("lastweek")
public void setLastweek(Integer lastweek) {
this.lastweek = lastweek;
}

@JsonProperty("yeartodate")
public Integer getYeartodate() {
return yeartodate;
}

@JsonProperty("yeartodate")
public void setYeartodate(Integer yeartodate) {
this.yeartodate = yeartodate;
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