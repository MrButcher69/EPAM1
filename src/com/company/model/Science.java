package com.company.model;

public class Science {
    private String name;
    private int pqty;
    private int bqty;

    public Science(String name, int pqty, int bqty) {
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
        return "Science{" +
                "name='" + name + '\'' +
                ", pqty=" + pqty +
                ", bqty=" + bqty +
                '}';
    }
}
