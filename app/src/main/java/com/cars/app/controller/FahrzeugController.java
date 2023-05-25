package com.cars.app.controller;

import java.util.ArrayList;
import java.util.List;
import com.cars.app.model.Fahrzeug;
import org.springframework.beans.factory.annotation.Autowired;
import com.cars.app.service.FahrzeugService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/fahrzeug")
public class FahrzeugController {
    @Autowired
    private FahrzeugService fahrzeugService;

    public FahrzeugController(FahrzeugService fahrzeugService){
        this.fahrzeugService=fahrzeugService;
    }

    @GetMapping("/all")
    public ResponseEntity <List<Fahrzeug>> getAllFahrzeuge(){
        List<Fahrzeug> fahrzeuge = fahrzeugService.findAllFahrzeugs();
        return new ResponseEntity<>(fahrzeuge, HttpStatus.OK);
    }
    @GetMapping("/all/user/{user_id}")
    public ResponseEntity <List<Fahrzeug>> getAllByUserId(@PathVariable("user_id") Long user_id){
        List<Fahrzeug> fahrzeuge = fahrzeugService.findAllByUserId(user_id);
        return new ResponseEntity<>(fahrzeuge, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Fahrzeug> getFahrzeugById(@PathVariable("id") Long id){
        Fahrzeug fahrzeugData = fahrzeugService.findFahrzeugById(id);
        return new ResponseEntity<>(fahrzeugData, HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<Fahrzeug> getFahrzeugByName(@PathVariable("name") String name){
        Fahrzeug fahrzeugData = fahrzeugService.findFahrzeugByName(name);
        return new ResponseEntity<>(fahrzeugData, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Fahrzeug> addFahrzeug(@RequestBody Fahrzeug fahrzeug){
        Fahrzeug newFahrzeug=fahrzeugService.addFahrzeug(fahrzeug);
        return new ResponseEntity<>(newFahrzeug,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Fahrzeug> updateFahrzeug(@RequestBody Fahrzeug fahrzeug){
        Fahrzeug updateFahrzeug=fahrzeugService.updateFahrzeug(fahrzeug);
        return new ResponseEntity<>(updateFahrzeug,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFahrzeug(@PathVariable("id") Long id){
        fahrzeugService.deleteFahrzeug(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> baa8a8055c91ebe2f2569443472aae48f718333b
