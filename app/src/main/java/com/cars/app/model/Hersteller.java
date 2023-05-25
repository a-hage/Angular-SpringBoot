package com.cars.app.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="hersteller")
public class Hersteller implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;
    private String name;

    public Hersteller(){}

    public Hersteller(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Hersteller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}