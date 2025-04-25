package com.example.paf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class CommentDTO {
    private int id;
    private int postId;
    private String comment;
    private LocalDateTime date;
}
