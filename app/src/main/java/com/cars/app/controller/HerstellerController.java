package com.cars.app.controller;

import java.util.List;
import com.cars.app.model.Hersteller;
import com.cars.app.service.HerstellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hersteller")
public class HerstellerController {
    @Autowired
    private final HerstellerService herstellerService;

    public HerstellerController(HerstellerService herstellerService){
        this.herstellerService=herstellerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hersteller>> getAllHersteller(){
        List<Hersteller> hersteller = herstellerService.findAllHerstellers();
        return new ResponseEntity<>(hersteller, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Hersteller> getHerstellerById(@PathVariable("id") Long id){
        Hersteller hersteller = herstellerService.findHerstellerById(id);
        return new ResponseEntity<>(hersteller, HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<Hersteller> getHerstellerByName(@PathVariable("name") String name){
        Hersteller hersteller = herstellerService.findHerstellerByName(name);
        return new ResponseEntity<>(hersteller, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Hersteller> addHersteller(@RequestBody Hersteller hersteller){
        Hersteller newHersteller=herstellerService.addHersteller(hersteller);
        return new ResponseEntity<>(newHersteller,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Hersteller> updateHersteller(@RequestBody Hersteller hersteller){
        Hersteller updateHersteller=herstellerService.updateHersteller(hersteller);
        return new ResponseEntity<>(updateHersteller,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHersteller(@PathVariable("id") Long id){
        herstellerService.deleteHersteller(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}