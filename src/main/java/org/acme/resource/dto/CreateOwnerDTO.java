package org.acme.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateOwnerDTO {

    private String name;
    private int age;
    private CreateLicenseDTO createLicenseDTO;

    public CreateOwnerDTO(@JsonProperty("name") String name, @JsonProperty("age") int age, @JsonProperty("license") CreateLicenseDTO createLicenseDTO) {
        this.age = age;
        this.name = name;
        this.createLicenseDTO = createLicenseDTO;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public CreateLicenseDTO getCreateLicenseDTO() {
        return createLicenseDTO;
    }


}
