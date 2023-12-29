package com.example.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "projets")
public class Projet {
    @Id
    private String projectId;

    private String projectName;

    private List<Tache> taches;

    private List<User> membres;

    // Other project-related properties, constructors, getters, and setters
}






