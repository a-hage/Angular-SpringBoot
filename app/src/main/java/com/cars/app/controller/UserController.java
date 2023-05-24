package com.cars.app.controller;
import com.cars.app.model.User;
import com.cars.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> user = userService.fetchAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    /*
    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.fetchUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    */
    @PostMapping("/new")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User userNew = null;
        if (user != null) {
            userNew = userService.newUser(user);
        }
        return new ResponseEntity<>(userNew, HttpStatus.CREATED);
    }

     @GetMapping("/find/{username}")
     public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
         User user = userService.fetchUserByUsername(username);
         return new ResponseEntity<>(user, HttpStatus.OK);
     }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        User loginUser = null;
        if (email != null && password != null) {
            loginUser = userService.fetchUserByEmailAndPassword(email, password);
        }
        return new ResponseEntity<>(loginUser, HttpStatus.OK);
    }

}

