package org.acme.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateLicenseDTO {

    private int expireYear;

    public CreateLicenseDTO(@JsonProperty("expireYear") int expireYear) {
        this.expireYear = expireYear;
    }

    public int getExpireYear() {
        return expireYear;
    }
}
