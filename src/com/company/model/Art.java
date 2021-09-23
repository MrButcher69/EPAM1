package com.company.model;

public class Art {
    private  String name;
    private  int pqty;
    private  int bqty;

    public Art(String name, int pqty, int bqty) {
        this.name = name;
        this.pqty = pqty;
        this.bqty = bqty;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Art{" +
                "name='" + name + '\'' +
                ", pqty=" + pqty +
                ", bqty=" + bqty +
                '}';
    }

    public int getPqty() {
        return pqty;
    }

    public int getBqty() {
        return bqty;
    }
}
