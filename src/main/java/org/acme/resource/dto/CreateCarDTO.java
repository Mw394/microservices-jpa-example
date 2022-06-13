package org.acme.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateCarDTO {

    private String make;
    private String model;

    public CreateCarDTO(@JsonProperty("make") String make, @JsonProperty("model") String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}
