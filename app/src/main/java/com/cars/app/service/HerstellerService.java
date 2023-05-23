package com.cars.app.service;

import com.cars.app.exception.HerstellerNotFoundException;
import com.cars.app.model.Hersteller;
import com.cars.app.repository.HerstellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HerstellerService {
    private final HerstellerRepository herstellerRepository;

    @Autowired
    public HerstellerService(HerstellerRepository herstellerRepository){
        this.herstellerRepository=herstellerRepository;
    }

    public Hersteller addHersteller(Hersteller hersteller){
        return herstellerRepository.save(hersteller);
    }

    public Hersteller updateHersteller(Hersteller hersteller){
        return herstellerRepository.save(hersteller);
    }

    public List<Hersteller> findAllHerstellers(){
        return herstellerRepository.findAll();
    }

    public Hersteller findHerstellerById(Long id){
        return herstellerRepository.findHerstellerById(id)
                .orElseThrow(()-> new HerstellerNotFoundException("Hersteller by id " + id + " was not found") );
    }
    public Hersteller findHerstellerByName(String name){
        return herstellerRepository.findHerstellerByName(name)
                .orElseThrow(()-> new HerstellerNotFoundException("Hersteller by name " + name + " was not found") );
    }
    public void  deleteHersteller(Long id){
        herstellerRepository.deleteHerstellerById(id);
    }

}