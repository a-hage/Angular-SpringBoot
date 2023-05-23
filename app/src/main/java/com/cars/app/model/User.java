package com.cars.app.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;
    private String firstname;
    private String lastname;

    private String username;
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String pwconfirmation;
    private Date registred;
    private Boolean enabled;

    @OneToOne(cascade =  CascadeType.ALL, mappedBy = "user")
    private UserProfile userProfile;

    public User(){}

    public User(String firstname, String lastname, String username, String email, String password, String pwconfirmation, Date registred, Boolean enabled) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.pwconfirmation = pwconfirmation;
        this.registred = registred;
        this.enabled = enabled;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPwconfirmation() {
        return pwconfirmation;
    }

    public void setPwconfirmation(String pwconfirmation) {
        this.pwconfirmation = pwconfirmation;
    }

    public Date getRegistred() {
        return registred;
    }

    public void setRegistred(Date registred) {
        this.registred = registred;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }



    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", pwconfirmation='" + pwconfirmation + '\'' +
            ", registred='" + registred + '\'' +
            ", enabled=" + enabled +
            '}';
    }
}