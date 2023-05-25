package com.cars.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cars.app.model.Hersteller;

import java.util.Optional;

public interface HerstellerRepository extends JpaRepository<Hersteller,Long> {
    void deleteHerstellerById(Long id);
    Optional<Hersteller> findHerstellerById(Long id);
    Optional<Hersteller> findHerstellerByName(String name);
}