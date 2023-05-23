package com.cars.app.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="leistung")
public class Leistung implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;
    private String kw;
    private String ps;

    public Leistung(){}

    public Leistung(String kw, String ps) {
        this.kw = kw;
        this.ps = ps;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKw() {
        return kw;
    }

    public void setKw(String kw) {
        this.kw = kw;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    @Override
    public String toString() {
        return "Leistung{" +
                "id=" + id +
                ", kw='" + kw + '\'' +
                ", ps='" + ps + '\'' +
                '}';
    }
}