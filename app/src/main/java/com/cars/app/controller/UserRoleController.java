package com.cars.app.controller;

import com.cars.app.model.UserRole;
import com.cars.app.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/userrole")
public class UserRoleController {

    @Autowired
    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService){
        this.userRoleService = userRoleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserRole>> getAllUserRoles(){
        List<UserRole> userRole = userRoleService.fetchAllUserRoles();
        return new ResponseEntity<>(userRole, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<UserRole> getUserRoleById(@PathVariable Long id){
        UserRole userRole = userRoleService.fetchUserRoleById(id);
        return new ResponseEntity<>(userRole, HttpStatus.OK);
    }

    @GetMapping("/find/{user_id}")
    public ResponseEntity<UserRole> getUserRoleByUserId(@PathVariable Long user_id){
        UserRole userRole = userRoleService.fetchUserRoleByUserId(user_id);
        return new ResponseEntity<>(userRole, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<UserRole> addUserRole(@RequestBody UserRole userRole){
        UserRole userRoleNew = null;
        if(userRole != null){
            userRoleNew = userRoleService.newUserRole(userRole);
        }
        return new ResponseEntity<>(userRoleNew,HttpStatus.CREATED);
    }

}

