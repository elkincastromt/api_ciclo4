package com.usa.ciclo4.app.controllers;

import com.usa.ciclo4.app.model.Clone;
import com.usa.ciclo4.app.services.CloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clone")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CloneController {

    @Autowired
    private CloneService CloneService;

    @GetMapping("/all")
    public List<Clone> getClones(){
        return CloneService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Clone> getClone(@PathVariable("id") int id){
        return CloneService.getClone(id);
    }

    @GetMapping("/description/{description}")
    public List<Clone> getProductsByDescription(@PathVariable("description") String description){
        return CloneService.getProductsByDescription(description);
    }

    @GetMapping("/price/{price}")
    public List<Clone> getProductsByPrice(@PathVariable("price") Double price){
        return CloneService.getProductsByPrice(price);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone u){
        return CloneService.save(u);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone update(@RequestBody Clone u){
        return CloneService.update(u);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return CloneService.deleteById(id);
    }

}
