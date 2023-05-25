package com.cars.app.controller;

import com.cars.app.model.Model;
import com.cars.app.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService){
        this.modelService = modelService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Model>> getAllModel(){
        List<Model> model = modelService.findAllModels();
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Model> getModelById(@PathVariable("id") Long id){
        Model model = modelService.findModelById(id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<Model> getModelByName(@PathVariable("name") String name){
        Model model = modelService.findModelByName(name);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Model> addModel(@RequestBody Model model){
        Model newModel=modelService.addModel(model);
        return new ResponseEntity<>(newModel,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Model> updateModel(@RequestBody Model model){
        Model updateModel = modelService.updateModel(model);
        return new ResponseEntity<>(updateModel,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteModel(@PathVariable("id") Long id){
        modelService.deleteModel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> baa8a8055c91ebe2f2569443472aae48f718333b
