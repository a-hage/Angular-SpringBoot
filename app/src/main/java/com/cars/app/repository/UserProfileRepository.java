package com.cars.app.repository;

import com.cars.app.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {
    void deleteUserProfileById(Long id);
    Optional<UserProfile> findUserProfileById(Long id);
    Optional <UserProfile> findUserProfileByUserId(Long id);
}
