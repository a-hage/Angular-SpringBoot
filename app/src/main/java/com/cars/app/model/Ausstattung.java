package com.cars.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="ausstattung")
public class Ausstattung implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;
    private String name;

    @ManyToMany(mappedBy="ausstattungs", fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JsonIgnore
    private Set<Fahrzeug> fahrzeugs = new HashSet<>();

    public Ausstattung() {}

    public Ausstattung(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Set<Fahrzeug> getFahrzeugs() {
        return fahrzeugs;
    }
    public void setFahrzeugs(Set<Fahrzeug> fahrzeugs) {
        this.fahrzeugs = fahrzeugs;
    }

    @Override
    public String toString() {
        return "Ausstattung{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
