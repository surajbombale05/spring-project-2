package com.example.crudspring.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.crudspring.model.User;

public interface UserRepo extends MongoRepository<User, String>{
     @Query("{ 'name': { '$regex': ?0, '$options': 'i' } }")
     List<User> findByName(String name);
}
