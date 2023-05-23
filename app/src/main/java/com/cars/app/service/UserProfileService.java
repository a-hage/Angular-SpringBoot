package com.cars.app.service;


import com.cars.app.exception.UserProfileNotFoundException;
import com.cars.app.model.UserProfile;
import com.cars.app.repository.StadtRepository;
import com.cars.app.repository.UserProfileRepository;
import com.cars.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {
        @Autowired
        private final UserProfileRepository userProfileRepository;
        private final UserRepository userRepository;
        private final StadtRepository stadtRepository;

        public UserProfileService(UserProfileRepository userProfileRepository, UserRepository userRepository, StadtRepository stadtRepository){
            this.userProfileRepository = userProfileRepository;
            this.userRepository = userRepository;
            this.stadtRepository = stadtRepository;
        }
        public UserProfile newUserProfile(UserProfile userProfile){
            return userProfileRepository.save(userProfile);
        }

        public UserProfile updateUserProfile(UserProfile userProfile){
            return userProfileRepository.save(userProfile);
        }

        public List<UserProfile> fetchAllUserProfiles(){

            return userProfileRepository.findAll();
        }
    /*
        public UserProfile fetchUserProfileById(Long id){
            return userProfileRepository.findUserProfileById(id)
                    .orElseThrow(()-> new UserProfileNotFoundException("UserProfile by id " + id + " was not found") );
        }

     */
        public UserProfile fetchUserProfileByUserId(Long user_id){
            return userProfileRepository.findUserProfileByUserId(user_id)
                    .orElseThrow(()-> new UserProfileNotFoundException("User by id " + user_id + " was not found") );
        }
        public void  deleteUserProfile(Long id){
            userProfileRepository.deleteUserProfileById(id);
        }



}
