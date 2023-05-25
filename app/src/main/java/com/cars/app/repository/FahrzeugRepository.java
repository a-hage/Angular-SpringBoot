package com.cars.app.repository;

import com.cars.app.model.Fahrzeug;
import com.cars.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface FahrzeugRepository extends JpaRepository<Fahrzeug,Long> {
    void deleteById(Long id);
    Optional<Fahrzeug> findById(Long id);
    Optional<Fahrzeug> findByName(String name);
    List <Fahrzeug> findAllByUserId(User user);
}
