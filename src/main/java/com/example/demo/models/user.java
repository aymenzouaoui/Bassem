package com.example.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users") // Specify the collection name
public class user {
    @Id // Use @Id annotation to specify the primary key field
    private String id; // MongoDB uses ObjectId as the primary key by default
    private String fullName; // Use camelCase for field names
    private String cin;
    private String role;
    private String phone; // Use String for phone number to handle non-numeric values

    // Constructors, getters, setters, etc.
}
