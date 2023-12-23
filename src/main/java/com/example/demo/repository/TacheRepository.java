package com.example.demo.repository;

import com.example.demo.models.Tache;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TacheRepository extends MongoRepository<Tache, String> {

    // Assuming 'dateEchec' is stored as a java.util.Date in MongoDB
    // You will need a custom query annotation to handle the conversion
    // from LocalDate to java.util.Date for the query
    @Query("{ 'dateEchec' : { $eq: ?0 } }")
    List<Tache> findByDateEchec(LocalDate dateEchec);

    // Assuming 'category' is a field of the stored Tache document
    // and it's a String
    List<Tache> findByCategory(String category);

    // For finding by category and date, you will also need a custom query
    // with both parameters
    @Query("{ 'category' : ?0, 'dateEchec' : { $eq: ?1 } }")
    List<Tache> findByCategoryAndDateEchec(String category, LocalDate dateEchec);

    // Additional repository methods for the statistics
    // Assuming 'etats' is a boolean field in the Tache document
    long countByEtats(boolean etat);

    // Assuming 'dateEchec' is a field of the stored Tache document
    // You will need a custom query to find tasks that are overdue (i.e., dateEchec has passed)
    @Query("{ 'dateEchec' : { $lt: ?0 }, 'etats' : false }")
    long countByDateEchecBeforeAndEtats(Date now, boolean etat);


    List<Tache> findByIsInTrash(boolean isInTrash);
}
