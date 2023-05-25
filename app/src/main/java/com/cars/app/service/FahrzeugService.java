package com.cars.app.service;

import  com.cars.app.exception.FahrzeugNotFoundException;
import  com.cars.app.model.Fahrzeug;
import org.springframework.beans.factory.annotation.Autowired;
import  com.cars.app.repository.FahrzeugRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FahrzeugService {
    @Autowired
    private final FahrzeugRepository fahrzeugRepository;

    public FahrzeugService(FahrzeugRepository fahrzeugRepository){
        this.fahrzeugRepository=fahrzeugRepository;
    }

    public Fahrzeug addFahrzeug(Fahrzeug fahrzeug){

        return fahrzeugRepository.save(fahrzeug);
    }

    public Fahrzeug updateFahrzeug(Fahrzeug fahrzeug){

        return fahrzeugRepository.save(fahrzeug);
    }

    public List<Fahrzeug> findAllFahrzeugs(){
        List<Fahrzeug> fahrzeugs = new ArrayList<Fahrzeug>();
       fahrzeugRepository.findAll().forEach(fahrzeugs::add);
       return fahrzeugs;
    }
    public List<Fahrzeug> findAllByUserId(Long verkauefer_id){
        List <Fahrzeug> fahr  = this.findAllFahrzeugs();
        List<Fahrzeug> userFahrzeuge= new ArrayList<Fahrzeug>();
        if(fahr.size() !=0 ){
            for(int i=0;i< fahr.size();i++) {
                if (fahr.get(i).getUser().getId() == verkauefer_id) userFahrzeuge.add(fahr.get(i));
            }
        }
        return userFahrzeuge;
    }

    public Fahrzeug findFahrzeugById(Long id){
        return fahrzeugRepository.findById(id)
                .orElseThrow(()-> new FahrzeugNotFoundException("Fahrzeug by id " + id + " was not found") );
    }
    public Fahrzeug findFahrzeugByName(String name){
        return fahrzeugRepository.findByName(name)
                .orElseThrow(()-> new FahrzeugNotFoundException("Fahrzeug by name " + name + " was not found") );
    }
    public void  deleteFahrzeug(Long id){
        fahrzeugRepository.deleteById(id);
    }

}
