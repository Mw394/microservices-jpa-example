package org.acme.repo.entity;

import org.acme.domain.Car;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "CAR")
public class CarPO {

    @Id
    @GeneratedValue
    @Column(name = "ID", columnDefinition = "int")
    private int id;

    @Column(name = "MAKE", columnDefinition = "varchar(15)", nullable = false)
    private String make;

    @Column(name = "MODEL", columnDefinition = "varchar(15)", nullable = false)
    private String model;

    @ManyToOne()
    @JoinColumn(name = "owner_fk", referencedColumnName = "id")
    private OwnerPO owner;


    public CarPO(String make, String model, OwnerPO ownerPO) {
        this.make = make;
        this.model = model;
        this.owner = ownerPO;
    }

    public CarPO() {
    }

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public OwnerPO getOwner() {
        return owner;
    }

    public Car toCar() {
        try {
            return new Car(getMake(), getModel(), getId(), getOwner().testToOwner());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
