package com.cars.app.service;

import com.cars.app.exception.ModelNotFoundException;
import com.cars.app.model.Model;
import com.cars.app.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {
    private final ModelRepository modelRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository){
        this.modelRepository=modelRepository;
    }

    public Model addModel(Model model){
        return modelRepository.save(model);
    }

    public Model updateModel(Model model){
        return modelRepository.save(model);
    }

    public List<Model> findAllModels(){
        return modelRepository.findAll();
    }

    public Model findModelById(Long id){
        return modelRepository.findModelById(id)
                .orElseThrow(()-> new ModelNotFoundException("Model by id " + id + " was not found") );
    }
    public Model findModelByName(String name){
        return modelRepository.findModelByName(name)
                .orElseThrow(()-> new ModelNotFoundException("Model by name " + name + " was not found") );
    }
    public void  deleteModel(Long id){
        modelRepository.deleteModelById(id);
    }

}