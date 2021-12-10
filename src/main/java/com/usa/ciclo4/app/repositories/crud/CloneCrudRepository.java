package com.usa.ciclo4.app.repositories.crud;

import com.usa.ciclo4.app.model.Clone;
import com.usa.ciclo4.app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CloneCrudRepository extends MongoRepository<Clone,Integer> {
    Optional<Clone> findTopByOrderByIdDesc();
}
