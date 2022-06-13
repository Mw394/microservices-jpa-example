package org.acme.domain;

public class Car {

    private String make;
    private String model;
    private int id;
    private Owner owner;

    public Car(String make, String model, int id, Owner owner) {
        this.make = make;
        this.model = model;
        this.id = id;
        this.owner = owner;
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

    public Owner getOwner() {
        return owner;
    }
}
