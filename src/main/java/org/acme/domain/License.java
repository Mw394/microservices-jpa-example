package org.acme.domain;

public class License {

    private int expireYear;
    private int id;

    public License(int expireYear, int id) {
        this.expireYear = expireYear;
        this.id = id;
    }

    public int getExpireYear() {
        return expireYear;
    }

    public int getId() {
        return id;
    }
}
