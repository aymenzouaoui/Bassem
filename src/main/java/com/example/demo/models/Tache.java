package com.example.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "taches")
public class Tache {
    @Id
    private String id;
    private String titre;
    private String description;
    private Category category;
    private Date dateEchec;
    private boolean etats ;

    private boolean isInTrash; // This field indicates if the task is in the trash

    // Constructors, getters, setters, etc.
}
