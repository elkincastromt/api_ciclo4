package com.usa.ciclo4.app.repositories;

import com.usa.ciclo4.app.model.Clone;
import com.usa.ciclo4.app.model.User;
import com.usa.ciclo4.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }

    public User save(User u){
        return userCrudRepository.save(u);
    }

    public Optional<User> getUserByName(String name){
        return userCrudRepository.findByName(name);
    }

    public Optional<User> getUserByEmail(String email){
        return userCrudRepository.findByEmail(email);
    }

    public List<User> getUsersByNameOrEmail (String name, String email){
        return userCrudRepository.findByNameOrEmail(name, email);
    }

    public Optional<User> getUserByEmailAndPassword(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public Optional<User> getUserById(Integer id){
        return userCrudRepository.findById(id);
    }

    public void deleteById (Integer id){
        userCrudRepository.deleteById(id);
    }

    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }

    public List<User> getUsersByMonthBirthtDay(String monthBirthtDay){
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }

}
