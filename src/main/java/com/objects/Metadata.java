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
"Color",
"Notes"
})
public class Metadata {

@JsonProperty("Color")
private String color;
@JsonProperty("Notes")
private String notes;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("Color")
public String getColor() {
return color;
}

@JsonProperty("Color")
public void setColor(String color) {
this.color = color;
}

@JsonProperty("Notes")
public String getNotes() {
return notes;
}

@JsonProperty("Notes")
public void setNotes(String notes) {
this.notes = notes;
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