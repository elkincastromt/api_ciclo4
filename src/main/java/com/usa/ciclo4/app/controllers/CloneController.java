package com.usa.ciclo4.app.controllers;

import com.usa.ciclo4.app.model.Clone;
import com.usa.ciclo4.app.services.CloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

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
