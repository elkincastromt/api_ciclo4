package com.usa.ciclo4.app.repositories;

import com.usa.ciclo4.app.model.Clone;
import com.usa.ciclo4.app.repositories.crud.CloneCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CloneRepository {

    @Autowired
    private CloneCrudRepository cloneCrudRepository;

    public List<Clone> getAll(){
        return (List<Clone>) cloneCrudRepository.findAll();
    }

    public Clone save(Clone c){
        return cloneCrudRepository.save(c);
    }

    public Optional<Clone> getCloneById(Integer id){
        return cloneCrudRepository.findById(id);
    }

    public void deleteById (Integer id){
        cloneCrudRepository.deleteById(id);
    }

}
