package com.usa.ciclo4.app.services;

import com.usa.ciclo4.app.model.Clone;
import com.usa.ciclo4.app.model.User;
import com.usa.ciclo4.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id){
        return userRepository.getUserById(id);
    }

    public boolean getUserByEmail(String email) {
        return userRepository.getUserByEmail(email).isPresent();
    }

    public User getUserByEmailAndPassword(String email, String password) {
        Optional<User> userExist = userRepository.getUserByEmailAndPassword(email, password);
        if (userExist.isPresent()) {
            return userExist.get();
        } else {
            return new User();
        }
    }

    public List<User> getUsersByMonthBirthtDay(String monthBirthtDay){
        return userRepository.getUsersByMonthBirthtDay(monthBirthtDay);
    }

    public User save(User u) {

        Optional<User> userIdMax = userRepository.lastUserId();

        if(u.getId()==null){
            if (userIdMax.isEmpty())
                u.setId(1);
            else
                u.setId(userIdMax.get().getId() + 1);
        }

        if (u.getName() == null || u.getEmail() == null || u.getPassword() == null || u.getIdentification() == null || u.getType() == null) {
            return u;
        } else {
            List<User> existUser = userRepository.getUsersByNameOrEmail(u.getName(), u.getEmail());
            if (existUser.isEmpty()) {
                if (u.getId() == null) {
                    return userRepository.save(u);
                } else {
                    Optional<User> existUserId = userRepository.getUserById(u.getId());
                    if (existUserId.isEmpty()) {
                        return userRepository.save(u);
                    } else {
                        return u;
                    }
                }
            } else {
                return u;
            }
        }
    }

    public User update(User u) {
        if (u.getId() != null) {
            Optional<User> userExist = userRepository.getUserById(u.getId());
            if (userExist.isPresent()) {
                if (u.getIdentification() != null) {
                    userExist.get().setIdentification(u.getIdentification());
                }
                if (u.getName() != null) {
                    userExist.get().setName(u.getName());
                }
                if (u.getAddress() != null) {
                    userExist.get().setAddress(u.getAddress());
                }
                if (u.getCellPhone() != null) {
                    userExist.get().setCellPhone(u.getCellPhone());
                }
                if (u.getEmail() != null) {
                    userExist.get().setEmail(u.getEmail());
                }
                if (u.getPassword() != null) {
                    userExist.get().setPassword(u.getPassword());
                }
                if (u.getZone() != null) {
                    userExist.get().setZone(u.getZone());
                }
                if (u.getType() != null) {
                    userExist.get().setType(u.getType());
                }
                return userRepository.save(u);
            } else {
                return u;
            }
        } else {
            return u;
        }
    }

    public boolean deleteById(Integer id) {
        Boolean aBoolean = userRepository.getUserById(id).map(user -> {
            userRepository.deleteById(id);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}