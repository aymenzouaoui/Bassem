package com.example.demo.repository;

import com.example.demo.models.Tache;
import com.example.demo.models.user;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends MongoRepository<user, String> {
    // Define custom queries if needed


}
