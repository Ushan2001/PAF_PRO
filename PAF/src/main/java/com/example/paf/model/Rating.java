package com.example.paf.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Rating {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int postid;
    private int level;
}
