package com.example.demo.repository;

import com.example.demo.models.user;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<user, String> {
    // Define custom queries if needed


}
