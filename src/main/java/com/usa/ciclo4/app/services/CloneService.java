package com.usa.ciclo4.app.services;

import com.usa.ciclo4.app.model.Clone;
import com.usa.ciclo4.app.model.User;
import com.usa.ciclo4.app.repositories.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloneService {

    @Autowired
    private CloneRepository cloneRepository;

    public List<Clone> getAll() {
        return cloneRepository.getAll();
    }

    public Optional<Clone> getClone(int id){
        return cloneRepository.getCloneById(id);
    }

    public Clone save(Clone c){
        if(c.getId()==null){
            return cloneRepository.save(c);
        }else{
            Optional<Clone> paux=cloneRepository.getCloneById(c.getId());
            if(paux.isEmpty()){
                return cloneRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Clone update(Clone c) {
        if (c.getId() != null) {
            Optional<Clone> cloneExist = cloneRepository.getCloneById(c.getId());
            if (cloneExist.isPresent()) {
                if (c.getId() != null) {
                    cloneExist.get().setId(c.getId());
                }
                if (c.getBrand() != null) {
                    cloneExist.get().setBrand(c.getBrand());
                }
                if (c.getProcesor() != null) {
                    cloneExist.get().setProcesor(c.getProcesor());
                }
                if (c.getOs() != null) {
                    cloneExist.get().setOs(c.getOs());
                }
                if (c.getDescription() != null) {
                    cloneExist.get().setDescription(c.getDescription());
                }
                if (c.getMemory() != null) {
                    cloneExist.get().setMemory(c.getMemory());
                }
                if (c.getHardDrive() != null) {
                    cloneExist.get().setHardDrive(c.getHardDrive());
                }
                if (c.getPhotography() != null) {
                    cloneExist.get().setPhotography(c.getPhotography());
                }
                return cloneRepository.save(c);
            } else {
                return c;
            }
        } else {
            return c;
        }
    }

    public boolean deleteById(Integer id) {
        Boolean aBoolean = cloneRepository.getCloneById(id).map(clone -> {
            cloneRepository.deleteById(id);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}