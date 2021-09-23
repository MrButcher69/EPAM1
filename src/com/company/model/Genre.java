package com.company.model;

import java.util.List;

public class Genre {
    private List<Science> science;
    private List<Art> art;
    private List<Fiction> fiction;

    public void setScience(List<Science> science) {
        this.science = science;
    }

    public void setArt(List<Art> art) {
        this.art = art;
    }

    public void setFiction(List<Fiction> fiction) {
        this.fiction = fiction;
    }

    public List<Science> getScience() {
        return science;
    }

    public List<Art> getArt() {
        return art;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "science=" + science +
                ", art=" + art +
                ", fiction=" + fiction +
                '}';
    }

    public List<Fiction> getFiction() {
        return fiction;
    }
}
