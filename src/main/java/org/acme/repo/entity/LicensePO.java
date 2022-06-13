package org.acme.repo.entity;

import org.acme.domain.License;

import javax.persistence.*;

@Entity
@Table(name = "LICIENSE")
public class LicensePO {

    @Id
    @GeneratedValue
    @Column(name = "ID", columnDefinition = "int")
    private int id;

    @Column(name = "EXPIRESYEAR", columnDefinition = "int", nullable = false)
    private int expireYear;


    public LicensePO(int expireYear) {
        this.expireYear = expireYear;
    }

    public LicensePO() {
    }

    public int getId() {
        return id;
    }

    public int getExpireYear() {
        return expireYear;
    }

    public License toLicense() {
        try {
            return new License(getExpireYear(), getId());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
