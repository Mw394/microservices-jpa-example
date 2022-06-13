package org.acme.domain;

import java.util.ArrayList;
import java.util.List;

public class Owner {

    private String name;
    private int age;
    private int id;
    private ArrayList<Car> cars;

    private License license;

    public Owner(String name, int age, int id, License license, ArrayList<Car> cars) {
        this.age = age;
        this.name = name;
        this.id = id;
        this.license = license;
        this.cars = cars;
    }

    public Owner(String name, int age, int id, License license) {
        this.age = age;
        this.name = name;
        this.id = id;
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public License getLicense() {
        return license;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
