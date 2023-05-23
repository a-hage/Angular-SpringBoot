package com.cars.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="model")
public class Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hersteller_id",nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Hersteller hersteller;

    private String name;
    private String type;

    public Model(){}

    public Model(Hersteller hersteller, String name, String type) {
        this.hersteller = hersteller;
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hersteller getHersteller() {
        return hersteller;
    }
    public void setHersteller(Hersteller hersteller) {
        this.hersteller = hersteller;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", hersteller=" + hersteller +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}