package org.acme.resource.dto;

import org.acme.domain.License;

public class LicenseDTO {

    private int id;
    private int expireYear;

    public LicenseDTO(License license) {
        this.expireYear = license.getExpireYear();
        this.id = license.getId();
    }

    public int getId() {
        return id;
    }

    public int getExpireYear() {
        return expireYear;
    }
}
