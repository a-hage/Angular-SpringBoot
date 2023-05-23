package com.cars.app.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="fahrzeug")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Fahrzeug implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false,updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="model_id",nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Model model;

    private String name;
    private String description;
    private String kmstand;
    private float preis;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leistung_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Leistung leistung;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="verkaeufer_id",nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;
    private String zustand;
    private String kraftstoff;
    private String getriebe;
    private String klima;
    private String aussenfarbe;
    private String polstermaterial;
    private String polsterfarbe;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
   @JoinTable(name="fahrzeugausstattung", joinColumns = @JoinColumn(name="fahrzeug_id"), inverseJoinColumns =  @JoinColumn(name="ausstattung_id"))
    private Set<Ausstattung> ausstattungs = new HashSet<>();

    @OneToMany(mappedBy = "fahrzeug", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Images> images;

    public Fahrzeug(){}

    public Fahrzeug(Model model, User user, String name, String description, String kmstand, float preis, Leistung leistung, String zustand,
                    String kraftstoff, String getriebe, String klima, String aussenfarbe,
                    String polstermaterial, String polsterfarbe, List<Images> images) {
        this.model = model;
        this.user = user;
        this.name = name;
        this.description = description;
        this.kmstand = kmstand;
        this.preis = preis;
        this.leistung = leistung;
        this.zustand = zustand;
        this.kraftstoff = kraftstoff;
        this.getriebe = getriebe;
        this.klima = klima;
        this.aussenfarbe = aussenfarbe;
        this.polstermaterial = polstermaterial;
        this.polsterfarbe = polsterfarbe;
        this.images = images;

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getKmstand() {
        return kmstand;
    }
    public void setKmstand(String kmstand) {
        this.kmstand = kmstand;
    }

    public float getPreis() { return preis; }
    public void setPreis(float preis) {
        this.preis = preis;
    }

    public String getZustand() {
        return zustand;
    }
    public void setZustand(String zustand) {
        this.zustand = zustand;
    }

    public String getKraftstoff() {
        return kraftstoff;
    }
    public void setKraftstoff(String kraftstoff) {
        this.kraftstoff = kraftstoff;
    }

    public String getGetriebe() {
        return getriebe;
    }
    public void setGetriebe(String getriebe) {
        this.getriebe = getriebe;
    }

    public String getKlima() {
        return klima;
    }
    public void setKlima(String klima) {
        this.klima = klima;
    }

    public String getAussenfarbe() {
        return aussenfarbe;
    }
    public void setAussenfarbe(String aussenfarbe) {
        this.aussenfarbe = aussenfarbe;
    }

    public String getPolstermaterial() {
        return polstermaterial;
    }
    public void setPolstermaterial(String polstermaterial) {
        this.polstermaterial = polstermaterial;
    }

    public String getPolsterfarbe() {
        return polsterfarbe;
    }
    public void setPolsterfarbe(String polsterfarbe) {
        this.polsterfarbe = polsterfarbe;
    }

    public Leistung getLeistung() {
        return leistung;
    }
    public void setLeistung(Leistung leistung) {
        this.leistung = leistung;
    }

    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public List<Images> getImages() { return images; }
    public void setImages(List<Images> images) { this.images = images; }
    // getters and setters
    public void addAusstattung(Ausstattung ausstattung) {
        this.ausstattungs.add(ausstattung);
        ausstattung.getFahrzeugs().add(this);
    }

    public void removeAusstattung(long tagId) {
        Ausstattung ausstattung = this.ausstattungs.stream().filter(t -> t.getId() == tagId).findFirst().orElse(null);
        if (ausstattung != null) {
            this.ausstattungs.remove(ausstattung);
            ausstattung.getFahrzeugs().remove(this);
        }
    }
    @Override
    public String toString() {
        return "Fahrzeug{" +
                "id=" + id +
                ", model=" + model +'\'' +
                ", user=" + user +'\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", kmstand='" + kmstand + '\'' +
                ", preis='" + preis + '\'' +
                ", leistung=" + leistung +
                ", zustand='" + zustand + '\'' +
                ", kraftstoff='" + kraftstoff + '\'' +
                ", getriebe='" + getriebe + '\'' +
                ", klima='" + klima + '\'' +
                ", aussenfarbe='" + aussenfarbe + '\'' +
                ", polstermaterial='" + polstermaterial + '\'' +
                ", polsterfarbe='" + polsterfarbe + '\'' +
                ", images=" + images  +
                '}';
    }
}