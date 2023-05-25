package com.cars.app.service;

import com.cars.app.exception.StadtNotFoundException;
import com.cars.app.model.Stadt;
import com.cars.app.repository.StadtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadtService {
    @Autowired
    private final StadtRepository stadtRepository;

    public StadtService(StadtRepository stadtRepository){
        this.stadtRepository = stadtRepository;
    }

    public List<Stadt> fetchAllStaedte(){
        return stadtRepository.findAll();
    }

    public Stadt fetchStadtById(Long id){
        return stadtRepository.findById(id)
                .orElseThrow(()-> new StadtNotFoundException("Stadt by id " + id + " was not found") );
    }
    public Stadt fetchStadtByName(String name){
        return stadtRepository.findStadtByName(name)
                .orElseThrow(()-> new StadtNotFoundException("Stadt by name " + name + " was not found") );
    }

}
