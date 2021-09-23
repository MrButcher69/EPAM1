package com.company.model;

public class Fiction {
    private  String name;
    private int pqty;
    private int bqty;

    public Fiction(String name, int pqty, int bqty) {
        this.name = name;
        this.pqty = pqty;
        this.bqty = bqty;
    }

    public String getName() {
        return name;
    }

    public int getPqty() {
        return pqty;
    }

    public int getBqty() {
        return bqty;
    }

    @Override
    public String toString() {
        return "Fiction{" +
                "name='" + name + '\'' +
                ", pqty=" + pqty +
                ", bqty=" + bqty +
                '}';
    }
}
