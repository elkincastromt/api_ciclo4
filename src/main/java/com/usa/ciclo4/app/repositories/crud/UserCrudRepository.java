package com.usa.ciclo4.app.repositories.crud;

import com.usa.ciclo4.app.model.Order;
import com.usa.ciclo4.app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends MongoRepository<User, Integer> {

    public Optional<User> findByName(String name);
    public Optional<User> findByEmail(String email);

    public List<User> findByNameOrEmail(String name, String email);

    public Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findTopByOrderByIdDesc();

    @Query("{'monthBirthtDay': ?0}")
    List<User> findByMonthBirthtDay(final String monthBirthtDay);
}
