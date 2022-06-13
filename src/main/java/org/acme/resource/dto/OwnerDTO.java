package org.acme.resource.dto;

import org.acme.domain.Car;
import org.acme.domain.Owner;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OwnerDTO {

    private int id;
    private String name;
    private int age;
    private LicenseDTO licenseDTO;
    private ArrayList<CarDTO> cars;

    public OwnerDTO(Owner owner) {
        this.age = owner.getAge();
        this.name = owner.getName();
        this.id = owner.getId();
        this.licenseDTO = new LicenseDTO(owner.getLicense());
        if (owner.getCars() != null) {
            this.cars = (ArrayList<CarDTO>) owner.getCars().stream().map(CarDTO::new).collect(Collectors.toList());
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LicenseDTO getLicienseDTO() {
        return licenseDTO;
    }

    public ArrayList<CarDTO> getCars() {
        return cars;
    }
}
