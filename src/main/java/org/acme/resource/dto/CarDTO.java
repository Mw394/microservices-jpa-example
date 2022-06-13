package org.acme.resource.dto;

import org.acme.domain.Car;

public class CarDTO {

    private String make;
    private String model;
    private int id;
    private OwnerDTO ownerDTO;

    public CarDTO(Car car) {
        this.make = car.getMake();
        this.model = car.getModel();
        this.id = car.getId();
        this.ownerDTO = new OwnerDTO(car.getOwner());
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getId() {
        return id;
    }

    public OwnerDTO getOwnerDTO() {
        return ownerDTO;
    }
}

