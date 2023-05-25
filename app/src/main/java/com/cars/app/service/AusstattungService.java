package com.cars.app.service;

import com.cars.app.exception.AusstattungNotFoundException;
import com.cars.app.model.Ausstattung;
import com.cars.app.model.Fahrzeug;
import com.cars.app.repository.AusstattungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AusstattungService {
    @Autowired
    private final AusstattungRepository ausstattungRepository;

    public AusstattungService(AusstattungRepository ausstattungRepository){
        this.ausstattungRepository=ausstattungRepository;
    }

    public Ausstattung addAusstattung(Ausstattung ausstattung){

        return ausstattungRepository.save(ausstattung);
    }

    public Ausstattung updateAusstattung(Ausstattung ausstattung){

        return ausstattungRepository.save(ausstattung);
    }

    public List<Ausstattung> findAllAusstattungs(){
        List<Ausstattung> ausstattungs = new ArrayList<Ausstattung>();
        ausstattungRepository.findAll().forEach(ausstattungs::add);
        return ausstattungs;
    }

    public Ausstattung findAusstattungById(Long id){
        return ausstattungRepository.findById(id)
                .orElseThrow(()-> new AusstattungNotFoundException("Fahrzeug by id " + id + " was not found") );
    }
    public Ausstattung findAusstattungByName(String name){
        return ausstattungRepository.findByName(name)
                .orElseThrow(()-> new AusstattungNotFoundException("Fahrzeug by name " + name + " was not found") );
    }
    public void  deleteAusstattung(Long id){
        ausstattungRepository.deleteById(id);
    }

}
