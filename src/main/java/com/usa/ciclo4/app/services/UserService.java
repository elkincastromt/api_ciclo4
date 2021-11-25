package com.usa.ciclo4.app.services;

import com.usa.ciclo4.app.model.User;
import com.usa.ciclo4.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository  userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public boolean getUserByEmail(String email){
        return userRepository.getUserByEmail(email).isPresent();
    }

    public User getUserByEmailAndPassword(String email, String password){
        Optional<User> userExist=userRepository.getUserByEmailAndPassword(email, password);
        if(userExist.isPresent()){
            return userExist.get();
        }else{
            return new User(null, email, password,"NO DEFINIDO");
        }
    }

    public User save(User u){
        if(u.getName()==null || u.getEmail()==null || u.getPassword()==null){
            return u;
        }else{
            List<User> existUser=userRepository.getUsersByNameOrEmail(u.getName(), u.getEmail());
            if(existUser.isEmpty()){
                if(u.getId()==null){
                    return userRepository.save(u);
                }else{
                    Optional<User> existUserId = userRepository.getUserById(u.getId());
                    if(existUserId.isEmpty()){
                        return userRepository.save(u);
                    }else{
                        return u;
                    }
                }
            }else{
                return u;
            }
        }
    }

}
