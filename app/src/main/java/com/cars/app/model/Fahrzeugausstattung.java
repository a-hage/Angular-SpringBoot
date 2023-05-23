package com.cars.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="fahrzeugausstattung")
public class Fahrzeugausstattung implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fahrzeug_id",nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Fahrzeug fahrzeug;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ausstattung_id",nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Ausstattung ausstattung;

    public Fahrzeugausstattung(){}

    public Fahrzeugausstattung(Fahrzeug fahrzeug, Ausstattung ausstattung) {
        this.fahrzeug = fahrzeug;
        this.ausstattung = ausstattung;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

    public Ausstattung getAusstattung() {
        return ausstattung;
    }

    public void setAusstattung(Ausstattung ausstattung) {
        this.ausstattung = ausstattung;
    }

    @Override
    public String toString() {
        return "Fahrzeugaustattung{" +
                "id=" + id +
                ", fahrzeug=" + fahrzeug +
                ", ausstattung=" + ausstattung +
                '}';
    }
}