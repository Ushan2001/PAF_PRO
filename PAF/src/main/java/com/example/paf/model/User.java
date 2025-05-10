package com.example.paf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String imageUrl;
    private String providerId;
    private String provider;

    // Constructor with fields excluding id (for new user creation)
    public User(String name, String email, String imageUrl, String providerId, String provider) {
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        this.providerId = providerId;
        this.provider = provider;
    }

}
