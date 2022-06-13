package org.acme.resource;

import org.acme.resource.dto.*;
import org.acme.service.OwnerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/owners")
public class OwnerResource {

    private OwnerService ownerService;

    @Inject
    public OwnerResource(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @POST
    @Path("/createOwner")
    public OwnerDTO createOwner(CreateOwnerDTO createOwnerDTO) {
        return new OwnerDTO(ownerService.createOwner(createOwnerDTO));
    }

    @POST
    @Path("/createLicense")
    public LicenseDTO createLicense(CreateLicenseDTO createLicenseDTO) {
        return new LicenseDTO(ownerService.createLicense(createLicenseDTO));
    }

    @GET
    @Path("/getOwner/{id}")
    public OwnerDTO getOwner(@PathParam("id") int id) {
        return new OwnerDTO(ownerService.getOwner(id));
    }

    @POST
    @Path("/createCar/{ownerID}")
    public void createCar(@PathParam("ownerID") int id, CreateCarDTO createCarDTO) {
        ownerService.createCar(id, createCarDTO);
    }

}
