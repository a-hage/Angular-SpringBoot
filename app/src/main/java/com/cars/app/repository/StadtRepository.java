package com.cars.app.repository;

import com.cars.app.model.Stadt;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StadtRepository extends JpaRepository<Stadt,Long> {
    Optional<Stadt> findById(Long id);
    Optional <Stadt> findStadtByName(String name);
}
