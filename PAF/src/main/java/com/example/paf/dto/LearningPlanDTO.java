package com.example.paf.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LearningPlanDTO {
    private int id;
    private String imageUrl;
    private String title;
    private String description;
    private String pdfUrl;
}
