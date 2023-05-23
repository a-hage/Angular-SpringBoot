package com.cars.app.repository;

import com.cars.app.model.Ausstattung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AusstattungRepository extends JpaRepository<Ausstattung,Long>{
    void deleteById(Long id);
    Optional<Ausstattung> findById(Long id);
    Optional<Ausstattung> findByName(String name);

}

