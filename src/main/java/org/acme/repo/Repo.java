package org.acme.repo;

import org.acme.domain.Car;
import org.acme.domain.License;
import org.acme.domain.Owner;
import org.acme.repo.entity.CarPO;
import org.acme.repo.entity.LicensePO;
import org.acme.repo.entity.OwnerPO;
import org.acme.resource.dto.CreateCarDTO;
import org.acme.resource.dto.CreateLicenseDTO;
import org.acme.resource.dto.CreateOwnerDTO;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
@Transactional
public class Repo {


    private final EntityManager entityManager;

    public Repo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Owner createOwner(CreateOwnerDTO createOwnerDTO) {
        OwnerPO ownerPO = new OwnerPO(createOwnerDTO.getName(), createOwnerDTO.getAge(), new LicensePO(createOwnerDTO.getCreateLicenseDTO().getExpireYear()));
        entityManager.persist(ownerPO);
        return ownerPO.toOwner();
    }

    public Owner getOwner(int id) {
        return entityManager.find(OwnerPO.class, id).toOwner();
    }


    public License createLicense(CreateLicenseDTO createLicenseDTO) {
        LicensePO licensePO = new LicensePO(createLicenseDTO.getExpireYear());
        entityManager.persist(licensePO);
        return licensePO.toLicense();
    }

    public void createCar(int id, CreateCarDTO createCarDTO) {
        OwnerPO ownerPO = entityManager.find(OwnerPO.class, id);
        CarPO carPO = new CarPO(createCarDTO.getMake(), createCarDTO.getModel(), ownerPO);
        entityManager.persist(carPO); // bruges hvis det er bi-directional
        //ownerPO.getCars().add(carPO); Bruges hvis det er one-directional
    }

    public List<Owner> getByName(String name) {
        try {
            return entityManager.createNamedQuery(OwnerPO.FIND_BY_NAME, OwnerPO.class).setParameter(OwnerPO.FIND_BY_NAME_PARAMETER, name).getResultList().stream().map(OwnerPO::toOwner).collect(Collectors.toList());
        } catch (NoResultException e) {
            return null;
        }
    }

}
