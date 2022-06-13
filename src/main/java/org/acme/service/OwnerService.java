package org.acme.service;

import org.acme.domain.Car;
import org.acme.domain.License;
import org.acme.domain.Owner;
import org.acme.repo.Repo;
import org.acme.resource.dto.CreateCarDTO;
import org.acme.resource.dto.CreateLicenseDTO;
import org.acme.resource.dto.CreateOwnerDTO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class OwnerService {

    private Repo repo;

    @Inject
    public OwnerService(Repo repo) {
        this.repo = repo;
    }

    public Owner createOwner(CreateOwnerDTO createOwnerDTO) {
        return repo.createOwner(createOwnerDTO);
    }

    public License createLicense(CreateLicenseDTO createLicenseDTO) {
        return repo.createLicense(createLicenseDTO);
    }

    public Owner getOwner(int id) {
        return repo.getOwner(id);
    }

    public void createCar(int id, CreateCarDTO createCarDTO) {
        repo.createCar(id, createCarDTO);
    }

    public List<Owner> getByName(String name) {
        return repo.getByName(name);
    }
}
