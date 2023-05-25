package com.cars.app.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="stadt")
public class Stadt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;
    @Column(name = "plz",nullable = false)
    private String plz;
    @Column(name = "name",nullable = false)
    private String name;
    private String bundesland;
    private String kreis;
    private Float latitude;
    private Float longitude;
    /*
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "stadt")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private UserProfile userProfile;
    */
    public Stadt() {
    }

    public Stadt(String plz, String name, String bundesland, String kreis, Float latitude, Float longitude) {
        this.plz = plz;
        this.name = name;
        this.bundesland = bundesland;
        this.kreis = kreis;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }

    public String getKreis() {
        return kreis;
    }

    public void setKreis(String kreis) {
        this.kreis = kreis;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Stadt{" +
                "id=" + id +
                ", plz='" + plz + '\'' +
                ", name='" + name + '\'' +
                ", bundesland='" + bundesland + '\'' +
                ", kreis='" + kreis + '\'' +
                ", latitude=" + latitude +'\'' +
                ", longitude=" + longitude +
                '}';
    }
}