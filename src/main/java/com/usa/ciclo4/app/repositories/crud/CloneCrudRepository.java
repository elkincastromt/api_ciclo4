package com.usa.ciclo4.app.repositories.crud;

import com.usa.ciclo4.app.model.Clone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CloneCrudRepository extends MongoRepository<Clone,Integer> {
    Optional<Clone> findTopByOrderByIdDesc();

    @Query("{description: /?0/}")
    List<Clone> findByDescriptionLike(final String description);

    List<Clone> findByPriceLessThanEqual(final Double price);

}
