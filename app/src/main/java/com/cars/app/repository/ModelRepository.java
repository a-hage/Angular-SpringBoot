package com.cars.app.repository;

import com.cars.app.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model,Long> {
    void deleteModelById(Long id);
    Optional<Model> findModelById(Long id);
    Optional<Model> findModelByName(String name);
}
