package com.usa.ciclo4.app.controllers;

import com.usa.ciclo4.app.model.User;
import com.usa.ciclo4.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {

    @Autowired
    private UserService UserService;

    @GetMapping("/all")
    public List<User> getUsers(){
        return UserService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getClient(@PathVariable("id") int id){
        return UserService.getUser(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User u){
        return UserService.save(u);
    }

    @GetMapping("/emailexist/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return UserService.getUserByEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User existUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return UserService.getUserByEmailAndPassword(email, password);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User u){
        return UserService.update(u);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return UserService.deleteById(id);
    }

}
