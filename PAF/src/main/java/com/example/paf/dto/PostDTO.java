package com.example.paf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PostDTO {
    private int id;
    private String title;
    private String description;
    private String imageUrl;
}
