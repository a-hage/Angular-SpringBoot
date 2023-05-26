package com.cars.app.controller;

import com.cars.app.model.UserProfile;
import com.cars.app.service.StadtService;
import com.cars.app.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/userprofile")
public class UserProfileController {

    @Autowired
    private final UserProfileService userProfileService;
    private final StadtService stadtService;

    public UserProfileController(UserProfileService userProfileService, StadtService stadtService){
        this.userProfileService = userProfileService;
        this.stadtService = stadtService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserProfile>> getAllUserProfiles(){
        List<UserProfile> userProfile = userProfileService.fetchAllUserProfiles();
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }
    @GetMapping("/find/{user_id}")
    public ResponseEntity<UserProfile> getUserProfilesByUserId(@PathVariable Long user_id){
        UserProfile userProfile = userProfileService.fetchUserProfileByUserId(user_id);
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }
    @PostMapping("/new")
    public ResponseEntity<UserProfile> addUserProfile(@RequestBody UserProfile userProfile){
        UserProfile userPNew = null;
        if(userProfile != null){
            userPNew = userProfileService.newUserProfile(userProfile);
        }
        return new ResponseEntity<>(userPNew,HttpStatus.CREATED);
    }

}

