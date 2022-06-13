package org.acme.repo.entity;

import org.acme.domain.Car;
import org.acme.domain.Owner;

import javax.inject.Named;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "OWNER")
@NamedQueries({
        @NamedQuery(name = "OwnerPO.FindByName", query = "Select o from OwnerPO o where o.name=:name"),

})
public class OwnerPO {

    public static final String FIND_BY_NAME = "OwnerPO.FindByName";
    public static final String FIND_BY_NAME_PARAMETER = "name";

    @Id
    @GeneratedValue
    @Column(name = "ID", columnDefinition = "int")
    private int id;

    @Column(name = "NAME", columnDefinition = "varchar(20)", nullable = false)
    private String name;

    @Column(name = "AGE", columnDefinition = "int", nullable = false)
    private int age;

    /*
    1-1 Association with liciensePO.
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "liciense_fk", referencedColumnName = "id" )
    private LicensePO license;

    /*
    1-Many one way directional association with OwnerPO as owner.
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_fk", referencedColumnName = "id", nullable = false)
    private List<CarPO> cars;


    public OwnerPO(String name, int age, LicensePO license) {
        this.name = name;
        this.age = age;
        this.license = license;
    }

    public OwnerPO() {
    }

    public LicensePO getLicense() {
        return license;
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

    public List<CarPO> getCars() {
        return cars;
    }

    public Owner toOwner() {
        try {
                if (getCars() != null) {
                    System.out.println("Works");
                    ArrayList<Car> cars = (ArrayList<Car>) getCars().stream().map(CarPO::toCar).collect(Collectors.toList());
                    return new Owner(getName(), getAge(), getId(), getLicense().toLicense(), cars);
                } else {
                    return new Owner(getName(), getAge(), getId(), getLicense().toLicense(), null);
                }

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public Owner testToOwner() {
        try {
            return new Owner(getName(), getAge(), getId(), getLicense().toLicense());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
