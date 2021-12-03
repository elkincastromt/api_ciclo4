package com.usa.ciclo4.app.repositories.crud;

import com.usa.ciclo4.app.model.Clone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CloneCrudRepository extends MongoRepository<Clone,Integer> {

}
