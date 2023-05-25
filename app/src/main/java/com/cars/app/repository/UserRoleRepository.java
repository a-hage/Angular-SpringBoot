
package com.cars.app.repository;

import  com.cars.app.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    void deleteUserRoleById(Long id);
    Optional<UserRole> findUserRoleById(Long id);
    Optional<UserRole> findUserRoleByUserId(Long user_id);
    Optional <UserRole> findUserRoleByRole(String role);
}