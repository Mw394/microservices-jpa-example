package org.acme.resource.dto;

import org.acme.domain.Car;

public class CarDTO {

    private String make;
    private String model;
    private int id;
    private String ownerName;
    private int ownerAge;

    public CarDTO(Car car) {
        this.make = car.getMake();
        this.model = car.getModel();
        this.id = car.getId();
        this.ownerName = car.getOwner().getName();
        this.ownerAge = car.getOwner().getAge();
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

    public String getOwnerName() {
        return ownerName;
    }
    public int getOwnerAge() {
        return ownerAge;
    }
}

