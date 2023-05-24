package com.cars.app.controller;

import com.cars.app.model.Stadt;
import com.cars.app.service.StadtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stadt")
public class StadtController {

    @Autowired
    private final StadtService stadtService;
    public StadtController(StadtService stadtService){
        this.stadtService = stadtService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Stadt>> getAllStaedte(){
        List<Stadt> stadt = stadtService.fetchAllStaedte();
        return new ResponseEntity<>(stadt, HttpStatus.OK);
    }

}
